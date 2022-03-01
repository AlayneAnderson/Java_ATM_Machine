//Represents the cash dispenser of the ATM

public class CashDispenser {
    //the default initial number of bills in the cash dispenser
    private final static int INITIAL_COUNT = 500;
    private int count; //number of $20 bills remaining

    //constructor
    public CashDispenser(){
        //set count attribute to default
        count = INITIAL_COUNT;
    }

    //simulates dispensing of a specified amount of cash
    public void dispenseCash(int amount){
        //number of $20 bills required
        int billsRequired = amount / 20;
        //update the count of bills
        count -= billsRequired;
    }

    //indicates whether the cash dispenser can dispense the desired amount
    public boolean isSufficientCashAvailable(int amount){
        //number of $20 bills required
        int billsRequired = amount / 20;

        if(count >= billsRequired)
            return true; //enough bills available
        else
            return false; //not enough bills available
    }
}
