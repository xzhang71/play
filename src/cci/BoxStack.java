package cci;

import java.util.*;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class BoxStack {

    public static List<Box> tallestBoxStack(Box[] boxes) {
        return tallestBoxStack(boxes, null, new HashMap<Box, List<Box>>());
    }

    private static List<Box> tallestBoxStack(Box[] boxes, Box bottom, Map<Box, List<Box>> cache) {
        if (bottom != null && cache.containsKey(bottom)) {
            return cache.get(bottom);
        }

        List<Box> maxStack = null;
        int maxHeight = 0;

        for (int i = 0; i < boxes.length; i++) {
            if (bottom == null || boxes[i].isAbove(bottom)) {
                List<Box> newStack = tallestBoxStack(boxes, boxes[i], cache);
                int newHeight = stackHeight(newStack);
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

    private static int stackHeight(List<Box> stack) {
        int height = 0;
        if (stack == null || stack.size() == 0) {
            return height;
        }

        for (Box b : stack) {
            height += b.h;
        }

        return height;
    }

    public static void tallestBoxStack2(Box[] boxes) {
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

        // TODO: find the deepest weighted path from boxes from bottom set
    }

    public static void main(String[] args) {
        Box[] boxes = {new Box(1, 1, 1), new Box(2, 2, 2), new Box(1, 2, 3), new Box(3, 2, 1)};
        List<Box> stack = BoxStack.tallestBoxStack(boxes);
        for (Box b : stack) {
            System.out.println(b.w + " " + b.h + " " + b.d);
        }
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
