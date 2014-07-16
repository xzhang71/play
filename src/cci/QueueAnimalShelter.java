package cci;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Animal shelter
 */
public class QueueAnimalShelter {
    private Queue<Dog> dogs = new LinkedList<>();
    private Queue<Cat> cats = new LinkedList<>();

    public Animal add(Animal animal) {
        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        } else {
            // TODO: invalid animal
        }

        return animal;
    }

    public Animal poll() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return null;
        } else if (dogs.isEmpty()) {
            return pollCat();
        } else if (cats.isEmpty()) {
            return pollDog();
        } else {
            if (dogs.peek().adoptedTimeMillis > cats.peek().adoptedTimeMillis) {
                return pollDog();
            } else {
                return pollCat();
            }
        }
    }

    public Dog pollDog() {
        return dogs.poll();
    }

    public Cat pollCat() {
        return cats.poll();
    }

    public static void main(String[] args) {
        QueueAnimalShelter queue = new QueueAnimalShelter();

        queue.add(new Cat("c0"));
        queue.add(new Dog("d0"));
        queue.add(new Cat("c1"));
        queue.add(new Dog("d1"));

        System.out.printf("%s has been adopted\n", queue.poll().name);
        System.out.printf("%s has been adopted\n", queue.pollDog().name);
        System.out.printf("%s has been adopted\n", queue.pollCat().name);
        System.out.printf("%s has been adopted\n", queue.poll().name);

        queue.add(new Dog("d2"));
        queue.add(new Dog("d3"));
        queue.add(new Dog("d4"));
        queue.add(new Dog("d5"));
        System.out.printf("%s has been adopted\n", queue.pollCat());
        System.out.printf("%s has been adopted\n", queue.pollDog().name);
        System.out.printf("%s has been adopted\n", queue.pollDog().name);
        System.out.printf("%s has been adopted\n", queue.poll().name);
        System.out.printf("%s has been adopted\n", queue.poll().name);
    }
}

abstract class Animal {
    protected String name;
    protected long adoptedTimeMillis;

    public Animal(String name) {
        this.name = name;
        adoptedTimeMillis = System.currentTimeMillis();
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
