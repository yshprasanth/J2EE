package com.sai.sri.siddhi.j2ee.design.structural.filter;

import java.util.List;

public interface Criteria {

    List<Person> meetCriteria(List<Person> persons);
}
