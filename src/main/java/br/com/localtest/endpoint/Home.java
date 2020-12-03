package br.com.localtest.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {

    @RequestMapping(method = RequestMethod.GET)
    public String local() {
        return "Eu sou Full Cycle";
    }
}
