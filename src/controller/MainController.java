package controller; 

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import view.*;

public class MainController {
	
	private SeqMultiplicationGUI seqView;
//private Register register;
	
	public MainController(SeqMultiplicationGUI sv) {
		this.seqView = sv;
		seqView.listenerForBtnLoad(new BtnLoadActionListener());
		seqView.listenerForBtnReset(new BtnResetActionListener());
		seqView.listenerForBtnCycle(new BtnCycleActionListener());
		seqView.listenerForBtnRun(new BtnRunActionListener());
	}

	public boolean validInput() {
		String input = seqView.getInputM() + seqView.getInputQ();
		int i = 0;
		char one = '1';
		char zero = '0';
		
		
		while(i<input.length()) {
			if(input.charAt(i) != one && input.charAt(i) != zero) {
				return false;
			}else {
				i++;
			}
		}
		
		return true;
	}
	
	class BtnLoadActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			if(!validInput()) {
				JOptionPane.showMessageDialog(seqView, "Invalid Input!");
			}else if(seqView.getInputM().equalsIgnoreCase("") || seqView.getInputQ().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(seqView, "Invalid!");
			}else {
				seqView.getTabbedPane().setSelectedIndex(1);
			}
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
