package ee.bcs.valiit.mybank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Repository
public class MyBankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount (String accountNr, int customerID) {
        String sql = "INSERT INTO accounts (accountnumber, customer_id, balance) VALUES (:accountParam, :customerIdParam, :balanceParam)";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("accountParam", accountNr);
        paramMap.put("customerIdParam", customerID);
        paramMap.put("balanceParam", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public void addCustomer (String name, String address, String phone) {
        String sql = "INSERT INTO customers (name, address, phone) VALUES (:nameParam, :addressParam, :phoneParam)";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("nameParam", name);
        paramMap.put("addressParam", address);
        paramMap.put("phoneParam", phone);
        jdbcTemplate.update(sql, paramMap);
    }

    public int getBalance (String accountNr) {
        String sql = "SELECT balance FROM accounts WHERE accountnumber = :accountnumberParam";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountnumberParam", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void setBalance (String accountNr, int depositAmount) {
        String sql2 = "UPDATE accounts SET balance = :updateBalance WHERE accountnumber = :accountnumberParam";
        Map<String, Object>  paramMap2 = new Hashtable<>();
        paramMap2.put("accountnumberParam", accountNr);
        paramMap2.put("updateBalance", depositAmount);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public void logHistory (int amount, String fromAccount, String toAccount) {
        String sql = "INSERT INTO accounthistory (timestamp, amount, fromaccount, toaccount) VALUES (current_timestamp, :amountParam, :fromAccountParam, :toAccountParam)";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("amountParam",amount);
        paramMap.put("fromAccountParam",fromAccount);
        paramMap.put("toAccountParam",toAccount);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<MyBankAccount> getAccounts () {
        String sql = "SELECT * FROM accounts";
        List<MyBankAccount> result = jdbcTemplate.query(sql, new HashMap<>(), new MyBankRepository.MyBankAccountRowMapper());
        return result;
    }

    public List<MyBankCustomer> getCustomers () {
        String sql = "SELECT * FROM customers";
        List<MyBankCustomer> result = jdbcTemplate.query(sql, new HashMap<>(), new MyBankRepository.MyBankCustomerRowMapper());
        return result;
    }

    public String findByUserName (String userName) {
        String sql = "SELECT user_password FROM my_bank_users WHERE user_name = :userNameParam";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("userNameParam", userName);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    private class MyBankAccountRowMapper implements RowMapper<MyBankAccount> {
        @Override
        public MyBankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
            MyBankAccount myBankAccount = new MyBankAccount();
            myBankAccount.setAccountNumber(resultSet.getString("accountnumber"));
            myBankAccount.setBalance(resultSet.getInt("balance"));
            myBankAccount.setId(resultSet.getInt("id"));
            myBankAccount.setCustomerID(resultSet.getInt("customer_id"));
            return myBankAccount;
        }
    }

    private class MyBankCustomerRowMapper implements RowMapper<MyBankCustomer> {
        @Override
        public MyBankCustomer mapRow(ResultSet resultSet, int i) throws SQLException {
            MyBankCustomer myBankCustomer = new MyBankCustomer();
            myBankCustomer.setName(resultSet.getString("name"));
            myBankCustomer.setAddress(resultSet.getString("address"));
            myBankCustomer.setPhone(resultSet.getString("phone"));
            return myBankCustomer;
        }
    }
}
