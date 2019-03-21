package controller;

public class ConvertBinary implements ConvertStrategy{

	@Override
	public String convert(short value, int size) {
		String binary = Integer.toBinaryString(value);
		return extend(binary, size);
	}
	
	private String extend(String binary, int size) {
		String binaryExtended = binary;
		if(size > binary.length()) {
			for(int i = 0; i < size - binary.length(); i++) {
				binaryExtended = "0" + binaryExtended;
			}
		}else {
			binaryExtended = binaryExtended.substring(binaryExtended.length()-size);
		}
		
		return binaryExtended;
	}
}
