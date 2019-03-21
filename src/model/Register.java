package model;

public class Register {
	private int size;
	private String value;
	
	public Register(String value) {
		this.value = value;
		this.size = value.length();
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
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		Register a = new Register("1001");
		Register b = new Register("0100");
		b.shiftRight(a.shiftArithmeticRight());
		System.out.println(a.getValue());
		System.out.println(b.getValue());
				
	}
}
