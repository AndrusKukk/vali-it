package ee.bcs.valiit.restcontrollers;

import ee.bcs.valiit.tasks.MyBankAccount;
import ee.bcs.valiit.tasks.MyBankCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RequestMapping("mybank")
@RestController
public class MyBankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @PostMapping("addAccount")
    public void addAccount(@RequestBody MyBankAccount myBankAccount){
        String sql = "INSERT INTO accounts (accountnumber, balance) VALUES (:accountParam, :balanceParam)";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("accountParam", myBankAccount.getAccountNumber());
        paramMap.put("balanceParam", myBankAccount.getBalance());
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("getBalance")
    public int getBalance(@RequestBody MyBankAccount myBankAccount) {
        String sql = "SELECT balance FROM accounts WHERE accountnumber = :accountnumberParam";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountnumberParam", myBankAccount.getAccountNumber());
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class); //Võiks tegelikult raw JSON'i tagastada.
    }

    @PutMapping("depositMoney")
    public void depositMoney(@RequestBody MyBankAccount myBankAccount){
        String sql = "SELECT  balance FROM accounts WHERE accountnumber = :accountnumberParam";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("accountnumberParam", myBankAccount.getAccountNumber());
        int balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        int depositAmount = myBankAccount.getDepositAmount();
        int newBalance = balance += depositAmount;
        myBankAccount.setBalance(newBalance);

        String sql2 = "UPDATE accounts SET balance = :updateBalance WHERE accountnumber = :accountnumberParam";
        Map<String, Object>  paramMap2 = new Hashtable<>();
        paramMap2.put("accountnumberParam", myBankAccount.getAccountNumber());
        paramMap2.put("updateBalance", myBankAccount.getBalance());
        jdbcTemplate.update(sql2, paramMap2);

    }

    @PutMapping("withdrawMoney")
    public void withdrawMoney(@RequestBody MyBankAccount myBankAccount){
        String sql = "SELECT  balance FROM accounts WHERE accountnumber = :accountnumberParam";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("accountnumberParam", myBankAccount.getAccountNumber());
        int balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        int withdrawAmount = myBankAccount.getWithdrawAmount();
        int newBalance = balance -= withdrawAmount;
        myBankAccount.setBalance(newBalance);

        String sql2 = "UPDATE accounts SET balance = :updateBalance WHERE accountnumber = :accountnumberParam";
        Map<String, Object>  paramMap2 = new Hashtable<>();
        paramMap2.put("accountnumberParam", myBankAccount.getAccountNumber());
        paramMap2.put("updateBalance", myBankAccount.getBalance());
        jdbcTemplate.update(sql2, paramMap2);

    }

    @PutMapping("transferMoney")
    public void transferMoney(@RequestBody MyBankAccount myBankAccount){
        String sql = "SELECT balance FROM accounts WHERE accountnumber = :fromAccount";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("fromAccount", myBankAccount.getAccountNumber());
        int fromBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        String sql2 ="SELECT balance FROM accounts WHERE accountnumber =:toAccount";
        Map<String, Object> paramMap2 = new Hashtable<>();
        paramMap2.put("toAccount", myBankAccount.getTransferToAccountNumber());
        int tobalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

        int newFromBalance = fromBalance - myBankAccount.getTransferAmount();
        int newToBalance = tobalance + myBankAccount.getTransferAmount();
        myBankAccount.setBalance(newFromBalance);
        myBankAccount.setTransferToBalance(newToBalance);

        String sql3 = "UPDATE accounts SET balance = :updateBalance1 WHERE accountnumber = :accountnumberParam1";
        Map<String, Object> paramMap3 = new Hashtable<>();
        paramMap3.put("accountnumberParam1", myBankAccount.getAccountNumber());
        paramMap3.put("updateBalance1", myBankAccount.getBalance());
        jdbcTemplate.update(sql3, paramMap3);

        String sql4 = "UPDATE accounts SET balance = :updateBalance2 WHERE accountnumber = :accountnumberParam2";
        Map<String, Object> paramMap4 = new Hashtable<>();
        paramMap4.put("accountnumberParam2", myBankAccount.getTransferToAccountNumber());
        paramMap4.put("updateBalance2", myBankAccount.getTransferToBalance());
        jdbcTemplate.update(sql4, paramMap4);


    }

    @GetMapping("getAccounts")
    public List<MyBankAccount> getAccounts() {
        String sql = "SELECT * FROM accounts";
        List<MyBankAccount> result = jdbcTemplate.query(sql, new HashMap<>(), new MyBankAccountRowMapper());
        return result;
    }

    private class MyBankAccountRowMapper implements RowMapper<MyBankAccount> {
        @Override
        public MyBankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
            MyBankAccount myBankAccount = new MyBankAccount();
            myBankAccount.setAccountNumber(resultSet.getString("accountnumber"));
            myBankAccount.setBalance(resultSet.getInt("balance"));
            myBankAccount.setId(resultSet.getInt("id"));
            return myBankAccount;


        }
    }
}
