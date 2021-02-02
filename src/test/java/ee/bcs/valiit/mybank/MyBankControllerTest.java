package ee.bcs.valiit.mybank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MyBankControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addAccount() throws Exception {
        // http://localhost:8080/mybank/addAccount?accountNr=EE0003
        mockMvc.perform(MockMvcRequestBuilders.post("/mybank/addAccount?accountNr=EE0002&customerID=2")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addCustomer() throws Exception {
        // http://localhost:8080/mybank/addCustomer?name=Andrus&address=Tallinn&phone=1234
        mockMvc.perform(MockMvcRequestBuilders.post("/mybank/addCustomer?name=Andrus&address=Tallinn&phone=1234")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getBalance() throws Exception {
        // http://localhost:8080/mybank/getBalance?accountNr=EE0003
        mockMvc.perform(MockMvcRequestBuilders.get("/mybank/getBalance?accountNr=EE0003")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void depositMoney() throws Exception {
        // http://localhost:8080/mybank/depositMoney?accountNr=EE0003&depositAmount=10
        mockMvc.perform(MockMvcRequestBuilders.put("/mybank/depositMoney?accountNr=EE0003&depositAmount=10")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void withdrawMoney() throws Exception {
        // http://localhost:8080/mybank/withdrawMoney?accountNr=EE0003&withdrawAmount=10
        mockMvc.perform(MockMvcRequestBuilders.put("/mybank/withdrawMoney?accountNr=EE0003&withdrawAmount=10")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void transferMoney() throws Exception {
        // http://localhost:8080/mybank/transferMoney?fromAccount=EE0001&toAccount=EE0003&transferAmount=10
        mockMvc.perform(MockMvcRequestBuilders.put("/mybank/transferMoney?fromAccount=EE0001&toAccount=EE0003&transferAmount=10")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAccounts() throws Exception {
        // http://localhost:8080/mybank/getAccounts
        mockMvc.perform(MockMvcRequestBuilders.get("/mybank/getAccounts")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getCustomers() throws Exception {
        // http://localhost:8080/mybank/getCustomers
        mockMvc.perform(MockMvcRequestBuilders.get("/mybank/getCustomers")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}