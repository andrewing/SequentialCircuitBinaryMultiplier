package model;

import controller.BaseCalculator;
import controller.BitUtil;
import controller.ConvertBinary;
import controller.ConvertStrategy;

public class RegisterShort {
	private short size;
	private short content;
	
	public RegisterShort(short content) {
		this.content = content;
	}
	
	public RegisterShort(int content) {
		this((short)content);
	}
	
	public RegisterShort(String content) {
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
			content &= (int)Math.pow(2, size-1) - 1;

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
		
		RegisterShort a = new RegisterShort(0);
		RegisterShort qneg = new RegisterShort(0);
		qneg.setSize((short)1);
		RegisterShort m = new RegisterShort("1111100001111000");
//		Register q = new Register("111000000000111");
		
//		Register mprime = new Register(-m.getContent());
//		mprime.setSize(m.getSize());
//		
//		short size = 15;
//		a.setSize(size);
//		m.setSize(size);
//		q.setSize(size);
//		mprime.setSize(size);
//		
//		System.out.println(a.getContent());
//		System.out.println(qneg.getContent());
//		System.out.println(m.getContent());
//		System.out.println(q.getContent());
//		System.out.println(mprime.getContent());
//	
//		BaseCalculator bc = new BaseCalculator();
//		bc.setStrategy(new ConvertBinary());
//		
//		System.out.println(bc.convert(a.getContent(), a.getSize()));
//		System.out.println(bc.convert(q.getContent(), q.getSize()));
//		System.out.println(bc.convert(qneg.getContent(), qneg.getSize()));
//		
//		
//		System.out.println(bc.convert(m.getContent(), m.getSize()));
//		System.out.println(bc.convert(mprime.getContent(), mprime.getSize()));
//		
//		qneg.shiftRight(q.shiftRight(a.shiftRightArithmetic()));
//		
//		System.out.println();
//		System.out.println(bc.convert(a.getContent(), a.getSize()));
//		System.out.println(bc.convert(q.getContent(), q.getSize()));
//		System.out.println(bc.convert(qneg.getContent(), qneg.getSize()));
//		System.out.println(bc.convert(m.getContent(), m.getSize()));
//		System.out.println(bc.convert(mprime.getContent(), mprime.getSize()));
		
	}
	
}
