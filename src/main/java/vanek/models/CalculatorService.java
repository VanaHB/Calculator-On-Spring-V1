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
        String display = calculatorDTO.getDisplay();
        ArrayList<Float> numbers = new ArrayList<>();
        if (display.contains("+")) {
            getNumbers(display,"+", numbers);
            calculatorDTO.setResult(numbers.get(0) + numbers.get(1));
            resultToDisplay(calculatorDTO);
        } else if (display.contains("-")) {
            getNumbers(display,"-", numbers);
            calculatorDTO.setResult(numbers.get(0) - numbers.get(1));
            resultToDisplay(calculatorDTO);
        } else if (display.contains("*")) {
            getNumbers(display,"*", numbers);
            calculatorDTO.setResult(numbers.get(0) * numbers.get(1));
            resultToDisplay(calculatorDTO);
        } else if (display.contains("/")) {
            getNumbers(display,"/", numbers);
            calculatorDTO.setResult(numbers.get(0) / numbers.get(1));
            resultToDisplay(calculatorDTO);
        }

    }

    private void getNumbers(String display, String sign, ArrayList<Float> numbers) {
        int index = display.indexOf("");
        numbers.add(Float.parseFloat(display.substring(0,display.indexOf(sign))));
        numbers.add(Float.parseFloat(display.substring(display.indexOf(sign)+1, display.length())));
        System.out.printf("");
    }
    private void checkString() {

    }

    public void resultToDisplay(CalculatorDTO calculator) {
        calculator.setDisplay(Float.toString(calculator.getResult()));
    }
}
