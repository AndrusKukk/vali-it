package ee.bcs.valiit.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test/{name}")
    public String getHelloWorld(@PathVariable("name") String muutuja){
        return "Hellooo " + muutuja;
    }

}
