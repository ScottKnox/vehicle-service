package com.digital.iqscroll.resource;

import com.digital.iqscroll.domain.Fact;
import com.digital.iqscroll.service.IFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FactResource {

    @Autowired
    private IFactService factService;

    @RequestMapping(value = "/facts", method = RequestMethod.GET)
    public List<Fact> getFacts() {
        return factService.getFacts();
    }

    @RequestMapping(value = "/facts", method = RequestMethod.POST)
    public Fact createFact(@RequestBody Fact fact) {
        return factService.createFact(fact);
    }

}
