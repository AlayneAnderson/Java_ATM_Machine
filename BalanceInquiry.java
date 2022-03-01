import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents a balance inquiry ATM transaction

public class BalanceInquiry extends Transaction {

    //constructor
    public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase){
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }

    //performs the transaction
    @Override
    public void execute(){
        //get references to bank DB & screen
        BankDatabase = bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        //get avail balance for the account involved
        double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

        //get the total balance for the account involved
        double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

        //display the balance information on the screen
        screen.creatBalanceGUI();
        screen.messageJLabel12.setText("Available Balance: " + availableBalance);
        screen.messageJLabel13.setText("Total Balance: " + totalBalance);
        screen.Mainframe.revalidate();
    }
}
