package org.delhivery.controllers;

import org.delhivery.resources.greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class greetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
