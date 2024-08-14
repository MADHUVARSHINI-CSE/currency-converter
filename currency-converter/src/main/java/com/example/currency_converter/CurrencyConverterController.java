package com.example.currency_converter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverterController {

    @GetMapping("/convert")
    public double convert(@RequestParam double amount, @RequestParam String from, @RequestParam String to) {
        double conversionRate = getConversionRate(from, to);
        return amount * conversionRate;
    }

    private double getConversionRate(String from, String to) {
        // Sample conversion rates (for demonstration purposes only)
        if (from.equals("INR") && to.equals("USD")) return 0.012;
        if (from.equals("USD") && to.equals("INR")) return 83.33;
        if (from.equals("INR") && to.equals("EUR")) return 0.011;
        if (from.equals("EUR") && to.equals("INR")) return 90.00;
        if (from.equals("INR") && to.equals("GBP")) return 0.009;
        if (from.equals("GBP") && to.equals("INR")) return 110.00;
        // Add more conversion rates if needed
        return 1.0;
    }
}
