package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.EmployeeQueries;
import model.Employee;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

public class EmpAppWindow {

	private JFrame empadd;
	private JFrame launcher;
	private JFrame report;
	
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
					window.launcher.setVisible(true);
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
		initializeLauncher();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initializeLauncher() {
		
		launcher = new JFrame("Employee Management App");
		launcher.setBounds(100, 100, 450, 300);
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		launcher.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton launcherbutton1 = new JButton("Manage Employees");
		launcherbutton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initializeAddEmp();
			}
		});
		
		JButton launcherbutton2 = new JButton("Generate Report");
		launcherbutton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				generateReport();
			}
		});
		launcher.getContentPane().add(launcherbutton1);
		launcher.getContentPane().add(launcherbutton2);
		
	}
	
	private void generateReport() {
		
		report = new JFrame("Report Generated");
		report.setBounds(100, 100, 400, 500);
		report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		report.getContentPane().setLayout(new GridLayout(0,1));
		report.setVisible(true);
		
		JTextField reportText = new JTextField("Enter Department...");
		JButton reportbtn = new JButton("Generate Report");
		reportbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Employee> theList = new ArrayList<Employee>();
				theList = EmployeeQueries.generateEmployeesBUReport(reportText.getText());
				
				for(Employee emptemp : theList) {
					JLabel temp1 = new JLabel(emptemp.toString());
					report.add(temp1);
				}
			}
		}); 
		report.getContentPane().add(reportText);
		report.getContentPane().add(reportbtn);
	
		
	}
	
	
	private void initializeAddEmp() {
		
		empadd = new JFrame();
		empadd.setBounds(100, 100, 450, 300);
		empadd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		empadd.getContentPane().add(NameLabel);
		empadd.getContentPane().add(textName);
		
		empadd.getContentPane().add(NINLabel);
		empadd.getContentPane().add(textNIN);
		
		empadd.getContentPane().add(DepLabel);
		empadd.getContentPane().add(textDepartment);
		
		empadd.getContentPane().add(DOBLabel);
		empadd.getContentPane().add(textDOB);
		
		empadd.getContentPane().add(AddressLabel);
		empadd.getContentPane().add(textAddress);
		
		empadd.getContentPane().add(BankAccLabel);
		empadd.getContentPane().add(textBankAcc);
		
		empadd.getContentPane().add(SalaryLabel);
		empadd.getContentPane().add(textSalary);
		
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
				if (emp1.postToDB())
					System.out.println("Success");
				else
					System.out.println("Failure");
				textName.setText(""); textNIN.setText(""); textDepartment.setText("");
				textDOB.setText(""); textAddress.setText(""); textBankAcc.setText("");
				textSalary.setText("");
			}
		});
		
		JButton backbtn = new JButton("Back");
		backbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				empadd.setVisible(false);
			}
		});
		
		empadd.getContentPane().setLayout(new GridLayout(0,2));
		
		empadd.getContentPane().add(btnNewButton);
		empadd.getContentPane().add(backbtn);
		empadd.setVisible(true);
	}
	
//	private List<Employee> processInputFile(String inputFilePath) {
//
//	    List<Employee> inputList = new ArrayList<Employee>();
//
//	    try{
//
//	      File inputF = new File(inputFilePath);
//
//	      InputStream inputFS = new FileInputStream(inputF);
//
//	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
//
//	      // skip the header of the csv
//
//	      inputList = br.lines().skip(1).map( e -> e).collect(Collectors.toList());
//
//	      br.close();
//
//	    } catch (FileNotFoundException|IOException e) {
//
//
//	    }
//
//	    return inputList ;
//
//	}

}
