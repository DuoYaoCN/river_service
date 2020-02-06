package com.river.controller;

import com.river.domain.Scenery;
import com.river.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping("/verifyImages/{images}")
    public Scenery getVerify(@PathVariable byte[] images){ return service.verifySense(images);}
}
