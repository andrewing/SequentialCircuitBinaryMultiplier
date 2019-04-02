package controller; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import view.*;
import model.*;

public class MainController {
	
	private SeqMultiplicationGUI seqView;
	private SequentialBinaryMultiplier mul;
	private int ctr;
	private int ct;
	
	public MainController(SeqMultiplicationGUI sv) {
		this.seqView = sv;
		
		seqView.listenerForBtnLoad(new BtnLoadActionListener());
		seqView.listenerForBtnReset(new BtnResetActionListener());
		seqView.listenerForBtnCycle(new BtnCycleActionListener());
		seqView.listenerForBtnRun(new BtnRunActionListener());
		seqView.listenerForBtnStep(new BtnStepActionListener());
		seqView.listenerForInputMTxtField(docListener);
		seqView.listenerForInputQTxtField(docListener);
		seqView.keyListenerForInputField(new InputKeyListener());
	}

	public boolean validBinaryInput() {
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
	
	DocumentListener docListener = new DocumentListener(){
		
		public void binaryInput() {
			if(seqView.getInputM().equalsIgnoreCase("") || seqView.getInputQ().equalsIgnoreCase("")) {
				seqView.getBtnLoad().setEnabled(false);
			}else if(!validBinaryInput()) {
				seqView.getBtnLoad().setEnabled(false);
			}else {
				seqView.getBtnLoad().setEnabled(true);
			}
		}
		
		
		@Override
		public void insertUpdate(DocumentEvent e) {binaryInput();}

		@Override
		public void removeUpdate(DocumentEvent e) {binaryInput();}

		@Override
		public void changedUpdate(DocumentEvent e) {binaryInput();}
	};
	
	public void setOutputRegisters() {
		seqView.setOutputA(mul.getRegAValue());
		seqView.setOutputM(mul.getRegMValue());
		seqView.setOutputMPrime(mul.getRegMNegValue());
		seqView.setOutputQ(mul.getRegQValue());
		seqView.setOutputQNeg(mul.getRegQNegValue());
	}
	
	public void resetOutputRegisters() {
		seqView.setOutputA("");
		seqView.setOutputM("");
		seqView.setOutputMPrime("");
		seqView.setOutputQ("");
		seqView.setOutputQNeg("");
	}
	
	public void init() {
		ctr = 0;
		ct = 1;
		
		seqView.getBtnCycle().setEnabled(true);
		seqView.getBtnRun().setEnabled(true);
		seqView.getBtnStep().setEnabled(true);
		seqView.setLblCount("");
	}
	
	public void setResult() {
		SequentialBinaryMultiplier mult = new SequentialBinaryMultiplier();
		mult.initRegisters(seqView.getInputM(), seqView.getInputQ());
		seqView.setLblMultiplicand(mult.getRegMValue());
		seqView.setLblMultiplier(mult.getRegQValue());
		mult.run();
		seqView.setProduct(mult.getRegAValue()+mult.getRegQValue());
		
	}
	
	class BtnLoadActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			mul = new SequentialBinaryMultiplier();
			mul.initRegisters(seqView.getInputM(), seqView.getInputQ());
			
			seqView.getTabbedPane().setSelectedIndex(1);
			setOutputRegisters();
			setResult();
			init();
		}
	}
	
	class BtnResetActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			seqView.resetInput();
			resetOutputRegisters();
			seqView.setLblCount("");
			seqView.getBtnCycle().setEnabled(false);
			seqView.getBtnRun().setEnabled(false);
			seqView.getBtnStep().setEnabled(false);
			seqView.setLblMultiplicand("");
			seqView.setLblMultiplier("");
			seqView.setProduct("");
			
		}
	}
	
	class BtnCycleActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(ctr % 2 == 0) {
				seqView.setLblCount(ct+"");
				ct++;
				ctr+=2;
			}else if(ctr % 2 != 0) {
				seqView.setLblCount(ct+"");
				ct++;
				ctr++;
			}
			
			if(ctr == mul.getTotalSteps()) {
				seqView.getBtnCycle().setEnabled(false);
				seqView.getBtnRun().setEnabled(false);
				seqView.getBtnStep().setEnabled(false);
			}
			
			mul.cycle();
			setOutputRegisters();
			System.out.println(mul.getAlist().get(mul.getAlist().size()-1));
			System.out.println(mul.getQlist().get(mul.getQlist().size()-1));
			
		}
	}
	
	class BtnStepActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ctr++;
			
			if(ctr == mul.getTotalSteps()) {
				seqView.getBtnStep().setEnabled(false);
				seqView.getBtnCycle().setEnabled(false);
				seqView.getBtnRun().setEnabled(false);
			}
			
			if(ctr % 2 == 0) {
				seqView.setLblCount(ct+"");
				ct++;
			}
			mul.step();
			setOutputRegisters();
			System.out.println( mul.getStepCtr()%2);
			seqView.getBtnStep().setText("Step " + (mul.getStepCtr()%2+1));
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
	
	class InputKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER && seqView.getBtnLoad().isEnabled()) {
				seqView.getBtnLoad().doClick();
			}
		}
		
		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}
		
	}
}
