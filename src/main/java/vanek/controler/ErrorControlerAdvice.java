package vanek.controler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControlerAdvice {

    //this reacts to all controllers errors
    @ExceptionHandler(value = Exception.class)
    public String redirectToErrorPage(){
        return "errorInController";
    }

}
