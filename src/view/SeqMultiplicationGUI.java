package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainController;

import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class SeqMultiplicationGUI extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTextField inputMTxtField;
	private JTextField inputQTxtField;
	private JComboBox comboBox;
	private JButton btnLoad;
	private JButton btnReset;
	private ImageIcon timesIcon = new ImageIcon(getClass().getResource("/multiply.png"));
	private JTextField outputM;
	private JTextField outputA;
	private JTextField outputQ;
	private JTextField outputQ1;
	private JLabel lblM;
	private JLabel lblA;
	private JLabel lblQ;
	private JLabel lblQ1;
	private JButton btnCycle;
	private JButton btnRun;
	private JTextField outputMPrime;
	private JLabel lblMPrime;
	private JLabel lblCycleCount;
	private JLabel lblCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeqMultiplicationGUI frame = new SeqMultiplicationGUI();
					MainController control = new MainController(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeqMultiplicationGUI() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 11, 791, 188);
		contentPane.add(tabbedPane);
		
		JPanel Input = new JPanel();
		tabbedPane.addTab("Input", null, Input, null);
		Input.setLayout(null);
		
		JLabel multiply = new JLabel();
		multiply.setFont(new Font("Tahoma", Font.BOLD, 15));
		multiply.setHorizontalAlignment(SwingConstants.CENTER);
		multiply.setBounds(270, 60, 48, 36);
		multiply.setIcon(timesIcon);
		Input.add(multiply);
		
		JPanel Solution = new JPanel();
		tabbedPane.addTab("Solution", null, Solution, null);
		Solution.setLayout(null);
		
		outputM = new JTextField();
		outputM.setEditable(false);
		outputM.setColumns(10);
		outputM.setBounds(52, 20, 190, 27);
		Solution.add(outputM);
		
		outputMPrime = new JTextField();
		outputMPrime.setEditable(false);
		outputMPrime.setColumns(10);
		outputMPrime.setBounds(316, 20, 190, 27);
		Solution.add(outputMPrime);
		
		outputA = new JTextField();
		outputA.setEditable(false);
		outputA.setColumns(10);
		outputA.setBounds(52, 65, 190, 27);
		Solution.add(outputA);
		
		outputQ = new JTextField();
		outputQ.setEditable(false);
		outputQ.setColumns(10);
		outputQ.setBounds(316, 65, 190, 27);
		Solution.add(outputQ);
		
		outputQ1 = new JTextField();
		outputQ1.setColumns(10);
		outputQ1.setBounds(580, 65, 58, 27);
		Solution.add(outputQ1);
		
		lblM = new JLabel("M");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBounds(20, 25, 32, 21);
		Solution.add(lblM);
		
		lblMPrime = new JLabel("M'");
		lblMPrime.setHorizontalAlignment(SwingConstants.CENTER);
		lblMPrime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMPrime.setBounds(281, 25, 32, 21);
		Solution.add(lblMPrime);
		
		lblA = new JLabel("A");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblA.setBounds(20, 70, 32, 21);
		Solution.add(lblA);
		
		lblQ = new JLabel("Q");
		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQ.setBounds(281, 70, 32, 21);
		Solution.add(lblQ);
		
		lblQ1 = new JLabel("Q-1");
		lblQ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQ1.setBounds(543, 70, 32, 21);
		Solution.add(lblQ1);
		
		btnCycle = new JButton("Cycle");
		btnCycle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCycle.setBounds(174, 135, 94, 27);
		Solution.add(btnCycle);
		
		btnRun = new JButton("Run");
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRun.setBounds(332, 135, 94, 27);
		Solution.add(btnRun);
		
		lblCycleCount = new JLabel("Cycle Count:");
		lblCycleCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCycleCount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCycleCount.setBounds(20, 103, 113, 21);
		Solution.add(lblCycleCount);
		
		lblCount = new JLabel("");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCount.setBounds(125, 103, 32, 21);
		Solution.add(lblCount);

//==============================================================================================//
		
		inputMTxtField = new JTextField();
		inputMTxtField.setBounds(48, 63, 190, 27);
		Input.add(inputMTxtField);
		inputMTxtField.setColumns(10);
		
		inputQTxtField = new JTextField();
		inputQTxtField.setColumns(10);
		inputQTxtField.setBounds(350, 63, 190, 27);
		Input.add(inputQTxtField);
		
		String[] type = {"(Choose base)", "Binary","Decimal", "Hexadecimal"};
		comboBox = new JComboBox(type);
		comboBox.setBounds(565, 63, 152, 27);
		Input.add(comboBox);
		
		btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoad.setBounds(174, 135, 94, 27);
		Input.add(btnLoad);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(332, 135, 94, 27);
		Input.add(btnReset);
		
	}

//=============================================================================================//
	
	public String getInputM() {
		return this.inputMTxtField.getText();
	}
	
	public String getInputQ() {
		return this.inputQTxtField.getText();
	}
	
	
	public JTabbedPane getTabbedPane() {
		return this.tabbedPane;
	}
	
	public void resetInput() {
		this.inputMTxtField.setText(null);
		this.inputQTxtField.setText(null);
		this.comboBox.setSelectedIndex(0);
	}
	
	public void setLblCount(String num) {
		this.lblCount.setText(num);
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
}
