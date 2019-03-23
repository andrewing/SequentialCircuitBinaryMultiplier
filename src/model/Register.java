package model;

import java.util.*;

import controller.BitUtil;

public class Register {
	private int size;
	private String value;
	
	public Register(String value) {
		this.value = value;
		this.size = value.length();
	}
	
	public Register(int value) {
		this.value = Integer.toBinaryString(value);
	}
	
	public char shiftRight(char insert) {
		char removed = value.charAt(size-1);
		value = insert + value;
		value = value.substring(0, size);
		return removed;
	}

	public char shiftArithmeticRight() {
		return shiftRight(value.charAt(0));
	}
	
	public char shiftLogicalRight() {
		return shiftRight('0');
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		fit();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void fit() {
		if(value.length()>size)
			value = value.substring(value.length() - size);
		else
			value = BitUtil.extend(value, size, '0');
	}
	
	
	public static void main(String[] args) {
		List<Register> registers = new ArrayList<>();
		
		Register m = new Register("1010");
		Register mneg = new Register(-BitUtil.getStringValue(m.getValue()));
		mneg.setSize(m.getSize());
		Register a = new Register("10011");
		Register q = new Register("01101");
		Register qneg = new Register("0");
		registers.add(m);
		registers.add(mneg);
		registers.add(a);
		registers.add(q);
		registers.add(qneg);

		int index = a.getValue().length() -1;
		
		System.out.println(a.getValue());
		System.out.println(q.getValue());
		System.out.println(qneg.getValue());
		System.out.println(a.getValue().charAt(index));
		System.out.println(a.getValue());
		System.out.println(q.getValue());
	}
}
