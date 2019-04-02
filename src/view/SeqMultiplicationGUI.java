package view;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class SeqMultiplicationGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JFormattedTextField inputMTxtField, inputQTxtField;
	private JButton btnLoad, btnReset;
	private ImageIcon timesIcon = new ImageIcon(getClass().getResource("/multiply.png"));
	private JTextField outputM, outputA, outputQ, outputQ1;
	private JLabel lblM, lblA, lblQ, lblQ1;

	private JButton btnCycle, btnRun, btnStep;
	private JTextField outputMPrime;
	private JLabel lblMPrime, lblCycleCount, lblCount, lblStepStatus;
	

	private JPanel result;
	private JLabel lblX, lblProduct, lblMultiplicand, lblMultiplier;
	private JScrollPane scrollPaneA;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel answersAPanel, answersQPanel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JScrollPane scrollPaneQ;
	private JLabel lblNewLabel;
	private JLabel lblA_1;
	private JLabel lblQ_1;

	public SeqMultiplicationGUI() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {}
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(SwingConstants.LEFT);
		tabbedPane.setBounds(10, 11, 723, 275);
		contentPane.add(tabbedPane);
		JPanel input = new JPanel();
		tabbedPane.addTab("Input", null, input, null);
		input.setLayout(null);
		
		JLabel lblSBMC = new JLabel("Sequential Binary Multiplication Calculator");
		lblSBMC.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSBMC.setBounds(131, 40, 376, 27);
		input.add(lblSBMC);
		
		JLabel multiply = new JLabel();
		multiply.setFont(new Font("Tahoma", Font.BOLD, 15));
		multiply.setHorizontalAlignment(SwingConstants.CENTER);
		multiply.setBounds(295, 105, 44, 27);
		multiply.setIcon(timesIcon);
		input.add(multiply);
		
		inputMTxtField = new JFormattedTextField();
		inputMTxtField.setBounds(44, 105, 190, 27);
		input.add(inputMTxtField);
		inputMTxtField.setColumns(20);
		
		inputQTxtField = new JFormattedTextField();
		inputQTxtField.setBounds(414, 105, 190, 27);
		input.add(inputQTxtField);
		inputQTxtField.setColumns(20);
		
		btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoad.setBounds(186, 170, 94, 27);
		btnLoad.setEnabled(false);
		input.add(btnLoad);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(340, 170, 94, 27);
		input.add(btnReset);
			
		JPanel solution = new JPanel();
		tabbedPane.addTab("Solution", null, solution, null);
		solution.setLayout(null);
		
		outputM = new JTextField();
		outputM.setEditable(false);
		outputM.setColumns(10);
		outputM.setBounds(52, 48, 190, 27);
		solution.add(outputM);
		
		outputMPrime = new JTextField();
		outputMPrime.setEditable(false);
		outputMPrime.setColumns(10);
		outputMPrime.setBounds(316, 48, 190, 27);
		solution.add(outputMPrime);
		
		outputA = new JTextField();
		outputA.setEditable(false);
		outputA.setColumns(10);
		outputA.setBounds(52, 93, 190, 27);
		solution.add(outputA);
		
		outputQ = new JTextField();
		outputQ.setEditable(false);
		outputQ.setColumns(10);
		outputQ.setBounds(316, 93, 190, 27);
		solution.add(outputQ);
		
		outputQ1 = new JTextField();
		outputQ1.setEditable(false);
		outputQ1.setColumns(10);
		outputQ1.setBounds(580, 93, 58, 27);
		solution.add(outputQ1);
		
		lblM = new JLabel("M");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBounds(20, 53, 32, 21);
		solution.add(lblM);
		
		lblMPrime = new JLabel("M'");
		lblMPrime.setHorizontalAlignment(SwingConstants.CENTER);
		lblMPrime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMPrime.setBounds(281, 53, 32, 21);
		solution.add(lblMPrime);
		
		lblA = new JLabel("A");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblA.setBounds(20, 98, 32, 21);
		solution.add(lblA);
		
		lblQ = new JLabel("Q");
		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQ.setBounds(281, 98, 32, 21);
		solution.add(lblQ);
		
		lblQ1 = new JLabel("Q-1");
		lblQ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQ1.setBounds(543, 98, 32, 21);
		solution.add(lblQ1);
		
		lblCycleCount = new JLabel("Cycle Count:");
		lblCycleCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCycleCount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCycleCount.setBounds(20, 131, 113, 21);
		solution.add(lblCycleCount);
		
		lblCount = new JLabel("");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCount.setBounds(125, 131, 32, 21);
		solution.add(lblCount);
		
		btnCycle = new JButton("Cycle");
		btnCycle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCycle.setBounds(239, 163, 94, 27);
		solution.add(btnCycle);
		
		btnRun = new JButton("Run");
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRun.setBounds(388, 163, 94, 27);
		solution.add(btnRun);
		
		btnStep = new JButton("Step 1");
		btnStep.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStep.setBounds(91, 163, 94, 27);
		solution.add(btnStep);
		
		lblStepStatus = new JLabel("");
		lblStepStatus.setBounds(20, 142, 48, 14);
		solution.add(lblStepStatus);
		
				result = new JPanel();
				tabbedPane.addTab("Result", null, result, null);
				result.setLayout(null);
				
				lblMultiplicand = new JLabel();
				lblMultiplicand.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblMultiplicand.setHorizontalAlignment(SwingConstants.CENTER);
				lblMultiplicand.setBounds(252, 58, 170, 30);
				result.add(lblMultiplicand);
				
				lblMultiplier = new JLabel();
				lblMultiplier.setHorizontalAlignment(SwingConstants.CENTER);
				lblMultiplier.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblMultiplier.setBounds(252, 99, 170, 30);
				result.add(lblMultiplier);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(202, 134, 220, 8);
				result.add(separator);
				
				lblProduct = new JLabel();
				lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
				lblProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblProduct.setBounds(118, 140, 400, 30);
				result.add(lblProduct);
				
				lblX = new JLabel("X");
				lblX.setHorizontalAlignment(SwingConstants.CENTER);
				lblX.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblX.setBounds(212, 115, 49, 14);
				result.add(lblX);
		
		JPanel answers = new JPanel();
		tabbedPane.addTab("Answers", null, answers, null);
		answers.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 330, 16);
		answers.add(panel);
		panel.setLayout(null);
		
		lblA_1 = new JLabel("A");
		lblA_1.setFont(new Font("Sylfaen", Font.BOLD, 11));
		lblA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblA_1.setBounds(148, 0, 20, 19);
		panel.add(lblA_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(329, 0, 330, 16);
		answers.add(panel_1);
		panel_1.setLayout(null);
		
		lblQ_1 = new JLabel("Q");
		lblQ_1.setBounds(160, 0, 18, 20);
		lblQ_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ_1.setFont(new Font("Sylfaen", Font.BOLD, 11));
		panel_1.add(lblQ_1);
		
		
		answersAPanel = new JPanel();
		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(0, 18, 330, 256);
		scrollPaneA.setViewportView(answersAPanel);
		answersAPanel.setAlignmentX(CENTER_ALIGNMENT);
		answersAPanel.setLayout(null);
		

		answersQPanel = new JPanel();
		scrollPaneQ = new JScrollPane();
		scrollPaneQ.setBounds(329, 18, 330, 256);
		scrollPaneQ.setViewportView(answersQPanel);
		answersQPanel.setLayout(null);
		
		
		answers.add(scrollPaneA);
		answers.add(scrollPaneQ);
		
	}

	
	public JButton getBtnLoad() {
		return this.btnLoad;
	}
	
	public String getInputM() {
		return this.inputMTxtField.getText().toString();
	}
	
	public String getInputQ() {
		return this.inputQTxtField.getText().toString();
	}
	
	
	public JTabbedPane getTabbedPane() {
		return this.tabbedPane;
	}
	
	public void resetInput() {
		this.inputMTxtField.setText(null);
		this.inputQTxtField.setText(null);
	}
	
	public void setLblCount(String num) {
		this.lblCount.setText(num);
	}
	
	public void setOutputM(String m) {
		this.outputM.setText(m);
	}
	
	public void setOutputQ(String q) {
		this.outputQ.setText(q);
	}
	
	public void setOutputA(String a) {
		this.outputA.setText(a);
	}
	
	public void setOutputMPrime(String mPrime) {
		this.outputMPrime.setText(mPrime);
	}
	
	public void setOutputQNeg(String qneg) {
		this.outputQ1.setText(qneg);
	}
	
	public JButton getBtnStep() {
		return this.btnStep;
	}
	
	public JButton getBtnCycle() {
		return this.btnCycle;
	}
	
	public JButton getBtnRun() {
		return this.btnRun;
	}
	
	
	public void setLblMultiplicand(String m) {
		this.lblMultiplicand.setText(m);
	}
	
	public void setLblMultiplier(String q) {
		this.lblMultiplier.setText(q);
	}
	
	public void setProduct(String a) {
		this.lblProduct.setText(a);
	}

	public void listenerForInputMTxtField(DocumentListener listenerForInputMTxtField) {
		this.inputMTxtField.getDocument().addDocumentListener(listenerForInputMTxtField);
	}
	
	public void listenerForInputQTxtField(DocumentListener listenerForInputQTxtField) {
		this.inputQTxtField.getDocument().addDocumentListener(listenerForInputQTxtField);
	}
	
	public void listenerForBtnLoad(ActionListener listenerForBtnLoad) {
		this.btnLoad.addActionListener(listenerForBtnLoad);
	}
	
	public void listenerForBtnReset(ActionListener listenerForBtnReset) {
		this.btnReset.addActionListener(listenerForBtnReset);
	}
	
	public void listenerForBtnCycle(ActionListener listenerForBtnCycle) {
		this.btnCycle.addActionListener(listenerForBtnCycle);
	}
	
	public void listenerForBtnRun(ActionListener listenerForBtnRun) {
		this.btnRun.addActionListener(listenerForBtnRun);
	}
	
	public void listenerForBtnStep(ActionListener listenerForBtnStep) {
		this.btnStep.addActionListener(listenerForBtnStep);
	}
	
	public void keyListenerForInputField(KeyListener keyListener) {
		this.inputMTxtField.addKeyListener(keyListener);
		this.inputQTxtField.addKeyListener(keyListener);
	}
	
	public JLabel getLblStepStatus() {
		return lblStepStatus;
	}


	public void setLblStepStatus(JLabel lblStepStatus) {
		this.lblStepStatus = lblStepStatus;
	}
	public JPanel getAnswersAPanel() {
		return answersAPanel;
	}


	public void setAnswersAPanel(JPanel answersAPanel) {
		this.answersAPanel = answersAPanel;
	}


	public JPanel getAnswersQPanel() {
		return answersQPanel;
	}


	public void setAnswersQPanel(JPanel answersQPanel) {
		this.answersQPanel = answersQPanel;
	}
}
