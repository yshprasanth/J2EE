package com.sai.sri.siddhi.j2ee.design.structural.filter;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> filteredList = persons.stream()
                                        .filter(p -> p.getGender().equalsIgnoreCase("MALE"))
                                        .collect(Collectors.toList());

        return filteredList;
    }
}
