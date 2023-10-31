package vanek.controlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {

    //this reacts to all controllers errors
    @ExceptionHandler(value = Exception.class)
    public String redirectToErrorPage(){
        return "error2";
    }

}
