import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents a deposit ATM transaction

public class Deposit extends Transaction {
    //amount to deposit
    private double amount;
    //reference to keypad
    private Keypad keypad;
    //reference to deposit slot
    private DepositSlot depositSlot;
    //constant for cancel option
    private final static int CANCELED = 0;

    //constructor
    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot){
        //initialize superclass variables
        super(userAccountNumber, atmScreen, atmBankDatabase);

        //initialize references to keypad and deposit slot
        keypad = atmKeypad;
        depositSlot = atmDepositSlot;
    }

    //perform transaction
    @Override
    public void execute(){
        promptForDepositAmount();
    }

    public void makedeposit(double amount){
        //get reference
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        //get deposit amount from user
        //check whether user entered a deposit amount or canceled
        if (amount != CANCELED){
            //request deposit envelope containing specified amount
            screen.messageJLabel12.setText("\nPlease insert a deposit envelope containing " + amount);

            //receive deposit envelope
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();

            //check whether deposit envelope was received
            if(envelopeReceived){
                screen.messageJLabel12.setText("\nYour envelope has been " + "received.\nNOTE: The money just deposited will not ");
                screen.messageJLabel13.setText("be available until we verify the amount of any " + "enclosed cash and your checks clear.");

                //credit account to reflect the deposit
                bankDatabase.credit(getAccountNumber(), amount);
            }
            else {
                screen.messageJLabel12.setText("\nYou did not insert an " + "envelope, so the ATM has canceled your transaction.");
            }
        }
        else {
            screen.messageJlabel12.setText("\nCalceling transaction...");
        }
    }

    //prompt user to enter a deposit amount in cents
    private void promptForDepositAmount(){
        Screen screen = getScreen();

        //display the prompt
        //receive input of deposit amount
        screen.CreateDepositGUI();
        screen.Mainframe.add( keypad.addkeypad(), BorderLayout.CENTER);
        Depositcheck check1 = new Depositcheck();
        keypad.BEnter.addActionListener( check1 );
        screen.Mainframe.revalidate();

    }

    private class Depositcheck implements ActionListener {
        public void actionPerformed( ActionEvent e ){
            double input = Integer.parseInt( screen.Inputfield2.getText() );
            double amount = input / 100;

            makedeposit(amount);
        }
    }
}
