package com.clean.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.clean.example.MainUseCase;

@Controller
public class MainController {

    private MainUseCase mainUseCase;

    @Autowired
    public MainController (MainUseCase mainUseCase){
        this.mainUseCase = mainUseCase;
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        mainUseCase.CreateMember("aa","SUCCESS!!");
        return mainUseCase.GetMemberDetails("aa").getName();
    }
}