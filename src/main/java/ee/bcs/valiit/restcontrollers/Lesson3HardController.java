package ee.bcs.valiit.restcontrollers;

import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.Scanner;

@RequestMapping("Lesson3Hard")
@RestController
public class Lesson3HardController {
    Random random = new Random();
    public int generatedRandom = random.nextInt(100);
    public int turnCounter = 0;


    //http://localhost:8080/Lesson3Hard/evenFibonacci/30
    @GetMapping("evenFibonacci/{a}")
    public int evenFibonacci(@PathVariable("a") int aVar) {
        return Lesson3Hard.evenFibonacci(aVar);
    }

    //http://localhost:8080/Lesson3Hard/randomGame/
    @GetMapping("randomGame/{a}")
    public String randomGame(@PathVariable("a") int aVar){
        turnCounter++;

        if (aVar == generatedRandom) {
            return "Correct! It took " + turnCounter + " turns to guess the number";
        }
        else if (aVar < generatedRandom){
            return "Correct number is bigger... Try again!";
        }
        else if (aVar > generatedRandom){
            return "Correct number is smaller... Try again!";
        }
        else{
            return "hmmmm...";
        }

    }

    //http://localhost:8080/Lesson3Hard/morseCode/sos
    @GetMapping("morseCode/{a}")
    public String morseCode(@PathVariable("a") String aVar) {
        return Lesson3Hard.morseCode(aVar);
    }

}
