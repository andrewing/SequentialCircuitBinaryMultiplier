package controller;

public class ConvertDecimal implements ConvertStrategy{

	@Override
	public String convert(short value, int size) {
		int binary = value;
		if(BitUtil.getBit(value, size-1) == 1) {
			binary = ~binary + 1;
		}
		return null;
		
	}
	
	
}
