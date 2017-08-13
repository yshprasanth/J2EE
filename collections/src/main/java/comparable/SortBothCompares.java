package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Person implements Comparable {
    String firstName, lastName;

    public Person(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "[ firstname=" + firstName + ",lastname=" + lastName + "]";
    }

    public int compareTo(Object obj) {
        Person emp = (Person) obj;
        int deptComp = firstName.compareTo(emp.getFirstName());

        int returnVal = ((deptComp == 0) ? lastName.compareTo(emp.getLastName()) : deptComp);

        System.out.println(this + " is comparedTo " + emp + " = " + returnVal);
        return returnVal;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person emp = (Person) obj;
        return firstName.equals(emp.getFirstName()) && lastName.equals(emp.getLastName());
    }
}

class PersonComparator implements Comparator<Person> {
    public int compare(Person emp1, Person emp2) {
        int nameComp = emp1.getLastName().compareTo(emp2.getLastName());
        int returnVal = ((nameComp == 0) ? emp1.getFirstName().compareTo(emp2.getFirstName()) : nameComp);
        System.out.println(emp1 + " is comparator " + emp2 + " = " + returnVal);
        return returnVal;
    }
}
public class SortBothCompares {
    public static void main(String args[]) {
        ArrayList<Person> names = new ArrayList<>();
        names.add(new Person("E", "G"));
        names.add(new Person("A", "T"));
        names.add(new Person("A", "H"));
        names.add(new Person("C", "J"));

        Iterator iter1 = names.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
        Collections.sort(names, new PersonComparator());
        Iterator iter2 = names.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }

        Collections.sort(names);
        iter2 = names.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }
}
