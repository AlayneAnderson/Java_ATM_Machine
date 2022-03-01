import java.util.ArrayList;

//Represents Bank account info DB

public class BankDatabase {
    //Array of accounts
    static ArrayList<Account> accounts = new ArrayList<Account>();

    //constructor
    public BankDatabase(){
        //original array has been changed into an arraylist, makes easier to add/delete from DB
        Account accounts1 = new Account("Customer1", 12345, 11111, 1000.0, 1200.0, 0);
        Account accounts2 = new Account("Customer2", 98765, 22222, 200.0, 200.0, 0);
        Account accounts3 = new Account("Customer3", 19234, 33333, 200.0, 200.0, 0);
        Account accounts4 = new Account("Manager1", 99999, 00000, 0, 0, 1);
        accounts.add(accounts1);
        accounts.add(accounts2);
        accounts.add(accounts3);
        accounts.add(accounts4);
    }

    //Retrieve Account object containing specified account number
    public Account getAccount(int accountnumber){
        //loop through accounts searching for matching account number
        for(Account currentAccount : accounts){
            //return current account of match found
            if(currentAccount.getAccountNumber() == accountnumber)
                return currentAccount;
        }
        //if no matching account was found, return null
        return null;
    }

    private Account getAccountpin(int PIN){
        //loop through accounts searching for matching account number
        for(Account currentAccount : accounts){
            //return current account if match found
            if(currentAccount.GetPin() == PIN)
                return currentAccount;
        }
        return null;
    }

    //determine whether user-specified account # & PIN match those in account DB
    public boolean authenticateUser(int userPIN){
        //attempt to retrieve the account with the account number
        Account userAccount = getAccountpin(userPIN);

        //if account exists, return result of Account method validatePIN
        if(userAccount != null){
            return userAccount.validatePIN(userPIN);
        }
        else
            return false;
    }

    //return available balance of the Account with the specified account number
    public double getAvailableBalance(int userAccountNumber){
        return getAccount(userAccountNumber).getAvailableBalance();
    }

    //return total balance of the account with the specified account number
    public double getTotalBalance(int userAccountNumber){
        return getAccount(userAccountNumber).getTotalBalance();
    }

    //credit an amount to an account with the specified account number
    public void credit(int userAccountNumber, double amount){
        getAccount(userAccountNumber).credit(amount);
    }

    //debit an amount from an account with the specified account number
    public void debit(int userAccountNumber, double amount){
        getAccount(userAccountNumber).debit(amount);
    }

    public int getadmin(int userAccountNumber){
        return getAccountpin(userAccountNumber).getISadmin();
    }

    public static Iterator createIterator(){
        return new AccountIterator(accounts);
    }

    public int getaccpin(int PIN){
        for(Account currentAccount : accounts){
            //return current account if a match is found
            if(currentAccount.GetPin() == PIN)
                return currentAccount.getAccountNumber();
            else
                return 1;
        }
        return PIN;
    }

    public static void Adduser(){
        String name = Screen.Inputfield1.getText();
        int accountnumber = Integer.parseInt( Screen.Inputfield2.getText() );
        int pin = Integer.parseInt(Screen.Inputfield4.getText() );
        int balance = Integer.parseInt( Screen.Inputfield3.getText() );

        Account newaccount = new Account(name, accountnumber, pin, balance, balance, 0);
        accounts.add(newaccount);

        Screen.Inputfield1.setText("");
        Screen.Inputfield2.setText("");
        Screen.Inputfield3.setText("");
        Screen.Inputfield4.setText("");
    }

    public static void Deleteuser(int position){
        accounts.remove(position);
    }
}
