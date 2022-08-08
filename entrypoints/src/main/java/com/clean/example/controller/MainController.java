package com.clean.example.controller;

import com.clean.example.controller.Entering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.clean.example.usecase.MainUseCase;
import org.springframework.ui.Model;
import java.util.List;
import java.util.logging.Logger;
@Controller
public class MainController {

    private MainUseCase mainUseCase;
    private final static Logger LOG = Logger.getGlobal();

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
        String memberId = entering.getMemberId();
        String name = entering.getName();
        if (mainUseCase.GetMemberByMemberId(memberId).isPresent()){
            model.addAttribute("isDuplicated", true);
            return "index";
        }
        else {
            mainUseCase.CreateMember(entering.getMemberId(), entering.getName());
            model.addAttribute("entering", entering);
            return "redirect:/memberList";
        }
    }

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() {
        return mainUseCase.greet();
    }

}