//Represents the screen of the ATM
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Screen extends JFrame{
    public JFframe Mainframe;
    public static JTextField Inputfield1;
    public static JTextField Inputfield2;
    public static JTextField Inputfield3;
    public static JTextField Inputfield4;
    public JLabel messageJLabel;
    public JLabel messageJLabel12; //displays message of game status
    public JLabel messageJLabel13;
    public JLabel messageJLabel14;
    public JLabel messageJLabel15;
    public JLabel messageJLabel18;
    public JLabel messageJLabel19;
    public JLabel messageJLabel10;
    public JButton loginbutton; //creates new game
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton Exit;
    public int accnum = 0;
    public int PIN = 0;
    public JLabel messageJLabel16;
    public JLabel messageJLabel17;

    //displays a message without a carriage return
    public void displayMessage(String message){
        System.out.print(message);
    }

    //display a message with a carriage return
    public void displayMessageLine(String message){
        System.out.println(message);
    }

    //display a $ amount
    public void displayDollarAmount(double amount){
        System.out.printf("$%,.2f", amount);
    }

    //create the login GUI
    public void createlogin(){
        Mainframe = new JFrame("ATM");
        messageJLabel14 = new JLabel("Insert your credit/debit card then");
        messageJLabel = new JLabel( "  Enter your PIN number:    ");

        Inputfield1 = new JTextField( 10 );

        messageJLabel12 = new JLabel("");
        Inputfield2 = new JTextField( 10);
        loginbutton = new JButton("Login");
        messageJLabel13 = new JLabel("");
        Mainframe.setLayout( new FlowLayout()); //set layout
        Mainframe.add(messageJLabel14);
        Mainframe.add( messageJLabel); //add first prompt

        Mainframe.add(Inputfield2);
        Mainframe.add(messageJLabel12);

        //add message label
        Mainframe.add( messageJLabel13);
        Inputfield2.setEditable(false);
        Mainframe.repaint();

    }

    //create the main menu GUI
    public void createmenu(){
        Mainframe.getContentPane().removeAll();
        messageJLabel = new JLabel("Welcome");
        messageJLabel12 = new JLabel("1 - Balance");
        messageJLabel13 = new JLabel("2 - Withdrawal");
        messageJLabel14 = new JLabel("3 - Deposit");
        messageJLabel15 = new JLabel("4 - Exit");
        Mainframe.setLayout( new FlowLayout()); //set layout
        Mainframe.add(messageJLabel);
        Mainframe.add(messageJLabel12); //add first prompt
        Mainframe.add(messageJLabel13); //add second prompt
        Mainframe.add(messageJLabel14); //add message label
        Mainframe.add(messageJLabel15);
        Mainframe.repaint();

    }

    //create the Balance GUI
    public void createBalanceGUI(){
        Mainframe.getContentPane().removeAll();
        messageJLabel = new JLabel("Balance Information:           ");
        messageJLabel12 = new JLabel("Available Balance:");
        messageJLabel13 = new JLabel("Total Balance:");
        Exit = new JButton("Back");
        Mainframe.setLayout( new FlowLayout());
        Mainframe.add(messageJLabel);
        Mainframe.add(messageJLabel12);
        Mainframe.add(messageJLabel13);
        Mainframe.add(Exit);
        Mainframe.repaint();
    }

    //create the withdrawal GUI
    public void createWithdrawGUI(){
        Mainframe.getContentPane().removeAll();
        Mainframe.revalidate();
        messageJLabel = new JLabel("Withdraw Menu:                       ");
        messageJLabel12 = new JLabel("1 - $20 ");
        messageJLabel13 = new JLabel("2 - $40 ");
        messageJLabel14 = new JLabel("3 - $60 ");
        messageJLabel15 = new JLabel("4 - $100 ");
        messageJLabel16 = new JLabel("5 - $200 ");
        messageJLabel17 = new JLabel("         Choose an amount to withdraw");
        Exit = new JButton("Cancel");
        Mainframe.setLayout( new FlowLayout());
        Mainframe.add(messageJLabel);
        Mainframe.add(messageJLabel12);
        Mainframe.add(messageJLabel13);
        Mainframe.add(messageJLabel14);
        Mainframe.add(messageJLabel15);
        Mainframe.add(messageJLabel16);
        Mainframe.add(Exit);
        Mainframe.add(messageJLabel17);
        Mainframe.repaint();

    }

    //Create the Deposit GUI
    public void CreateDepositGUI(){
        Mainframe.getContentPane().removeAll();
        messageJLabel12 = new JLabel("Please enter a deposit amount in CENTS");
        messageJLabel13 = new JLabel("");
        Inputfield2 = new JTextField(10);
        Inputfield2.setEditable(false);
        button1 = new JButton("Deposit");
        Exit = new JButton("Cancel");
        Mainframe.add(messageJLabel12);
        Mainframe.add(messageJLabel13);
        Mainframe.add(Inputfield2);
        Mainframe.add(Exit);
        Mainframe.repaint();
    }

    public void setGUI(){
        repaint();
    }

    //Create the admin page GUI
    public void createAdminpage(){
        messageJLabel = new JLabel("View Users:");
        messageJLabel12 = new JLabel("Account number:");
        messageJLabel13 = new JLabel("Available Balance:");
        messageJLabel14 = new JLabel("Total Balance:");
        messageJLabel15 = new JLabel("_______________________________________________");
        button1 = new JButton("Next");
        button4 = new JButton("Previous");
        Exit = new JButton("Back");
        Inputfield1 = new JTextField(10);
        Inputfield2 = new JTextField(10);
        Inputfield3 = new JTextField(10);
        Inputfield4 = new JTextField(10);
        Mainfame.setLayoyt(new FlowLayout());
        messageJLabel16 = new JLabel("Add Account: ");
        messageJLabel17 = new JLabel("User name: ");
        Mainframe.add(messageJLabel);
        messageJLabel18 = new JLabel("           Account number: ");
        Mainframe.add(messageJLabel12);
        messageJLabel10 = new JLabel("            Balance number: ");
        button2 = new JButton("Add");
        button3 = new JButton("Delete");

        Mainframe.add(messageJLabel13);
        Mainframe.add(messageJLabel14);
        Mainframe.add(button4);
        Mainframe.add(button1);
        Mainframe.add(button3);
        Mainframe.add(messageJLabel15);
        Mainframe.add(messageJLabel16);
        Mainframe.add(messageJLabel17);
        Mainframe.add(Inputfield1);
        Mainframe.add(messageJLabel18);
        Mainframe.add(Inputfield2);
        Mainframe.add(messageJLabel10);
        Mainframe.add(Inputfield4);
        Mainframe.add(messageJLabel19);
        Mainframe.add(Inputfield3);

        Mainframe.add(button2);
        Mainframe.add(Exit);
        Mainframe.repaint();

    }

}
