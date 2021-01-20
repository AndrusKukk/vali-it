package ee.bcs.valiit.restcontrollers;

import ee.bcs.valiit.tasks.Lesson1MathUtil;
import org.springframework.web.bind.annotation.*;

@RequestMapping("MathUtilController")
@RestController
public class Lesson1MathUtilController {

    //http://localhost:8080/MathUtilController/min?a=20&b=50
    @GetMapping("min")
    public int min(@RequestParam("a") int aVar, @RequestParam("b") int bVar) {
        return Lesson1MathUtil.min(aVar, bVar);
    }

    //http://localhost:8080/MathUtilController/max/20/5
    @GetMapping("max/{a}/{b}")
    public int max(@PathVariable("a") int aVar, @PathVariable("b") int bVar) {
        return Lesson1MathUtil.max(aVar, bVar);
    }

    //http://localhost:8080/MathUtilController/abs/-20
    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int aVar) {
        return Lesson1MathUtil.abs(aVar);
    }

    //http://localhost:8080/MathUtilController/isEven/20
    @GetMapping("isEven/{a}")
    public boolean isEven (@PathVariable("a") int aVar) {
        return Lesson1MathUtil.isEven(aVar);
    }

    //http://localhost:8080/MathUtilController/min3/20/60/2
    @GetMapping("min3/{a}/{b}/{c}")
    public int min3 (@PathVariable("a") int aVar, @PathVariable("b") int bVar, @PathVariable("c") int cVar) {
        return Lesson1MathUtil.min3(aVar, bVar, cVar);
    }

    //http://localhost:8080/MathUtilController/max3/20/60/2
    @GetMapping("max3/{a}/{b}/{c}")
    public int max3 (@PathVariable("a") int aVar, @PathVariable("b") int bVar, @PathVariable("c") int cVar) {
        return Lesson1MathUtil.max3(aVar, bVar, cVar);
    }
}
