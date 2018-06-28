package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.EmployeeQueries;
import model.Employee;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

public class EmpAppWindow {

	private JFrame frame;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textNIN;
	private JTextField textSalary;
	private JTextField textBankAcc;
	private JTextField textDepartment;
	private JTextField textDOB;
	
	private JLabel NameLabel;
	private JLabel AddressLabel;
	private JLabel NINLabel;
	private JLabel SalaryLabel;
	private JLabel BankAccLabel;
	private JLabel DepLabel;
	private JLabel DOBLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpAppWindow window = new EmpAppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmpAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textName = new JTextField();
		textAddress = new JTextField();
		textNIN = new JTextField();
		textBankAcc = new JTextField();
		textSalary = new JTextField();
		textDepartment = new JTextField();
		textDOB = new JTextField();
		
		NameLabel = new JLabel("Name:");
		AddressLabel = new JLabel("Address:");
		NINLabel = new JLabel("NIN:");
		BankAccLabel = new JLabel("IBAN:");
		SalaryLabel = new JLabel("Salary:");
		DepLabel = new JLabel("Department:");
		DOBLabel = new JLabel("Date of birth:");
		
		frame.getContentPane().add(NameLabel);
		frame.getContentPane().add(textName);
		
		frame.getContentPane().add(NINLabel);
		frame.getContentPane().add(textNIN);
		
		frame.getContentPane().add(DepLabel);
		frame.getContentPane().add(textDepartment);
		
		frame.getContentPane().add(DOBLabel);
		frame.getContentPane().add(textDOB);
		
		frame.getContentPane().add(AddressLabel);
		frame.getContentPane().add(textAddress);
		
		frame.getContentPane().add(BankAccLabel);
		frame.getContentPane().add(textBankAcc);
		
		frame.getContentPane().add(SalaryLabel);
		frame.getContentPane().add(textSalary);
		
		textName.setColumns(10); textAddress.setColumns(10); textNIN.setColumns(10);
		textBankAcc.setColumns(10); textSalary.setColumns(10); textDepartment.setColumns(10);
		textDOB.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Employee emp1 = new Employee(textName.getText(), textNIN.getText(),
						textDepartment.getText(), textDOB.getText(), textAddress.getText(),
						textBankAcc.getText(), textSalary.getText());
				emp1.postToDB();
				textName.setText(""); textNIN.setText(""); textDepartment.setText("");
				textDOB.setText(""); textAddress.setText(""); textBankAcc.setText("");
				textSalary.setText("");
			}
		});
		
		frame.getContentPane().setLayout(new GridLayout(0,2));
		
		frame.getContentPane().add(btnNewButton);
	}

}
