package com.example.demo;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ServiceInterface {
    ResponseEntity<InputStreamResource> getpdffrom(String startdate,String enddate);
}
