package view;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class SeqMultiplicationGUI extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JFormattedTextField inputMTxtField, inputQTxtField;
	private JButton btnLoad, btnReset;
	private ImageIcon timesIcon = new ImageIcon(getClass().getResource("/multiply.png"));
	private JTextField outputM, outputA, outputQ, outputQ1;
	private JLabel lblM, lblA, lblQ, lblQ1;

	private JButton btnCycle, btnRun, btnStep;
	private JTextField outputMPrime;
	private JLabel lblMPrime, lblCycleCount, lblCount;
	private JPanel result;
	private JLabel lblX, lblProduct, lblMultiplicand, lblMultiplier;

	public SeqMultiplicationGUI() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 11, 723, 183);
		contentPane.add(tabbedPane);
		JPanel input = new JPanel();
		tabbedPane.addTab("Input", null, input, null);
		input.setLayout(null);
		
		JLabel lblSBMC = new JLabel("Sequential Binary Multiplication Calculator");
		lblSBMC.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSBMC.setBounds(131, 11, 376, 27);
		input.add(lblSBMC);
		
		JLabel multiply = new JLabel();
		multiply.setFont(new Font("Tahoma", Font.BOLD, 15));
		multiply.setHorizontalAlignment(SwingConstants.CENTER);
		multiply.setBounds(295, 60, 44, 27);
		multiply.setIcon(timesIcon);
		input.add(multiply);
		
		inputMTxtField = new JFormattedTextField();
		inputMTxtField.setBounds(44, 60, 190, 27);
		input.add(inputMTxtField);
		inputMTxtField.setColumns(20);
		
		inputQTxtField = new JFormattedTextField();
		inputQTxtField.setBounds(414, 60, 190, 27);
		input.add(inputQTxtField);
		inputQTxtField.setColumns(20);
		
		btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoad.setBounds(186, 116, 94, 27);
		btnLoad.setEnabled(false);
		input.add(btnLoad);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(340, 116, 94, 27);
		input.add(btnReset);
			
		JPanel solution = new JPanel();
		tabbedPane.addTab("Solution", null, solution, null);
		solution.setLayout(null);
		
		outputM = new JTextField();
		outputM.setEditable(false);
		outputM.setColumns(10);
		outputM.setBounds(52, 20, 190, 27);
		solution.add(outputM);
		
		outputMPrime = new JTextField();
		outputMPrime.setEditable(false);
		outputMPrime.setColumns(10);
		outputMPrime.setBounds(316, 20, 190, 27);
		solution.add(outputMPrime);
		
		outputA = new JTextField();
		outputA.setEditable(false);
		outputA.setColumns(10);
		outputA.setBounds(52, 65, 190, 27);
		solution.add(outputA);
		
		outputQ = new JTextField();
		outputQ.setEditable(false);
		outputQ.setColumns(10);
		outputQ.setBounds(316, 65, 190, 27);
		solution.add(outputQ);
		
		outputQ1 = new JTextField();
		outputQ1.setEditable(false);
		outputQ1.setColumns(10);
		outputQ1.setBounds(580, 65, 58, 27);
		solution.add(outputQ1);
		
		lblM = new JLabel("M");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBounds(20, 25, 32, 21);
		solution.add(lblM);
		
		lblMPrime = new JLabel("M'");
		lblMPrime.setHorizontalAlignment(SwingConstants.CENTER);
		lblMPrime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMPrime.setBounds(281, 25, 32, 21);
		solution.add(lblMPrime);
		
		lblA = new JLabel("A");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblA.setBounds(20, 70, 32, 21);
		solution.add(lblA);
		
		lblQ = new JLabel("Q");
		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQ.setBounds(281, 70, 32, 21);
		solution.add(lblQ);
		
		lblQ1 = new JLabel("Q-1");
		lblQ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQ1.setBounds(543, 70, 32, 21);
		solution.add(lblQ1);
		
		lblCycleCount = new JLabel("Cycle Count:");
		lblCycleCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCycleCount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCycleCount.setBounds(20, 103, 113, 21);
		solution.add(lblCycleCount);
		
		lblCount = new JLabel("");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCount.setBounds(125, 103, 32, 21);
		solution.add(lblCount);
		
		btnCycle = new JButton("Cycle");
		btnCycle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCycle.setBounds(239, 135, 94, 27);
		solution.add(btnCycle);
		
		btnRun = new JButton("Run");
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRun.setBounds(388, 135, 94, 27);
		solution.add(btnRun);
		
		btnStep = new JButton("Step");
		btnStep.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStep.setBounds(91, 135, 94, 27);
		solution.add(btnStep);

		result = new JPanel();
		tabbedPane.addTab("Result", null, result, null);
		result.setLayout(null);
		
		lblMultiplicand = new JLabel();
		lblMultiplicand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMultiplicand.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultiplicand.setBounds(240, 32, 170, 30);
		result.add(lblMultiplicand);
		
		lblMultiplier = new JLabel();
		lblMultiplier.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultiplier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMultiplier.setBounds(240, 73, 170, 30);
		result.add(lblMultiplier);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(190, 108, 220, 8);
		result.add(separator);
		
		lblProduct = new JLabel();
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProduct.setBounds(240, 115, 170, 30);
		result.add(lblProduct);
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblX.setBounds(200, 89, 49, 14);
		result.add(lblX);
		
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
}
