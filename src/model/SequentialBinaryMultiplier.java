package model;
import java.util.*;

import controller.BitUtil;
public class SequentialBinaryMultiplier {
	private ArrayList<Register> registers;
	private ArrayList<String> alist;
	private ArrayList<String> qlist;
	int totalSteps;
	int stepCtr;
	int stepNumber;
	
	public SequentialBinaryMultiplier(){
		this.registers = new ArrayList<Register>();
		this.qlist = new ArrayList<>();
		this.alist = new ArrayList<>();
	}
	
	public void initRegisters(String m, String q) {
		
		
		Register regM = new Register(m);
		Register regMNeg = new Register(-BitUtil.getStringValue(regM.getValue()));
		Register regQ = new Register(q);
		Register regQNeg = new Register("0");
		Register regA = new Register("0");
		regQ.minimumBits();
		regM.minimumBits();
	


		if(regM.getValue().equalsIgnoreCase(regMNeg.getValue())) {

//		System.out.println(regM.getValue());
//		System.out.println(regMNeg.getValue());
		if(regM.getValue().equalsIgnoreCase(regMNeg.getValue()) && regM.getValue().equalsIgnoreCase("0")) {
			
		}else if(regM.getValue().equalsIgnoreCase(regMNeg.getValue())) {

			regM.setValue("1" + regM.getValue());
			regMNeg.setValue("0"+regMNeg.getValue());
			regM.setSize(regM.getSize()+1);
		}
		if(regM.getValue().charAt(0) == '1') {
			regMNeg.setValue("0"+regMNeg.getValue());
		} 
		
		
		
		int max = getMaxSize(regM, regQ);
		stepCtr = 0;
		stepNumber = 1;
		this.totalSteps = getMaxSize(regM, regQ) *2;
		
		
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
	}
	
	public int getMaxSize(Register m, Register q) {
		
		if(m.getSize() > q.getSize()) {
			return m.getSize();
		}else {
			return q.getSize();
		}
	}
	
	public void add() {
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
		registers.get(4).setValue("0"+Integer.toBinaryString(sum));
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
		
		qlist.add(registers.get(2).getValue());
		alist.add(registers.get(4).getValue());
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
	
	public ArrayList<String> getAlist() {
		return alist;
	}

	public void setAlist(ArrayList<String> alist) {
		this.alist = alist;
	}

	public ArrayList<String> getQlist() {
		return qlist;
	}

	public void setQlist(ArrayList<String> qlist) {
		this.qlist = qlist;
	}
	
	
	public int getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
}
