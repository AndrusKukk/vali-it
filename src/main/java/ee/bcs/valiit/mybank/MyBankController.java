package ee.bcs.valiit.mybank;

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

    private MyBankAccount myBankAccount;
    private MyBankCustomer myBankCustomer;

    @Autowired
    private MyBankService myBankService;

    // http://localhost:8080/mybank/addAccount?accountNr=EE0003
    @CrossOrigin
    @PostMapping("addAccount")
    public void addAccount(@RequestParam("accountNr") String accountNr, @RequestParam("customerID") int customerID){
        myBankService.createAccount(accountNr, customerID);
    }

    // http://localhost:8080/mybank/addCustomer?name=Andrus&address=Tallinn&phone=1234
    @PostMapping("addCustomer")
    public void addCustomer(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phone") String phone) {
        myBankService.addCustomer(name, address, phone);
    }

    // http://localhost:8080/mybank/getBalance?accountNr=EE0003
    @GetMapping("getBalance")
    public int getBalance(@RequestParam("accountNr") String accountNr) {
        return myBankService.getBalance(accountNr);
    }

    // http://localhost:8080/mybank/depositMoney?accountNr=EE0003&depositAmount=10
    @PutMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr,
                             @RequestParam("depositAmount") int depositAmount){
        myBankService.depositMoney(accountNr, depositAmount);
    }

    // http://localhost:8080/mybank/withdrawMoney?accountNr=EE0003&withdrawAmount=10
    @PutMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr,
                              @RequestParam("withdrawAmount") int withdrawAmount){
        myBankService.withdrawMoney(accountNr, withdrawAmount);
    }

    // http://localhost:8080/mybank/transferMoney?fromAccount=EE0001&toAccount=EE0003&transferAmount=10
    @PutMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("transferAmount") int transferAmount){
        myBankService.transferMoney(fromAccount, toAccount, transferAmount);
    }

    // http://localhost:8080/mybank/getAccounts
    @GetMapping("getAccounts")
    public List<MyBankAccount> getAccounts() {
        return myBankService.getAccounts(myBankAccount);
    }

    // http://localhost:8080/mybank/getCustomers
    @GetMapping("getCustomers")
    public List<MyBankCustomer> getCustomers() {
        return myBankService.getCustomers(myBankCustomer);
    }


}
