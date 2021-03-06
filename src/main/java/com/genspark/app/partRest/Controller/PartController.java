package com.genspark.app.partRest.Controller;

import com.genspark.app.partRest.Service.PartService;
import com.genspark.app.partRest.Entity.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class PartController {
    private final PartService partService;
    //Constructor Injection: this is telling the spring framework to wire up your
    //dependencies for the partService.
    @Autowired
    public PartController(@Qualifier("partServiceIMPL")PartService partService) {
        this.partService = partService;
    }
    //This is a GET request that will read a list of all the parts.
    //http://localhost:8080/retrieveAllParts
    @GetMapping("/retrieveAllParts")
    public List<Part> findAll() {
        return partService.findAll();
    }


    ////This is a GET request that will read a single part
    ////http://localhost:8080/retrievePart/{id}
    @GetMapping("/retrievePart/{id}")
    public Part find(@PathVariable int id) {
        return (Part) partService.findById(id);
    }

    //This is a POST request to add a new part.
    //http://localhost:8080/addPart
    @PostMapping("/addPart")
    public Part addPart(@RequestBody Part thePart) {
        //also, just in case they pass an id in JSON .... set id to 0
        //this is to force a save of new item .... instead of update
        thePart.setId(0);
        //This will call the partDqoImpl.save method to save a new part
        //through the partService
        partService.saveOrUpdate(thePart);
        return thePart;
    }
    //This is a PUT request to update an existing part.
    //http://localhost:8080/updatePart
    @PutMapping("/updatePart")
    public Part updatePart(@RequestBody Part updatePart) {
        //Notice thePart.setId(0); this will execute an update instead of a create
        partService.saveOrUpdate(updatePart);
        return updatePart;
    }
    /*@PutMapping("/updatePart/{id}")
    public Part updatePart(@PathVariable int id,@RequestBody Part updatePart) {
        //Notice thePart.setId(0); this will execute an update instead of a create
        Part toPark = partService.findById(id);
        toPark.setName(updatePart.getName());
        partService.saveOrUpdate(toPark);
        return toPark;
    }*/

    //This is a DELETE request to delete an existing part.
    //http://localhost:8080/deletePart/1
    @DeleteMapping("/deletePart/{partId}")
    public String deletePart(@PathVariable int partId) {
        //This will execute the deleteByID.
        partService.deleteById(partId);
        return "Deleted part id : " + partId;
    }

}
