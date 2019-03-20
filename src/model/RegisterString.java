package model;

public class RegisterString {
	private int size;
	private String binary;
	public RegisterString(String binary) {
		this.binary = binary;
		this.size = binary.length();
	}
	
	public char shiftRight(char insertLeft) {
		binary = insertLeft + binary;
		char removed = binary.charAt(size);
		binary = binary.substring(0, size);
		return removed;
	}
	
	public char shiftRightLogical() {
		return shiftRight('0');
	}
	
	public char shiftRightArithmetic() {
		return shiftRight(binary.charAt(0));
	}
	
	public char bitAt(int place) {
		return binary.charAt(place);
	}

	public int getSize() {
		return size;
	}

	public String getBinary() {
		return binary;
	}
	
	public int getBinaryAsValue() {
		return Integer.parseInt(binary, 2);
	}

	public void setBinary(String binary) {
		this.binary = binary;
		this.size = binary.length();
	}
	
	public static void main(String[] args) {
		RegisterString a = new RegisterString("0010");
		System.out.println(a.getBinary());
		System.out.println(a.getSize());
		System.out.println(a.shiftRightArithmetic());
		System.out.println(a.getBinary());
	}
	
}
