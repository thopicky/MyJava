import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class CarPayments extends JFrame

{
	private JLabel priceJLabel;
	private JTextField priceJTextField;
	
	private JLabel downPaymentJLabel;
	private JTextField downPaymentJTextField;
	
	private JLabel interestJLabel;
	private JTextField interestJTextField;

	private JButton calculateJButton;

	private JTextArea paymentsJTextArea;


	public CarPayments()
	{
		createUserInterface();		
	}
	
	private void createUserInterface()
	{
		Container con = getContentPane();
		con.setLayout(null);

		priceJLabel = new JLabel();
		priceJLabel.setBounds(40, 24, 80, 21);
		priceJLabel.setText("Price");
		con.add(priceJLabel);

		priceJTextField = new JTextField();
		priceJTextField.setBounds(184, 24, 56, 21);
		priceJTextField.setHorizontalAlignment(JTextField.RIGHT);
		con.add(priceJTextField);

		downPaymentJLabel = new JLabel();
		downPaymentJLabel.setBounds(40, 56, 96,21);
		downPaymentJLabel.setText("Down Payment");
		con.add(downPaymentJLabel);

		downPaymentJTextField = new JTextField();
		downPaymentJTextField.setBounds(184, 56, 56, 21);
		downPaymentJTextField.setHorizontalAlignment(JTextField.RIGHT);
		con.add(downPaymentJTextField);

		interestJLabel = new JLabel();
		interestJLabel.setBounds(40, 88, 120, 21);
		interestJLabel.setText("ANNUAL INTEREST RATE");
		con.add(interestJLabel);

		interestJTextField = new JTextField();
		interestJTextField.setBounds(184, 88, 56, 21);
		interestJTextField.setHorizontalAlignment(JTextField.RIGHT);
		con.add(interestJTextField);

		calculateJButton = new JButton();
		calculateJButton.setBounds(92, 128, 94, 24);
		calculateJButton.setText("Calculate");
		con.add(calculateJButton);

		calculateJButton.addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)

		{
		calculateJButtonActionPerformed(event);
		}


		}

		);
		
		paymentsJTextArea = new JTextArea();
		paymentsJTextArea.setBounds(28, 168, 232, 90);
		paymentsJTextArea.setEditable(false);
		con.add(paymentsJTextArea);


		setTitle("Car Payment Calculator");
		setSize(288, 302);
		setVisible(true);			
	
	}

	private void calculateJButtonActionPerformed(ActionEvent event)

	{
		int years =2;
		int months;

		double monthlyPayment;

		paymentsJTextArea.setText("");

		paymentsJTextArea.append("Months/tMonthly Payment");//change the slash to 										backslash
		
		
		int price= Integer.parseInt(priceJTextField.getText());

		int downPayment= Integer.parseInt(downPaymentJTextField.getText());

		double interest= Double.parseDouble(interestJTextField.getText());

		int loanAmount= price- downPayment;

		double monthlyInterest= interest/1200;

		Decimalformat currency= new DecimalFormat(N0.0);

		while(years<=5)
		{
			months= 12*years;

			monthlyPayment= calculateMonthlyPayment(monthlyInterest, months, loanAmount);

			paymentsJTextArea.append("/n"+months+"/t"+currency.format(monthlyPayment));

			years++;//backslash

		}

		

		
	}
		private double calculateMonthlyPayment(double monthlyInterest, int months, int loanAmount)
		{
			double base= Math.pow(1+monthlyInterest, months);

			return loanAmount*monthlyInterest/(1-(1/base));
		}

		public static void main()
		{
			CarPayments application= new CarPayments();
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
}