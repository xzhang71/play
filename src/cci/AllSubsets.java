package cci;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class AllSubsets {

    public static Set<Set<Integer>> allSubsets(Set<Integer> set) {
        Set<Set<Integer>> subsets = new HashSet<>();
        subsets.add(new HashSet<Integer>());
        for (int i : set) {
            Set<Set<Integer>> newSubsets = new HashSet<>();
            for (Set s : subsets) {
                Set<Integer> ns = new HashSet<Integer>(s);
                ns.add(i);
                newSubsets.add(ns);
            }

            subsets.addAll(newSubsets);
        }
        return subsets;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(i);
        }

        Set<Set<Integer>> allSubsets = AllSubsets.allSubsets(set);
        for (Set<Integer> s : allSubsets) {
            System.out.print("subset of size " + s.size() + ": ");
            for (int i : s) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
