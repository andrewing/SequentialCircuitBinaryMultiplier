package model;
import java.util.*;

import controller.BitUtil;
public class SequentialBinaryMultiplier {
	private ArrayList<Register> registers;
	int totalSteps;
	int stepCtr;
	
	
	public SequentialBinaryMultiplier(){
		this.registers = new ArrayList<Register>();
	}
	
	public void initRegisters(String m, String q) {

		
		Register regM = new Register(m);
		
	//	System.out.println(BitUtil.getStringValue(regM.getValue()));
		Register regQ = new Register(q);
	//	System.out.println(BitUtil.getStringValue(regQ.getValue()));
		int mneg = -BitUtil.getStringValue(regM.getValue());
		Register regMNeg = new Register(BitUtil.format(mneg));
		Register regQNeg = new Register("0");
		Register regA = new Register("0");
		
		regM.minimumBits();
		regQ.minimumBits();
		
		System.out.println(regM.getValue());
		System.out.println(regQ.getValue());
		
		stepCtr = 0;
		this.totalSteps = getMaxSize(regM, regQ) *2;
		int max = getMaxSize(regM, regQ);
		regM.setSize(max);
		regMNeg.setSize(max);
		regQ.setSize(max);
		regA.setSize(max);
		
		registers.add(regM);
		registers.add(regMNeg);
		registers.add(regQ);
		registers.add(regQNeg);
		registers.add(regA);
	}
	
	public int getMaxSize(Register m, Register q) {
		
		if(m.getSize() > q.getSize()) {
			return m.getSize();
		}else {
			return q.getSize();
		}
	}
	
	public void add() {
		String mVal = registers.get(0).getValue();
		String mneg = registers.get(1).getValue();
		String q = registers.get(2).getValue();
		String qNeg = registers.get(3).getValue();
		short m = BitUtil.getStringValue(registers.get(0).getValue());
		short mNeg = BitUtil.getStringValue(registers.get(1).getValue()); 
		short a = BitUtil.getStringValue(registers.get(4).getValue());
		short sum = a;
		
		if(q.charAt(q.length()-1) == '1' && qNeg.equalsIgnoreCase("0")) {
			sum = (short) (a + mNeg);
		
		}else if(q.charAt(q.length()-1) == '0' && qNeg.equalsIgnoreCase("1")) {
			sum = (short) (a + m);
			
		}
		
		if(mVal.equalsIgnoreCase(mneg)) {
			registers.get(4).setValue(Integer.toBinaryString(sum));
			
		}else {
			registers.get(4).setValue(BitUtil.format(sum));
		}
		registers.get(4).fit();
	}
	
	public void shiftRegisters() {
		
		Register a = registers.get(4);
		Register q = registers.get(2);
		Register qneg = registers.get(3);
		
		qneg.shiftRight(q.shiftRight(a.shiftArithmeticRight()));
	}
	
	public String getRegMValue() {
		return registers.get(0).getValue();
	}
	
	public String getRegMNegValue() {
		return registers.get(1).getValue();
	}
	
	public String getRegQValue() {
		return registers.get(2).getValue();
	}
	
	public String getRegQNegValue() {
		return registers.get(3).getValue();
	}
	
	public String getRegAValue() {
		return registers.get(4).getValue();
	}
	
	public int getTotalSteps() {
		return this.totalSteps;
	}
	
	public int getTotalCycle() {
		return this.totalSteps/2;
	}
	
	public int getStepCtr() {
		return this.stepCtr;
	}

	public void step() {
		
		if(stepCtr % 2 == 0 && stepCtr <= totalSteps) {
			add();
			stepCtr++;
			
		}else if(stepCtr % 2 != 0 && stepCtr <= totalSteps) {
			shiftRegisters();
			stepCtr++;
		}else if(stepCtr == totalSteps) {
			System.out.println("sakto");
		}
		
	}
	
	public void cycle() {
		
		if(stepCtr % 2 == 0 && stepCtr <= totalSteps) {
			add();
			shiftRegisters();
			stepCtr += 2;
		}else if(stepCtr % 2 != 0 && stepCtr <= totalSteps) {
			shiftRegisters();
			stepCtr++;
		}
	}
	
	public void run() {
		
		if(stepCtr % 2 == 0) {
			int ctr = (this.totalSteps-stepCtr)/2 ;
			while(ctr != 0) {
				cycle();
				ctr--;
			}
		}else if(stepCtr % 2 != 0) {
			step();
			int ctr = (this.totalSteps-stepCtr)/2 ;
			while(ctr != 0) {
				cycle();
				ctr--;
			}	
		}
	}
}
