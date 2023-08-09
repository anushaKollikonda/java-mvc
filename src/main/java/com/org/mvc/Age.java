package com.org.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class Age {

    @GetMapping("/calculate_age")
    public ResponseEntity<Integer> calculateAge(@RequestParam("dob") String dobStr) {
        try {
            if (dobStr == null || dobStr.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
            
            LocalDate dob = LocalDate.parse(dobStr);
            LocalDate today = LocalDate.now();
            Period period = Period.between(dob, today);
            int age = period.getYears();
            
            return ResponseEntity.ok(age);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/reverse")
    public String reverseName(@RequestParam String name) {
        return reverseString(name);
    }

    private String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }
    
    
}
