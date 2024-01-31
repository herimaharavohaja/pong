package com.pong.ping.controller;

import com.pong.ping.model.banque;
import com.pong.ping.service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/banque")
public class BanqueController {
   private final BanqueService service;
    @Autowired
    public BanqueController(BanqueService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<banque> findById(@PathVariable int id) {
        banque banque = service.findById(id);
        return new ResponseEntity<>(banque, HttpStatus.OK);
    }
}