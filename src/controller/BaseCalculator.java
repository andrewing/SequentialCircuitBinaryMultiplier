package controller;

public class BaseCalculator {
	private ConvertStrategy strategy;
	
	public String convert(short value,int size) {
		return strategy.convert(value, size);
	}
	
	public void setStrategy(ConvertStrategy strategy) {
		this.strategy = strategy;
	}
	
	public static void main(String[] args) {
		BaseCalculator a = new BaseCalculator();
		a.setStrategy(new ConvertBinary());
		System.out.println(a.convert((short) -12, 6));
	}
}
