package ee.bcs.valiit.mybank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class MyBankService {

    @Autowired
    private MyBankRepository myBankRepository;

    public void createAccount(String accountNr, int customerID) {
        myBankRepository.createAccount(accountNr, customerID);
    }

    public void addCustomer(String name, String address, String phone) {
        myBankRepository.addCustomer(name, address, phone);
    }

    public List<MyBankAccount> getAccounts (MyBankAccount myBankAccount) {
        return myBankRepository.getAccounts();
    }

    public List<MyBankCustomer> getCustomers (MyBankCustomer myBankCustomer)     {
        return myBankRepository.getCustomers();
    }

    public int getBalance(String accountNr) {
        return myBankRepository.getBalance(accountNr);
    }

    public void depositMoney(String accountNr, int depositAmount) {
        int balance = myBankRepository.getBalance(accountNr);
        balance += depositAmount;
        myBankRepository.setBalance(accountNr, balance);
        myBankRepository.logHistory(depositAmount, "deposit", accountNr);
    }

    public void withdrawMoney(String accountNr, int withdrawAmount) {
        int balance = myBankRepository.getBalance(accountNr);

        if (balance < withdrawAmount) {
            throw new MyBankException("Not enough money");
        }
        balance -= withdrawAmount;
        myBankRepository.setBalance(accountNr, balance);
        myBankRepository.logHistory(withdrawAmount, accountNr, "withdraw");
    }


    public void transferMoney(String fromAccount, String toAccount, int transferAmount) {
        int fromBalance = myBankRepository.getBalance(fromAccount);
        int toBalance = myBankRepository.getBalance(toAccount);

        if (fromBalance < transferAmount) {
            throw new MyBankException("Not enough money");
        }

        int newFromBalance = fromBalance - transferAmount;
        int newToBalance = toBalance + transferAmount;

        myBankRepository.setBalance(fromAccount, newFromBalance);
        myBankRepository.setBalance(toAccount, newToBalance);
        myBankRepository.logHistory(transferAmount, fromAccount, toAccount);
        myBankRepository.logHistory(transferAmount, fromAccount, toAccount);

    }



}
