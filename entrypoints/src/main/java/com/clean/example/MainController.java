package com.clean.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.clean.example.MainUseCase;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class MainController {

    private MainUseCase mainUseCase;

    @Autowired
    public MainController (MainUseCase mainUseCase){
        this.mainUseCase = mainUseCase;
    }

    @GetMapping("/")
    public String GetIndex(Model model) {
        model.addAttribute("entering", new Entering());

        return "index";
  //      return "redirect:/entering";
    }


    @GetMapping("/memberList")
    public String GetMemberList(Model model) {
        List<String> AllMemberName = this.mainUseCase.GetAllMemberName();
        model.addAttribute("memberList", AllMemberName);
        return "memberList";
    }


    @GetMapping("/entering")
    public String getEnter(Model model){
        model.addAttribute("entering", new Entering());
        return "entering";
    }

    @PostMapping("/entering")
    public String postEnter (@ModelAttribute Entering entering, Model model){
        mainUseCase.CreateMember(entering.getMemberId(),entering.getName());
        model.addAttribute("entering", entering);
        return "redirect:/memberList";
    }

}