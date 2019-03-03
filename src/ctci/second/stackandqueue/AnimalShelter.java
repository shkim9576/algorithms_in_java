package ctci.second.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    public static void main(String[] args) {
        AnimalQueue aq = new AnimalQueue();
        aq.enqueue(new Dog("d1"));
        aq.enqueue(new Dog("d2"));
        aq.enqueue(new Cat("c1"));
        aq.enqueue(new Dog("d3"));
        aq.enqueue(new Dog("d4"));
        aq.enqueue(new Cat("c2"));
        aq.enqueue(new Cat("c3"));
        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueCat().name);
        System.out.println(aq.dequeueDog().name);
        System.out.println(aq.dequeueCat().name);
        System.out.println(aq.dequeueDog().name);
    }

    static class AnimalQueue {
        Queue<Dog> dogQ = new LinkedList<>();
        Queue<Cat> catQ = new LinkedList<>();
        int order = 0;

        void enqueue(Animal animal) {
            this.order++;
            animal.order = this.order;
            if (animal instanceof Dog) {
                dogQ.add((Dog) animal);
            } else if (animal instanceof Cat) {
                catQ.add((Cat) animal);
            }
        }

        Dog dequeueDog() {
            return dogQ.remove();
        }

        Cat dequeueCat() {
            return catQ.remove();
        }

        Animal dequeueAny() {
            if (dogQ.isEmpty()) return catQ.remove();
            if (catQ.isEmpty()) return dogQ.remove();
            int catOrder = catQ.peek().order;
            int docOrder = dogQ.peek().order;
            return catOrder < docOrder ? catQ.remove() : dogQ.remove();
        }
    }

    static abstract class Animal {
        int order;
        String name;

        Animal(String name) {
            this.name = name;
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }
    }

    static class Cat extends Animal {
        Cat(String name) {
            super(name);
        }
    }
}
