package mainDriver;

import controller.MainController;
import view.SeqMultiplicationGUI;

public class SequentialDriver {
	public static void main(String args[]) {
		SeqMultiplicationGUI seq = new SeqMultiplicationGUI();
		@SuppressWarnings("unused")
		MainController controller = new MainController(seq);
	}
}
