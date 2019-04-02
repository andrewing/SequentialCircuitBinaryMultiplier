package controller;

public class BitUtil {
	public static String extend(String value, int size, char bit) {
		String extendedValue = value;
		
		if(value.length() < size) {
			for(int i = 0; i < size - value.length(); i++) {
				extendedValue = bit + extendedValue;
			}
		}
		return extendedValue;
	}
	
	public static String signExtend(String value, int size) {
		return extend(value, size, value.charAt(0));
	}
	
	public static int getStringValue(String value) {
		String val = value;
//		if(value.length() < Integer.SIZE)
//			val = signExtend(value, Integer.SIZE);
		return /*(short)*/ Integer.parseInt(val, 2);
	} 
	

	
}
