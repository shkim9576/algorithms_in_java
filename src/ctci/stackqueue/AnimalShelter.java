package ctci.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.name = "d1";
        Dog d2 = new Dog();
        d2.name = "d2";
        Cat c1 = new Cat();
        c1.name = "c1";
        Cat c2 = new Cat();
        c2.name = "c2";
        Dog d3 = new Dog();
        d3.name = "d3";

        AnimalShelter ob = new AnimalShelter();
        ob.add(d1);
        ob.add(d2);
        ob.add(c1);
        ob.add(c2);
        ob.add(d3);

        System.out.println(ob.removeCat());
        System.out.println(ob.removeDog());
        System.out.println(ob.remove());
        System.out.println(ob.remove());
        System.out.println(ob.remove());
        System.out.println(ob.remove());
    }

    static abstract class Animal {
        String name;
        int order;

        public String toString() {
            return name;
        }
    }

    static class Dog extends Animal {
    }

    static class Cat extends Animal {
    }

    Queue<Dog> dogs = new LinkedList<>();
    Queue<Cat> cats = new LinkedList<>();
    int order = 0;

    void add(Animal a) {
        a.order = order++;
        if (a instanceof Dog) dogs.add((Dog) a);
        else cats.add((Cat) a);
    }

    Dog removeDog() {
        return (dogs.isEmpty()) ? null : dogs.remove();
    }

    Cat removeCat() {
        return (cats.isEmpty()) ? null : cats.remove();
    }

    Animal remove() {
        if (dogs.isEmpty()) return removeCat();
        if (cats.isEmpty()) return removeDog();

        return (dogs.peek().order < cats.peek().order) ? removeDog() : removeCat();
    }
}


