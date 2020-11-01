package com.realtime.sum.cysum.controller;

import com.realtime.sum.cysum.entity.Person;
import com.realtime.sum.cysum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: com.realtime.sum.cysum.controller
 * @Author: chenyang
 * @Date: 2020/11/1
 * @Version: 1.0
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping
    public String test1(@RequestBody Person person){
        personService.concurrentWrite(person);
        return "success";
    }
}
