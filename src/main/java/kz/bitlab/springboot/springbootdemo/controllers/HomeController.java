package kz.bitlab.springboot.springbootdemo.controllers;

import kz.bitlab.springboot.springbootdemo.db.DBManager;
import kz.bitlab.springboot.springbootdemo.db.Items;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model){
        ArrayList<Items> items = DBManager.getItems();
        model.addAttribute("tovary",items);
        return "index";
    }
    @GetMapping(value = "/itemAdd")
    public String itemAdd(){
        return "itemAdd";
    }

    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "item_name", defaultValue = "NO NAME") String name,
                          @RequestParam(name = "item_price",defaultValue = "0") int price,
                          @RequestParam(name = "item_details", defaultValue = "NO DETAILS") String details){
       DBManager.addItem(new Items(null,name,price,details));
       return "redirect:/";
    }
    @GetMapping(value = "/more/{idshka}")
    public String more(Model model,@PathVariable(name="idshka")Long id){
        Items item = DBManager.getItem(id);
        model.addAttribute("item",item);
        return "more";
    }
}