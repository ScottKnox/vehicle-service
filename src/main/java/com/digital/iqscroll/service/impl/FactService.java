package com.digital.iqscroll.service.impl;

import com.digital.iqscroll.domain.Fact;
import com.digital.iqscroll.datalayer.FactRepository;
import com.digital.iqscroll.service.IFactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactService implements IFactService {
    Logger logger = LoggerFactory.getLogger(FactService.class);

    @Autowired
    private FactRepository factRepository;

    @Override
    public List<Fact> getFacts() {
        List<Fact> facts = new ArrayList<>();

        Iterable<Fact> dbFacts = factRepository.findAll();
        dbFacts.forEach(facts::add);

        return facts;
    }
}
