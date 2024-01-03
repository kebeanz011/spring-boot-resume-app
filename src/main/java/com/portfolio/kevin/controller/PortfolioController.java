package com.portfolio.kevin.controller;

import com.portfolio.kevin.entity.FormData;
import com.portfolio.kevin.fileUtil.FileUtil;
import com.portfolio.kevin.repository.FormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PortfolioController {

    @Autowired
    private FormDataRepository formDataRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/submitForm")
    public String submitForm(FormData contactForm, Model model) {
        FormData formData = new FormData(contactForm.getId(), contactForm.getName(), contactForm.getEmail(), contactForm.getPhone(), contactForm.getMessage());
        formDataRepository.save(formData);

        String fileContent = "Name: " + contactForm.getName() + "\nEmail: " + contactForm.getEmail() + "\nPhone Number: " + contactForm.getPhone() + "\nMessage: " + contactForm.getMessage();
        FileUtil.writeToFile(fileContent);

        model.addAttribute("message", "Form submitted successfully!");
        return "result";
    }

}
