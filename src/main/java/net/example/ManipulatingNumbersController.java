package net.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@RestController
@Validated
public class ManipulatingNumbersController {

    @Value("${customProperty.exponent}")
    private int exponentValue;

    @GetMapping("/calculate")
    public BigInteger calculate(@RequestParam(name="number") @PositiveOrZero int n){
        if(n%2 == 0){
            return getFactorial(n);
        }else{
            return BigInteger.valueOf(n).pow(exponentValue);
        }
    }

    private BigInteger getFactorial(int f) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= f; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

}
