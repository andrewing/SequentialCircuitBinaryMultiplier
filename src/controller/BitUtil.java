package controller;

public class BitUtil {
	
	public static int getBit(short value, int position) {
		return (value >> position) & 1;
	}
	
	public static short getValue(short value, short size) {
		String val = Integer.toBinaryString(value);
		if(val.length() > size) {
			val = val.substring(val.length() - size);
		}
		return signExtend((short)Integer.parseInt(val,2), size);
	}
	
	public static short signExtend(short value, short size) {
		String val = Integer.toBinaryString(value);
		int len = val.length();
		System.out.println(len);
		
		char bit = '0';
		
		if(val.length() < size) {
			bit = '0';
		}else if(val.charAt(0)=='1') {
			bit = '1';
		}
		System.out.println(val);
		
		for(int i = 0; i < Short.SIZE - len; i++) {
			val = bit + val;
		}
		
		return (short)Integer.parseInt(val, 2);
	}
	
	public static short maxSize(short...sizes) {
		short max = sizes[0];
		for(short size: sizes) {
			if(size > max) 
				max = size;
		}
		return max;
	}
}
