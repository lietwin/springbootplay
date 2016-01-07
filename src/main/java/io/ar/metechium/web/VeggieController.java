package io.ar.metechium.web;

import io.ar.metechium.domain.Vegetable;
import io.ar.metechium.domain.VegetableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger logger = LoggerFactory.getLogger("VeggieController");

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
        return "veggieList";
    }

    @RequestMapping(value = "/veggie/edit", method = RequestMethod.GET)
    public String createOrUpdate(@RequestParam(value = "id", required = false) Long id, Model model){
        if(id != null){
         Vegetable veg  = veggieRepository.findOne(id);
            logger.info(veg.toString());
            model.addAttribute("vegetable", veg);
        }else {
            model.addAttribute("vegetable", new Vegetable());
        }

        return "veggieUpdateForm";
    }

    @RequestMapping(value = "/veggie/edit")
    public String createOrUpdateSave(@RequestParam(value = "id", required = true) Long id, @ModelAttribute Vegetable vegetable, Model model) {
        veggieRepository.save(vegetable);
        if (null != id) {
            logger.info("Veggie update");
        } else {
            logger.info("Veggie Creation");
        }
        return "redirect:/veggie";
    }

    @RequestMapping(value = "/veggie/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) Long id, Model model) {
        veggieRepository.delete(id);
        return "redirect:/veggie";
    }

}
