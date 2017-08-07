package com.sai.sri.siddhi.j2ee.design.structural.filter;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> filteredPersons = persons.stream()
                                            .filter(p -> p.getGender().equalsIgnoreCase("FEMALE"))
                                            .collect(Collectors.toList());
        return  filteredPersons;
    }
}
