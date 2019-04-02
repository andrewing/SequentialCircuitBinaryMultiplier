package controller; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import view.*;
import model.*;

public class MainController {
	
	private SeqMultiplicationGUI seqView;
	private SequentialBinaryMultiplier mul;
	private int ctr;
	private int ct;
	private int aSpace = 0, qSpace = 0;
	
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
			if(seqView.getInputM().length() > 16 || seqView.getInputQ().length() > 16) {
				return false;
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
	
	public void addAQToList(String a, String q) {
		JLabel A = new JLabel(a);
		A.setHorizontalAlignment(SwingConstants.CENTER);
		A.setBounds(0, aSpace, 328, 14);
		
		JLabel Q = new JLabel(q);
		Q.setHorizontalAlignment(SwingConstants.CENTER);
		Q.setBounds(0, qSpace, 328, 14);
		seqView.getAnswersAPanel().add(A);
		seqView.getAnswersQPanel().add(Q);
		aSpace += 15;
		qSpace += 15;
	}
	
	class BtnLoadActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			mul = new SequentialBinaryMultiplier();
			mul.initRegisters(seqView.getInputM(), seqView.getInputQ());
			
			
			
			seqView.getTabbedPane().setSelectedIndex(1);
			init();
			setResult();
			setOutputRegisters();
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
			
			seqView.getAnswersAPanel().removeAll();
			seqView.getAnswersQPanel().removeAll();
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
			addAQToList(mul.getAlist().get(mul.getAlist().size()-1), mul.getQlist().get(mul.getQlist().size()-1));
			
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
			
			mul.step();
			
			setOutputRegisters();
			seqView.getBtnStep().setText("Step " + (mul.getStepCtr()%2+1));
			if(ctr % 2 == 0) {
				seqView.setLblCount(ct+"");
				ct++;
				if(ctr >=2)
				addAQToList(mul.getAlist().get(mul.getAlist().size()-1), mul.getQlist().get(mul.getQlist().size()-1));
			}
		}
	}
	
	class BtnRunActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			seqView.getBtnCycle().setEnabled(false);
			seqView.getBtnStep().setEnabled(false);
			int i = mul.getStepCtr()/2;
			System.out.println(i);
			mul.run();
			seqView.setLblCount(mul.getTotalCycle()+"");
			setOutputRegisters();
			for(; i < mul.getAlist().size(); i ++) {
				addAQToList(mul.getAlist().get(i), mul.getQlist().get(i));

			}
			
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
