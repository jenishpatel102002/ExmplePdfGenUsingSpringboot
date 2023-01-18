package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    ServiceInterface serviceInterface;
    @GetMapping("/")
    public String getHello(){
        return "Hello Boys";
    }

    // dateformate to enter here yyyy-MM-dd
    @GetMapping("/pdfGenrate/{StartDate}/{EndDate}")
    public ResponseEntity<InputStreamResource> getpdffrom(@PathVariable("StartDate") String startdate,@PathVariable("EndDate") String enddate){
        //call service class
        return serviceInterface.getpdffrom(startdate, enddate);
    }
}
