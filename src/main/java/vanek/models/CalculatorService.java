package vanek.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalculatorService {

    public void initialSetting(CalculatorDTO calculatorDTO) {
        calculatorDTO.setResult(0);
        resultToDisplay(calculatorDTO);
    }
    public void calculate(CalculatorDTO calculatorDTO) {
        String display = comaToDot(calculatorDTO.getDisplay());
        ArrayList<Float> numbers = new ArrayList<>();
        if (checkString(display)) {
            if (display.contains("+")) {
                getNumbers(display, "+", numbers);
                calculatorDTO.setResult(numbers.get(0) + numbers.get(1));
                resultToDisplay(calculatorDTO);
            } else if (display.contains("-")) {
                getNumbers(display, "-", numbers);
                calculatorDTO.setResult(numbers.get(0) - numbers.get(1));
                resultToDisplay(calculatorDTO);
            } else if (display.contains("*")) {
                getNumbers(display, "*", numbers);
                calculatorDTO.setResult(numbers.get(0) * numbers.get(1));
                resultToDisplay(calculatorDTO);
            } else if (display.contains("/")) {
                getNumbers(display, "/", numbers);
                calculatorDTO.setResult(numbers.get(0) / numbers.get(1));
                resultToDisplay(calculatorDTO);
            }
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

    private String comaToDot(String display) {
        return display.replace(",",".");
    }

    private boolean checkString(String string) {
        String myRegex = "[+-]?([0-9]*[.])?[0-9]+\\+[+-]?([0-9]*[.])?[0-9]+";
        //boolean match = string.matches(myRegex);
        //System.out.printf("");
        return string.matches(myRegex);
    }

    public void resultToDisplay(CalculatorDTO calculator) {
        calculator.setDisplay(dotToComa(Float.toString(calculator.getResult())));
    }

    public void errorToDisplay(CalculatorDTO calculatorDTO) {
        calculatorDTO.setResult(0);
        calculatorDTO.setDisplay("NaN");
    }
}
