package ee.bcs.valiit.tasks;

public class MyBankAccount {
    private Integer id;
    private String accountNumber;
    private int balance;
    private int depositAmount;
    private int withdrawAmount;
    private String transferToAccountNumber;
    private int transferToBalance;
    private int transferAmount;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(int withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getTransferToAccountNumber() {
        return transferToAccountNumber;
    }

    public void setTransferToAccountNumber(String transferToAccountNumber) {
        this.transferToAccountNumber = transferToAccountNumber;
    }

    public int getTransferToBalance() {
        return transferToBalance;
    }

    public void setTransferToBalance(int transferToBalance) {
        this.transferToBalance = transferToBalance;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }

    //    public int depositMoney() {
//        this.balance += this.depositAmount;
//        return this;
//    }
//
//    public void withdrawMoney() {
//        this.balance -= this.withdrawAmount;
//    }
}
