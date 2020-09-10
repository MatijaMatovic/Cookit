package model;

public class AccountOwner {

    public AccountOwner() {
    }
    
    public AccountOwner(Account account,UserType userType ) {
        this.account = account;
        this.userType = userType;
    }

    private UserType userType;

    private Account account;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    

}