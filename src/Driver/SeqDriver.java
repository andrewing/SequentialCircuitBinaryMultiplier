package Driver;
import controller.MainController;
import view.SeqMultiplicationGUI;

public class SeqDriver {
	public static void main(String args[]) {
		SeqMultiplicationGUI frame = new SeqMultiplicationGUI();
		MainController control = new MainController(frame);
	}
}
