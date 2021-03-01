package com.digital.iqscroll.resource;

import com.digital.iqscroll.domain.Fact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FactResource {

    @RequestMapping("/facts")
    public List<Fact> getFacts() {
        List<Fact> facts = new ArrayList<>();
        Fact fact1 = new Fact("1", "../../assets/images/alligator.jpg", "Alligators are fun");
        Fact fact2 = new Fact("2", "../../assets/images/girafee.jpg", "Giraffes are fun");
        facts.add(fact1);
        facts.add(fact2);

        return facts;
    }

}
