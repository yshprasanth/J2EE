package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        Group g = new Group();
        List listPersons = new ArrayList<Person>();
        g.setListPersons(listPersons);

        listPersons.add(new Person("A", "B"));
        listPersons.add(new Person("C", "D"));
        listPersons.add(new Person("E", "F"));

        g.display();

        g.order(true);
        g.display();

        g.order(false);
        g.display();
    }
}

class Group {
    protected List<Person> listPersons;

    public Group() {
        this.listPersons = new ArrayList<Person>();
    }

    public Group(List<Person> listPersons) {
        this.listPersons = listPersons;
    }

    public void order(boolean asc) {
        Comparator<Person> comp = asc ? new ComparePerson() : Collections.reverseOrder(new ComparePerson());
        Collections.sort(this.listPersons, comp);
    }

    public void display() {
        for (Person p : this.listPersons) {
            System.out.println(p);
        }
    }

    public List<Person> getListPersons() {
        return listPersons;
    }

    public void setListPersons(List<Person> listPersons) {
        this.listPersons = listPersons;
    }

}

class ComparePerson implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getFname().equalsIgnoreCase(p2.getFname())) {
            return p1.getLname().compareTo(p2.getLname());
        }
        return p1.getFname().compareTo(p2.getFname());
    }
}

class Person {
    protected String fname;
    protected String lname;

    public Person() {

    }

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public boolean equals(Object objet) {
        if (objet instanceof Person) {
            Person p = (Person) objet;
            return p.getFname().equals(this.getFname())
                    && p.getLname().equals(this.lname);
        } else
            return super.equals(objet);
    }

    @Override
    public String toString() {
        return "Person(fname : " + getFname() + ", lname : " + getLname() + ")";
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

}
