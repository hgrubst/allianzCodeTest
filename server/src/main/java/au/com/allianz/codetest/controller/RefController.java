package au.com.allianz.codetest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ref")
public class RefController {

  @RequestMapping(value = "/issueTypes", method = RequestMethod.GET)
  public List<String> issueTypes(){
    List<String> types = new ArrayList<String>();
    types.add("Bug");
    types.add("Story");
    types.add("task");
    
    return types;
  }

  
}
