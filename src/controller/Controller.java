package controller; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.*;

public class Controller {
	
	private SeqMultiplicationGUI seqView;
	
	public Controller(SeqMultiplicationGUI sv) {
		this.seqView = sv;
		seqView.listenerForBtnLoad(new BtnLoadActionListener());
		seqView.listenerForBtnReset(new BtnResetActionListener());
		seqView.listenerForBtnCycle(new BtnCycleActionListener());
		seqView.listenerForBtnRun(new BtnRunActionListener());
	}
	
	class BtnLoadActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			seqView.getTabbedPane().setSelectedIndex(1);
		}
	}
	
	class BtnResetActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			seqView.resetInput();
		}
	}
	
	class BtnCycleActionListener implements ActionListener{
		int count = 0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
			seqView.setLblCount(count+"");
		}
	}
	
	class BtnRunActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
	}
	
	
	
}
