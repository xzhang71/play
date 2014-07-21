package cci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class TowerRoutine {
    public static List<Person> highestTowerRoutine(Person[] persons) {
        return highestTowerRoutine(persons, null, new HashMap<Person, List<Person>>());
    }

    private static List<Person> highestTowerRoutine(Person[] persons, Person bottom, Map<Person, List<Person>> cache) {
        if (bottom != null && cache.containsKey(bottom)) {
            return cache.get(bottom);
        }

        List<Person> tower = null;

        for (Person p : persons) {
            if (bottom == null || (bottom.ht > p.ht && bottom.wt > p.wt)) {
                List<Person> subTower = new ArrayList<>(highestTowerRoutine(persons, p, cache));
                if (tower == null || subTower.size() > tower.size()) {
                    tower = subTower;
                }
            }
        }

        if (tower == null) {
            tower = new ArrayList<>();
        }

        if (bottom != null) {
            tower.add(bottom);
            cache.put(bottom, tower);
        }

        return tower;
    }

    public static void main(String[] args) {
        Person[] persons = {new Person(65, 100), new Person(70, 150), new Person(56, 90), new Person(75, 190), new Person(60, 95), new Person(68, 110)};
        List<Person> tower = TowerRoutine.highestTowerRoutine(persons);
        for (Person p : tower) {
            System.out.printf("%3d %3d\n", p.ht, p.wt);
        }
    }
}

class Person {
    int ht;
    int wt;

    Person(int ht, int wt) {
        this.ht = ht;
        this.wt = wt;
    }
}