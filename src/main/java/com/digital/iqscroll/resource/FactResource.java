package com.digital.iqscroll.resource;

import com.digital.iqscroll.domain.Fact;
import com.digital.iqscroll.service.IFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FactResource {

    @Autowired
    private IFactService factService;

    @RequestMapping(value = "/facts", method = RequestMethod.GET)
    public List<Fact> getFacts() {
        return factService.getFacts();
    }

}
