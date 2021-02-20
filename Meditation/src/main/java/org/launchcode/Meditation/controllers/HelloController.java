package org.launchcode.Meditation.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // handles request at path /hello
    @GetMapping
    @ResponseBody
    public String hello(){
        return "Hello, welcome to your practice.";
    }

    //Handles request of the form /hello?name=Amber
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello " + name + ", welcome to your practice.";
    }

    //Handles request of form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello " + name + ", welcome to your practice.";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +  //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
