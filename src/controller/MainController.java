package controller; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.*;

public class MainController {
	
	private SeqMultiplicationGUI seqView;
	
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
	
	public String getMPrime(String input) {

		StringBuilder mprime = new StringBuilder(input);
		String flip = "";
		String result = "";
		char one = '1';
		char zero = '0';
		int index = 0;
		
		for(int k=input.length() - 1; k>=0; k--) {
			if(input.charAt(k) != 1) {
				flip = flip + input.charAt(k);
			}
		}
		
		for(int i=0; i<flip.length(); i++) {
			if(flip.charAt(i) == one){
				index = i;
			}
		}
		
		System.out.println(index);
		
				
	/*	for(int j=0; j<flip.length(); j++) {
			if(j != index) {
				if(flip.length() == one) {
					mprime.setCharAt(j, one);
				}else {
					mprime.setCharAt(j, zero);
				}
			}else {
				
			}
		}*/
		
		
		
		return flip;
	}
	
	class BtnLoadActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(!validInput()) {
				JOptionPane.showMessageDialog(seqView, "Invalid Input!");
				seqView.resetInput();
			}else {
				seqView.getTabbedPane().setSelectedIndex(1);
				seqView.setOutputM(seqView.getInputM());
				seqView.setOutputQ(seqView.getInputQ());
				seqView.setOutputMPrime(getMPrime(seqView.getInputM()));
				seqView.setOutputA("000000");	
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
