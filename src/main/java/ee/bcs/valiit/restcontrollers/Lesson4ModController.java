package ee.bcs.valiit.restcontrollers;


import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("Lesson4ModController")
@RestController
public class Lesson4ModController {
    static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();
    static int accountNumberInt = 0;

    //http://localhost:8080/Lesson4ModController/createAccount/

    @GetMapping("createAccount")
    public String createAccount () {
        accountNumberInt++;
        String accountNumberString = Integer.toString(accountNumberInt);
        accountBalanceMap.put(accountNumberString, BigDecimal.ZERO);

        return "Account created! Your account number is: " + accountNumberInt;
    }

    @GetMapping("getBalance/{a}")
    public BigDecimal getBalance(@PathVariable("a") String aVar) {
        return accountBalanceMap.get(aVar);
    }

    @GetMapping("depositMoney/{a}/{b}")
    public static String depositMoney(@PathVariable("a") String requestedAccount, @PathVariable("b") String depositedMoney) {
        BigDecimal balanceVar = new BigDecimal(String.valueOf(accountBalanceMap.get(requestedAccount)));
        BigDecimal depositVar = new BigDecimal(String.valueOf(depositedMoney));

        if (balanceVar.compareTo(BigDecimal.ZERO) >= 0) {
            accountBalanceMap.put(requestedAccount, balanceVar.add(depositVar));
            return depositedMoney + " added to account nr: " + requestedAccount;
        }
        else {
            return "Sorry, mate... can't deposit negative numbers";
        }

    }

    @GetMapping("withdrawMoney/{a}/{b}")
    public static String withdrawMoney(@PathVariable("a") String requestedAccount, @PathVariable("b") String withdrawMoney) {
        BigDecimal balanceVar = new BigDecimal(String.valueOf(accountBalanceMap.get(requestedAccount)));
        BigDecimal withdrawVar = new BigDecimal(String.valueOf(withdrawMoney));

        if (balanceVar.compareTo(BigDecimal.ZERO) >= 0 && balanceVar.compareTo(withdrawVar) > 0) {
            accountBalanceMap.put(requestedAccount, balanceVar.subtract(withdrawVar));
            return withdrawMoney + " withdrawn from account nr: " + requestedAccount;
        }
        else {
            return "Sorry, mate... can't withdraw negative numbers";
        }

    }

    @GetMapping("transfer/{a}/{b}/{c}")
    public static String transfer (@PathVariable("a") String yourAccount, @PathVariable("b") String receiverAccount, @PathVariable("c") String transferredMoney ) {

        BigDecimal yourBalanceVar = new BigDecimal(String.valueOf(accountBalanceMap.get(yourAccount)));
        BigDecimal receiverBalanceVar = new BigDecimal(String.valueOf(accountBalanceMap.get(receiverAccount)));
        BigDecimal transferVar = new BigDecimal(String.valueOf(transferredMoney));

        if (yourBalanceVar.compareTo(BigDecimal.ZERO) >= 0 && yourBalanceVar.compareTo(transferVar) > 0) {

            accountBalanceMap.put(yourAccount, yourBalanceVar.subtract(transferVar));
            accountBalanceMap.put(receiverAccount, receiverBalanceVar.add(transferVar));

            return transferredMoney + " was transferred from account " + yourAccount + " to account " + receiverAccount;
        }
        else {
            return "Sorry, mate... you cant transfer negative amount and you must have enough money!";
        }
    }

}
