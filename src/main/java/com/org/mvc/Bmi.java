package com.org.mvc;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Bmi{

    @GetMapping("/calculate-bmi")
    public String calculateBMI(@RequestParam double weight, @RequestParam double height) {
        double bmi = weight / (height * height);

        String feedback;
        if (bmi < 18.5) {
            feedback = "You are underweight. Consider increasing your weight.";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            feedback = "Your BMI is in the healthy range. Keep up the good work!";
        } else if (bmi >= 25 && bmi < 29.9) {
            feedback = "You are overweight. Consider decreasing your weight.";
        } else {
            feedback = "Your BMI is very high. It's recommended to consult a healthcare professional.";
        }

        return "Your BMI: " + bmi + "\nFeedback: " + feedback;
    }
}
