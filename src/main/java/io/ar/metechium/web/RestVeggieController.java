package io.ar.metechium.web;

import io.ar.metechium.domain.Vegetable;
import io.ar.metechium.domain.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/veggies")
public class RestVeggieController {
    @Autowired
    private VegetableRepository vegetableRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Vegetable> getAllVegetables() {
        return vegetableRepository.findAll();
    }

    // Get vegetable details by name
    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public Iterable<Vegetable> getVegetableByName(@PathVariable String name) {
        return vegetableRepository.findByName(name);
    }

    // Get Vegetable details by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Vegetable getVegetable(@PathVariable Long id) {
        return vegetableRepository.findOne(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Vegetable addVegetable(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

//    @RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
//    public Vegetable updateVegetable(@PathVariable Long id, @RequestBody Vegetable vegetable){
//        return vegetableRepository.save(vegetable);
//    }


    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String deleteVegetable(@PathVariable Long id) {
        vegetableRepository.delete(id);
        return "Delete success";
    }
}
