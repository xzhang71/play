package cci;

import java.util.*;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class BoxStack {

    public static List<Box> highestBoxStack(Box[] boxes) {
        return highestBoxStack(boxes, null, new HashMap<Box, List<Box>>());
    }

    private static List<Box> highestBoxStack(Box[] boxes, Box bottom, Map<Box, List<Box>> cache) {
        if (bottom != null && cache.containsKey(bottom)) {
            return cache.get(bottom);
        }

        List<Box> maxStack = null;
        int maxHeight = 0;

        for (int i = 0; i < boxes.length; i++) {
            if (bottom == null || boxes[i].isAbove(bottom)) {
                List<Box> newStack = highestBoxStack(boxes, boxes[i], cache);
                int newHeight = boxStackHeight(newStack);
                if (newHeight > maxHeight) {
                    maxStack = newStack;
                    maxHeight = newHeight;
                }
            }
        }

        if (maxStack == null) {
            maxStack = new ArrayList<>();
        }

        if (bottom != null) {
            maxStack.add(0, bottom);
            cache.put(bottom, maxStack);
        }

        return maxStack;
    }

    private static int boxStackHeight(List<Box> stack) {
        int height = 0;
        if (stack == null || stack.size() == 0) {
            return height;
        }

        for (Box b : stack) {
            height += b.h;
        }

        return height;
    }

    public static List<Box> highestBoxStack2(Box[] boxes) {
        Set<Box> bottomSet = new HashSet<>();
        for (Box b : boxes) {
            bottomSet.add(b);
        }

        Map<Box, Set<Box>> graph = new HashMap<>();
        for (int i = 0; i < boxes.length; i++) {
            Set<Box> tempSet = new HashSet<>();
            for (int j = 0; j < boxes.length; j++) {
                if (boxes[j].isAbove(boxes[i])) {
                    tempSet.add(boxes[j]);
                    bottomSet.remove(boxes[j]);
                }
            }
            graph.put(boxes[i], tempSet);
        }

        // IMPORTANT
        graph.put(null, bottomSet);

        return highestBoxStack2(graph, null, new HashMap<Box, List<Box>>());
    }

    public static List<Box> highestBoxStack2(Map<Box, Set<Box>> graph, Box bottom, Map<Box, List<Box>> cache) {
        if (bottom != null && cache.containsKey(bottom)) {
            return cache.get(bottom);
        }

        List<Box> maxStack = null;
        int maxHeight = 0;

        for (Box b : graph.get(bottom)) {
            List<Box> newMaxStack = new ArrayList<>(highestBoxStack2(graph, b, cache));
            int newMaxHeight = boxStackHeight(newMaxStack);
            if (newMaxHeight > maxHeight) {
                maxHeight = newMaxHeight;
                maxStack = newMaxStack;
            }
        }

        if (maxStack == null) {
            maxStack = new ArrayList<>();
        }

        if (bottom != null) {
            maxStack.add(bottom);
            cache.put(bottom, maxStack);
        }

        return maxStack;
    }

    public static void main(String[] args) {
        Box[] boxes = {new Box(1, 1, 1), new Box(2, 2, 2), new Box(1, 2, 3), new Box(3, 2, 1)};
        List<Box> stack = BoxStack.highestBoxStack(boxes);
        for (Box b : stack) {
            System.out.println(b.w + " " + b.h + " " + b.d);
        }
        System.out.println();

        List<Box> stack2 = BoxStack.highestBoxStack2(boxes);
        for (Box b : stack2) {
            System.out.println(b.w + " " + b.h + " " + b.d);
        }
        System.out.println();
    }
}

class Box {
    int w;
    int h;
    int d;

    public Box(int w, int h, int d) {
        this.w = w;
        this.h = h;
        this.d = d;
    }

    boolean isAbove(Box other) {
        return w < other.w && h < other.h && d < other.d;
    }
}
