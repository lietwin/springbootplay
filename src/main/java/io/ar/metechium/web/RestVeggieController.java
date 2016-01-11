package io.ar.metechium.web;

import io.ar.metechium.domain.Vegetable;
import io.ar.metechium.domain.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/veggies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RestVeggieController {
    @Autowired
    private VegetableRepository vegetableRepository;

    //Get all vegetable in stock
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

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vegetable addVegetable(@RequestBody Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vegetable updateVegetable(@PathVariable Long id, @RequestBody Vegetable vegetable) {
        Vegetable update = vegetableRepository.findOne(id);
        update.setPrice(vegetable.getPrice());
        update.setQuantity(vegetable.getQuantity());
        update.setName(vegetable.getName());
        update.setColor(vegetable.getColor());
        return vegetableRepository.save(update);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void deleteVegetable(@PathVariable Long id) {
        vegetableRepository.delete(id);
    }
}
