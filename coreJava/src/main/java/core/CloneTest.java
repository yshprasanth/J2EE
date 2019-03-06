package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongArray;

public abstract class CloneTest {

    public static void main(String[] args) {
        Person one = new Person("one",1 , null);
        Person two = new Person("two",2 , one);
        Person three = new Person("three",3, null );
        Person four = new Person("four",4 , three);

        try {
            Object five =  one.clone();
            System.out.println("cloned from one:" + five);

            Object six =  two.clone();
            System.out.println("cloned from two:" + six);

            Object seven =  three.clone();
            System.out.println("cloned from three:" + seven);

            Object eight =  four.clone();
            System.out.println("cloned from four:" + eight);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    public abstract void hello();
}

class Person implements Cloneable{
    String name;
    int number;
    List<Person> managerList = new ArrayList<>();

    public Person(String name, int number, Person manager) {
        this.name = name;
        this.number = number;
        this.managerList.add(manager);
        System.out.println(toString());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", manager=" + managerList.get(0) +
                '}';
    }
}