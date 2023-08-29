package script.comparable与comparator;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class ObjectComparatorDemo {

    public static void main(String[] args) {
        Person person1 = new Person("test001", 12);
        Person person2 = new Person("test002", 13);

        Comparator<Person> personComparator = Comparator.comparingInt(p -> p.age);
        int compareRes = Objects.compare(person1, person2, personComparator);

        System.out.println("年龄排序: " + compareRes);

    }


}


class Person {
    int age;
    String name;

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
