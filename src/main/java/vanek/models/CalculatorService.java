package vanek.models;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CalculatorService {

    public void initialSetting(CalculatorDTO calculatorDTO) {
        resultToDisplay(0, calculatorDTO);
    }

    public void calculate(CalculatorDTO calculatorDTO) {
        String display = comaToDot(calculatorDTO.getDisplay());
        if (checkString(display) == 2) {
            ArrayList<Float> numbers = new ArrayList<>();
            if (display.contains("+")) {
                getNumbers(display, "+", numbers);
                resultToDisplay((numbers.get(0) + numbers.get(1)), calculatorDTO);
            } else if (display.contains("-")) {
                getNumbers(display, "-", numbers);
                resultToDisplay((numbers.get(0) - numbers.get(1)), calculatorDTO);
            } else if (display.contains("*")) {
                getNumbers(display, "*", numbers);
                resultToDisplay((numbers.get(0) * numbers.get(1)), calculatorDTO);
            } else if (display.contains("/")) {
                getNumbers(display, "/", numbers);
                resultToDisplay((numbers.get(0) / numbers.get(1)), calculatorDTO);
            }
        } else if (checkString(display) == 1) {
            resultToDisplay(Float.parseFloat(comaToDot(calculatorDTO.getDisplay())), calculatorDTO);
        } else {
            errorToDisplay(calculatorDTO);
        }
    }

    private void getNumbers(String display, String sign, ArrayList<Float> numbers) {
        int index = display.indexOf("");
        numbers.add(Float.parseFloat(display.substring(0,display.indexOf(sign))));
        numbers.add(Float.parseFloat(display.substring(display.indexOf(sign)+1, display.length())));
        System.out.printf("");
    }

    private String dotToComa(String display) {
        return display.replace(".",",");
    }

    private String comaToDot(String display) { return display.replace(",","."); }

    private int checkString(String string) {
        String myRegexOne = "[+-]?([0-9]*[.])?[0-9]+";
        String myRegexTwo = "[+-]?([0-9]*[.])?[0-9]+[-+*/][+-]?([0-9]*[.])?[0-9]+";
        //boolean match = string.matches(myRegexTwo);
        //System.out.printf("this is used as a break point when debugging regex (observing match variable");
        if (string.matches(myRegexTwo)) {
            return 2;
        } else if (string.matches(myRegexOne)) {
            return 1;
        } else {
            return 0;
        }
    }

    public void resultToDisplay(float result, CalculatorDTO calculatorDTO) {
        calculatorDTO.setResult(result);
        calculatorDTO.setDisplay(dotToComa(Float.toString(calculatorDTO.getResult())));
    }

    public void errorToDisplay(CalculatorDTO calculatorDTO) {
        calculatorDTO.setResult(0);
        calculatorDTO.setDisplay("NaN");
    }

}
