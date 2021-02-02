package ee.bcs.valiit.mybank;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyBankErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(Exception ex) {
        MyBankErrorResponse myBankError = new MyBankErrorResponse();
        myBankError.setMessage(ex.getMessage());
        return new ResponseEntity<Object>(myBankError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MyBankException.class)
    public ResponseEntity<Object> handleError(MyBankException ex) {
        MyBankErrorResponse myBankError = new MyBankErrorResponse();
        myBankError.setMessage(ex.getMessage());
        return new ResponseEntity<Object>(myBankError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}


