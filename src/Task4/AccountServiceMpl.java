package Task4;

public class AccountServiceMpl implements AccountService {
    Account[] accounts;

    public AccountServiceMpl(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        for(Account i: accounts){
            if(id == i.getOwner().getId()){
                return i;
            }
        }
        return null;
    }


    @Override
    public long countAccountsWithBalanceGreaterThen(long value) {
        int num = 0;
        for(Account a : accounts){
            if(a.getBalance() > value){
                num++;
            }
        }
        return num;
    }


    public void show(){
        for (Account a: accounts){
            System.out.println("ID: " + a.getId() + ". Balance: " + a.getBalance() + ". Owner Info: " + a.getOwner().userInfo());
        }
    }
}
