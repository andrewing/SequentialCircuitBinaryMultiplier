package model;

public class Register {
	private int size;
	private int content;
	
	public Register(int content) {
		this.content = content;
	}
	
	public Register(String content) {
		this.content = Integer.parseInt(content,2);
		this.size = content.length();
	}

	public int shiftRight(int insert) {
		int removed = getBit(0);
		content >>= 1;
		content |= insert*(int)Math.pow(2, size-1);
		return removed;
	}
	
	public int shiftRightArithmetic() {
		return shiftRight(getBit(size-1));
	}
	
	public int getBit(int position) {
		return (content >> position) & 1;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}
	
	public static void main(String[] args) {
		Register a = new Register(Integer.parseInt("0000",2));
		
		Register q = new Register(Integer.parseInt("11010",2));
		q.setSize("01010".length());
		System.out.println(Integer.toBinaryString(q.getContent()));
		System.out.println(q.getSize());
		q.shiftRightArithmetic();
		System.out.println(Integer.toBinaryString(q.getContent()));
	}
	
}
