package com.digital.iqscroll.service;

import com.digital.iqscroll.domain.Fact;

import java.util.List;

public interface IFactService {
    Fact createFact(Fact fact);
    List<Fact> getFacts();
}
