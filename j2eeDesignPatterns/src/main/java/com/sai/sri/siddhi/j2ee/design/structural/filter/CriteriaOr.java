package com.sai.sri.siddhi.j2ee.design.structural.filter;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaOr implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public CriteriaOr(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstPersons = criteria.meetCriteria(persons);
        List<Person> secondPersons = otherCriteria.meetCriteria(persons);

        firstPersons.addAll(secondPersons);

        return firstPersons.stream().distinct().collect(Collectors.toList());
    }
}
