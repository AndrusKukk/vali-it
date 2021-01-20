package ee.bcs.valiit.restcontrollers;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Lesson2")
@RestController
public class Lesson2Controller {

    //http://localhost:8080/Lesson2/exercise4/20
    @GetMapping("exercise4/{a}")
    public int exercise4(@PathVariable("a") int aVar) {
        return Lesson2.exercise4(aVar);
    }


}
