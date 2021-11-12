package org.anuraag.spring.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/greeting")
public class HelloController {

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello";
    }

    // Default RequestMapping is GET, so see the below syntax

    @RequestMapping("/proper")
    public String sayProperHello() {
        return "Proper Hello";
    }

    @RequestMapping("/user_entry")
    public String userForm() {
        return "<form action=\"/greeting/user_greeting\" method=\"GET\">\n" +
                "  <label for=\"fname\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\"><br>\n" +
                "  <label for=\"lname\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form>";
    }

    @RequestMapping(value = "/user_greeting", method = RequestMethod.GET)
    public String printUserGreeting(@RequestParam String fname,@RequestParam String lname) {
        return "Form submitted for user: " + fname + " " + lname;
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable String id) {
        return "Id: " + id;
    }

}
