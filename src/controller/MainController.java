package controller; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import view.*;
import model.*;

public class MainController {
	
	private SeqMultiplicationGUI seqView;
	private Register reg;
	private SequentialBinaryMultiplier mul;
//private Register register;
	
	public MainController(SeqMultiplicationGUI sv) {
		this.seqView = sv;
		this.mul = new SequentialBinaryMultiplier();
		
		seqView.listenerForBtnLoad(new BtnLoadActionListener());
		seqView.listenerForBtnReset(new BtnResetActionListener());
		seqView.listenerForBtnCycle(new BtnCycleActionListener());
		seqView.listenerForBtnRun(new BtnRunActionListener());
		seqView.listenerForBtnStep(new BtnStepActionListener());
		seqView.listenerForInputMTxtField(docListener);
		seqView.listenerForInputQTxtField(docListener);
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
	
	public void setOutputRegisters() {
		seqView.setOutputA(mul.getRegAValue());
		seqView.setOutputM(mul.getRegMValue());
		seqView.setOutputMPrime(mul.getRegMNegValue());
		seqView.setOutputQ(mul.getRegQValue());
		seqView.setOutputQNeg(mul.getRegQNegValue());
	}
	
	DocumentListener docListener = new DocumentListener(){
		
		public void nullInput() {
			if(seqView.getInputM().equalsIgnoreCase("") || seqView.getInputQ().equalsIgnoreCase("")) {
				seqView.getBtnLoad().setEnabled(false);
			}else if(!validInput()) {
				seqView.getBtnLoad().setEnabled(false);
			}else {
				seqView.getBtnLoad().setEnabled(true);
			}
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {nullInput();}

		@Override
		public void removeUpdate(DocumentEvent e) {nullInput();}

		@Override
		public void changedUpdate(DocumentEvent e) {nullInput();}
		
	};
	
	
	
	
	class BtnLoadActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mul.initRegisters(seqView.getInputM(), seqView.getInputQ());
			seqView.getTabbedPane().setSelectedIndex(1);
			setOutputRegisters();
		}
	}
	
	class BtnResetActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			seqView.resetInput();
		}
	}
	
	class BtnCycleActionListener implements ActionListener{
		int ctr = 0;
		int ct = 1;
		
		@Override
		public void actionPerformed(ActionEvent e) {
	
			ctr+=2;
			if(ctr % 2 ==0) {
				seqView.setLblCount(ct+"");
				ct++;
			}
			
			if(ctr == mul.getTotalSteps()) {
				seqView.getBtnCycle().setEnabled(false);
			}
			
			mul.cycle();
			setOutputRegisters();
			
		}
	}
	
	class BtnStepActionListener implements ActionListener{
		int ctr = 0 ;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			ctr++;
			if(ctr == mul.getTotalSteps()) {
				seqView.getBtnStep().setEnabled(false);
			}
			
			mul.step();
			setOutputRegisters();
		}
	}
	
	class BtnRunActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			seqView.getBtnCycle().setEnabled(false);
			seqView.getBtnStep().setEnabled(false);
			mul.run();
			seqView.setLblCount(mul.getTotalCycle()+"");
			setOutputRegisters();
			
		}
	}	
}
