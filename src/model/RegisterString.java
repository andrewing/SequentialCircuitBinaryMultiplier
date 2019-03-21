package model;

public class RegisterString {
	private int size;
	private String value;
	
	public RegisterString(String value) {
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
		RegisterString a = new RegisterString("1000");
		a.shiftArithmeticRight();
		System.out.println(a.getValue());
				
				
	}
}
