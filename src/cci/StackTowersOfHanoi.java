package cci;

import java.util.Stack;

/**
 * Problem of Towers of Hanoi
 */
public class StackTowersOfHanoi {

    public static void towersOfHanoi(int n, StackWithName source, StackWithName cache, StackWithName destination) {
        if (n <= 0) {
            return;
        }

        towersOfHanoi(n - 1, source, destination, cache);
        int disk = source.pop();
        destination.push(disk);
        System.out.printf("move disk %d from %s to %s\n", disk, source.getName(), destination.getName());
        towersOfHanoi(n - 1, cache, source, destination);
    }

    public static void main(String[] args) {
        StackWithName source = new StackWithName("source");
        StackWithName cache = new StackWithName("cache");
        StackWithName destination = new StackWithName("destination");
        for (int i = 10; i >= 1; i--) {
            source.push(i);
        }
        StackTowersOfHanoi.towersOfHanoi(source.size(), source, cache, destination);
        while (!destination.isEmpty()) {
            System.out.print(destination.pop() + " ");
        }
    }
}

class StackWithName extends Stack<Integer> {
    String name;

    StackWithName(String name) {
        super();
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
