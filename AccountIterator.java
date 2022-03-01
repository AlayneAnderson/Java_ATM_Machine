import java.util.ArrayList;
//This class is responsible for the Iterator design pattern

public class AccountIterator implements Iterator {
    ArrrayList<Account> accounts;

    //This obtains an already existing ArrayList for use within this class
    public AccountIterator(ArrayList<Account> accounts2){
        this.accounts = accounts2;
    }

    //This function returns true if the ArrayList has a space next to the current one
    public boolean hasNext(int position){
        if(position >= accounts.size()){
            return false;
        } else{
            return true;
        }
    }

    //This function iterates to the next position in the ArrayList.
    @Override
    public Object next(int position){
        Account AccountItem = accounts.get(position);
        return AccountItem;
    }

    //This function checks when the position is at 0, and prevents the user from going back further
    @Override
    public boolean hasPrev(int position){
        if(position == 0){
            return false;
        }
        else {
            return true;
        }
    }
}
