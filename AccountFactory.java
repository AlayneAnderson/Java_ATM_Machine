public class AccountFactory extends Account {

    public AccountFactory(String Username, int theAccountNumbner, int thePIN, double theAvailableBalance, double theTotalBalance, int isadmin) {
        super(Username, theAccountNumbner, thePIN, theAvailableBalance, theTotalBalance, isadmin);
        setUsername(Username);
        setAccountNumber(theAccountNumbner);
        setPin(thePIN);
        setAvailableBalance(theAvailableBalance);
        setTotalBalance(theTotalBalance);
        setAdmin(isadmin);

    }
}
