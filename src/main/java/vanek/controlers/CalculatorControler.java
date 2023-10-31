package vanek.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vanek.models.CalculatorDTO;
import vanek.models.CalculatorService;

@Controller
@RequestMapping("calculator")
public class CalculatorControler {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String renderCalculator(@ModelAttribute CalculatorDTO calculatorDTO) {
        calculatorService.initialSetting(calculatorDTO);
        return "calculator";
    }

    @PostMapping
    public String calculateCalculator(@ModelAttribute CalculatorDTO calculatorDTO) {
        calculatorService.calculate(calculatorDTO);
        return "calculator";
    }

}
