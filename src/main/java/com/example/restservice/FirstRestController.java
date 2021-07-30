package com.example.restservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class FirstRestController {

   
  @GetMapping("/ping")
  public ResponseEntity<String> getState() {
    
    return ResponseEntity.ok().body("Hello World");
  }
  
   

}
