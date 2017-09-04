package core;

import java.util.*;

public class HashCode {

    public static void main(String[] args) {
        Person p1 = new Person("a", "b", 1);
        Person p2 = new Person("b", "c", 2);
        Person p3 = new Person("c", "d", 1);
        Person p4 = new Person("d", "e", 2);
        Person p5 = new Person("e", "f", 1);
        Person p6 = new Person("f", "g", 2);
        Person p7 = new Person("g", "h", 1);

        HashMap<Person, Person> map = new HashMap<>();

        System.out.println("Start HashMap.put()");

        map.put(p1, p1);
        map.put(p2, p2);
        map.put(p3, p3);
        map.put(p4, p4);
        map.put(p5, p5);
        map.put(p6, p6);
        map.put(p7, p7);

        System.out.println("Done HashMap.put(), size:" + map.size());

        System.out.println(map.get(p1));
        System.out.println(map.get(p2));
        System.out.println(map.get(p3));
        System.out.println(map.get(p4));
        System.out.println(map.get(p5));
        System.out.println(map.get(p6));
        System.out.println(map.get(p7));

        System.out.println("Done HashMap.get(), size:" + map.size());

        System.out.println("Start list.add()");

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);

        System.out.println("Done list.add(), size:" + list.size());

        System.out.println("Start HashSet.add()");
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);
        set.add(p7);

        System.out.println("Done HashSet.add(), size:" + set.size());

        System.out.println("Start TreeSet.add() without Comparator ");
        TreeSet<Person> set1 = new TreeSet();
        set1.add(p1);
        set1.add(p2);
        set1.add(p3);
        set1.add(p4);
        set1.add(p5);
        set1.add(p6);
        set1.add(p7);

        System.out.println("Done TreeSet.add() without Comparator, size:" + set1.size());

        System.out.println("Start TreeSet.add() with Custom Comparator ");

        set1 = new TreeSet(new PersonComparator());
        set1.add(p1);
        set1.add(p2);
        set1.add(p3);
        set1.add(p4);
        set1.add(p5);
        set1.add(p6);
        set1.add(p7);

        System.out.println("Done TreeSet.add() with Custom Comparator, size:" + set1.size());
    }


    static class Person implements Comparable<Person> {

        String firstName;
        String lastName;
        int    id;

        public Person(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            int hash = getId() * 8;
            System.out.println(this + " - hashCode:" + hash);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            Person person = (Person) obj;
            boolean returnVal = false;
            if(person.getFirstName().equals(getFirstName())
                && person.getLastName().equals(getLastName()))
                returnVal = true;
            else if (person.getId()==getId())
                returnVal = true;

            System.out.println(this + " equals? " + person + " = " + returnVal);

            return returnVal;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "'" + firstName + '\'' +
                    ",'" + lastName + '\'' +
                    "," + id +
                    '}';
        }

        @Override
        public int compareTo(Person person) {

            int returnVal;
            if(person.getFirstName().equals(getLastName()))
                returnVal = 0;
            else
                returnVal = 1;

            System.out.println(this + " compareTo? " + person + " = " + returnVal);
            return returnVal;
        }
    }

    static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            int returnVal;
            if(p1.getLastName().equals(p2.getFirstName()))
                returnVal = 0;
            else
                returnVal = 1;

            System.out.println(p1+ " compare? " + p2 + " = " + returnVal);
            return returnVal;
        }
    }
}
