package model;

import controller.BaseCalculator;
import controller.BitUtil;
import controller.ConvertBinary;
import controller.ConvertStrategy;

public class Register {
	private short size;
	private short content;
	
	public Register(short content) {
		this.content = content;
	}
	
	public Register(int content) {
		this((short)content);
	}
	
	public Register(String content) {
		this((short)Integer.parseInt(content,2));
		this.size = (short)content.length();
		this.content = BitUtil.signExtend(this.content, this.size);
	}

	public int shiftRight(int insert) {
		int removed = BitUtil.getBit(content, 0);
		content >>= 1;
		if(insert == 1)
			content |= insert*(int)Math.pow(2, size-1);
		else
			content &= insert*(int)Math.pow(2, size-1);

		return removed;
	}
	
	public int shiftRightArithmetic() {
		return shiftRight(BitUtil.getBit(content, size-1));
	}

	
	public short getSize() {
		return size;
	}

	public void setSize(short size) {
		this.size = size;
	}

	public short getContent() {
		return content;
	}

	public void setContent(short content) {
		this.content = content;
	}
	
	public static void main(String[] args) {
		
		Register a = new Register(0);
		Register qneg = new Register(0b0);
		Register m = new Register("10100");
		Register q = new Register("10100");
		Register mprime = new Register("10101");
		short size = BitUtil.maxSize(a.getSize(), qneg.getSize(), m.getSize(), q.getSize());
		
		BaseCalculator bbb = new BaseCalculator();
		bbb.setStrategy(new ConvertBinary());
		System.out.println(m.getContent());
		//System.out.println(q.getContent());
		
		m.setContent((short) (m.getContent() + q.getContent()));
		System.out.println(BitUtil.getValue(m.getContent(), m.getSize()));
		//System.out.println(Integer.toBinaryString(m.getContent()));
		//System.out.println(bbb.convert(m.getContent(), m.getSize()));
		//System.out.println(m.getContent());
		
	}
	
}
