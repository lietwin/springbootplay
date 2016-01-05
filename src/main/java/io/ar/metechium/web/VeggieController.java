package io.ar.metechium.web;

import io.ar.metechium.domain.Vegetable;
import io.ar.metechium.domain.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class VeggieController {

    @Autowired
    protected VegetableRepository veggieRepository;

    @RequestMapping("/")
    public String index(@RequestParam(value= "sound", required = false, defaultValue= "Bam") String sound, Model model){
        List<Vegetable> vegs = (List<Vegetable>) veggieRepository.findAll();
        model.addAttribute("sound", sound);
        return "index";
    }

    @RequestMapping("/veggie")
    public String listAll(Model model) {
        List<Vegetable> vegs = (List<Vegetable>) veggieRepository.findAll();
        model.addAttribute("vegetables", vegs);
        return "veggieHello";
    }

    @RequestMapping(value = "/veggie/add", method = RequestMethod.GET)
    public String createOrUpdate(@RequestParam(value = "id", required = false) Long id, Model model){
        if(id != null){
         Vegetable veg  = veggieRepository.findOne(id);
            model.addAttribute("vegetable", veg);
        }else {
            model.addAttribute("vegetable", new Vegetable());
        }
        return "veggieForm";
    }

    @RequestMapping(value = "/veggie/add", method = RequestMethod.POST)
    public String createOrUpdateSave(@ModelAttribute Vegetable vegetable, Model model){
        veggieRepository.save(vegetable);
        return "redirect:/veggie";
    }

}
