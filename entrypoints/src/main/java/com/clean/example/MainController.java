package com.clean.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.clean.example.MainUseCase;
import org.springframework.ui.Model;

@Controller
public class MainController {

    private MainUseCase mainUseCase;

    @Autowired
    public MainController (MainUseCase mainUseCase){
        this.mainUseCase = mainUseCase;
    }

    @GetMapping("/")
    public String GetInit() {

        return "init";
    }

    @PostMapping("/")
    public String PostInit(){
        return "redirect:/memberList";
    }

    @GetMapping("/memberList")
    public String GetMemberList() {
        return "memberList";
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }


}