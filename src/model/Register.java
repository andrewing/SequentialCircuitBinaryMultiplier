package model;

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
	
	public void minimumBits() {
		
		while(value.length() != 1 && value.charAt(0) == value.charAt(1)) {
			value = value.substring(1, value.length());
		}
		size = value.length();
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
			value = BitUtil.signExtend(value, size);
	}
}
