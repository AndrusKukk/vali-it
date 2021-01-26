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

    public void createAccount (String accountNr) {
        String sql = "INSERT INTO accounts (accountnumber, balance) VALUES (:accountParam, :balanceParam)";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("accountParam", accountNr);
        paramMap.put("balanceParam", BigDecimal.ZERO);
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

    public List<MyBankAccount> getAccounts () {
        String sql = "SELECT * FROM accounts";
        List<MyBankAccount> result = jdbcTemplate.query(sql, new HashMap<>(), new MyBankRepository.MyBankAccountRowMapper());
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
