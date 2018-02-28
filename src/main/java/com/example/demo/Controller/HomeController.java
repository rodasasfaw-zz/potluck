package com.example.demo.Controller;

import com.example.demo.Model.AppUser;
import com.example.demo.Model.PledgedItem;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.PotLuckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    PotLuckRepository potLuckRepository;


    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/newuser")
    public String newUser(Model model){
        model.addAttribute("appUser", new AppUser());
        return "registration";
    }

    @PostMapping("/newuser")
    public String processUser(@Valid @ModelAttribute("appUser") AppUser appUser){

        return "redirect:/login";
    }

    @RequestMapping("/")
    public String showIndex(Model model){

        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }
    @GetMapping("/additem")
    public String addItem(Model model){
        model.addAttribute("pledgeditems", new PledgedItem());
        return "pledgeitemform";
    }

    @PostMapping("/additemlist")
    public String showItem(@Valid @ModelAttribute("pledgeditems")PledgedItem items, BindingResult result,
                           Model model){
        if(result.hasErrors()){
            return  "pledgeitemform";
        }
        itemRepository.save(items);
        return "potlucklist";
    }
@RequestMapping("/additemtoappuser/{id}")
    public String addtoappuser(@PathVariable("id") long id, Authentication auth, PledgedItem pledgedItem, AppUser appUser, Model model){
    AppUser appUser1 = appUserRepository.findByUsername(auth.getName());
      PledgedItem pledgedItem1 = itemRepository.findOne(id);
     appUser.additem(pledgedItem1);
     model.addAttribute("pledgeitems", itemRepository.findOne(id));
      return "pledgedlist";

}

}
