package model;
import java.util.*;

import controller.BitUtil;
public class SequentialBinaryMultiplier {
	private ArrayList<Register> registers;
	
	
	public SequentialBinaryMultiplier(){
		this.registers = new ArrayList<Register>();
	}
	
	public void initRegisters(String m, String q) {
		Register regM = new Register(m);
		Register regMNeg = new Register(-BitUtil.getStringValue(regM.getValue()));
		Register regQ = new Register(q);
		Register regQNeg = new Register("0");
		Register regA = new Register("10011");
		
		int max = getMaxSize(regM, regQ);
		
		regM.setSize(max);
		regMNeg.setSize(max);
		regQ.setSize(max);
		regA.setSize(max);
		
		registers.add(regM);       //0
		registers.add(regMNeg);    //1
		registers.add(regQ);       //2
		registers.add(regQNeg);    //3
		registers.add(regA);       //4
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
		registers.get(4).setValue(Integer.toBinaryString(sum));
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
	
	public String getRegQValue() {
		return registers.get(2).getValue();
	}
	
	public String getRegQNegValue() {
		return registers.get(3).getValue();
	}
	
	public String getRegAValue() {
		return registers.get(4).getValue();
	}

	public void step() {
		
	}
	
	public void cycle() {
		
	}
	
	public void run() {
		
	}
	
	public static void main(String args[]) {
		String m = "10011";
		String q = "01101";
		
		SequentialBinaryMultiplier mul = new SequentialBinaryMultiplier();
	/*	mul.initRegisters(m, q);
		System.out.println(mul.getRegAValue());
		mul.add();
		System.out.println(mul.getRegAValue());*/
		mul.initRegisters(m, q);
		System.out.println(mul.getRegAValue());
		System.out.println(mul.getRegQValue());
		System.out.println(mul.getRegQNegValue());
		mul.shiftRegisters();
		System.out.println(mul.getRegAValue());
		System.out.println(mul.getRegQValue());
		System.out.println(mul.getRegQNegValue());
		
		
	}
}
