package core;

public class CloneTest {

    public static void main(String[] args) {
        Person one = new Person("one",1 );
        Person two = new Person("two",2 );
        Person three = new Person("three",3 );
        Person four = new Person("four",4 );

        try {
            Object five =  one.clone();
            System.out.println("cloned:" + five);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Person implements  Cloneable{
    String name;
    int number;

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
        System.out.println(toString());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}