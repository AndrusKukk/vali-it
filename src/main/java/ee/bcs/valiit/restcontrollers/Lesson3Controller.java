package ee.bcs.valiit.restcontrollers;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Lesson3")
@RestController

public class Lesson3Controller {

    //http://localhost:8080/Lesson3/sum?a=20,30,40,580
    @GetMapping("sum")
    public int sum(@RequestParam("a") int[] aVar) {
        return Lesson3.sum(aVar);
    }

    //http://localhost:8080/Lesson3/factorial/10
    @GetMapping("factorial/{a}")
    public int factorial(@PathVariable("a") int aVar) {
        return Lesson3.factorial(aVar);
    }

    //http://localhost:8080/Lesson3/sort?a=10,20,50,30,100,2,5,3
    @GetMapping("sort")
    public int[] sort(@RequestParam("a") int[] aVar) {
        return Lesson3.sort(aVar);
    }

    //http://localhost:8080/Lesson3/reverseString/abcdefg
    @GetMapping("reverseString/{a}")
    public String reverseString(@PathVariable("a") String aVar) {
        return Lesson3.reverseString(aVar);
    }

    //http://localhost:8080/Lesson3/isPrime/5
    @GetMapping("isPrime/{a}")
    public boolean insPrime(@PathVariable("a") int aVar) {
        return Lesson3.isPrime(aVar);
    }
}
