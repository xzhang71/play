package cci;

/**
 * Created by xzhang71 on 7/14/14.
 */
public class ArrayStackFixed {
    private int defaultCapacity;
    private StackMetaData[] stacks;
    private Integer[] stackBuffer;

    public ArrayStackFixed(int defaultCapacity, int numOfStacks) {
        this.defaultCapacity = defaultCapacity;
        this.stackBuffer = new Integer[defaultCapacity * numOfStacks];
        stacks = new StackMetaData[numOfStacks];
        for (int i = 0; i < numOfStacks; i++) {
            stacks[i] = new StackMetaData(i * defaultCapacity, defaultCapacity);
        }
    }

    public boolean push(int stackNum, int value) {
        StackMetaData stack = stacks[stackNum];
        if (stack.size < stack.capacity) {
            stack.pointer++;
            stack.size++;
            stackBuffer[stack.pointer] = value;
            return true;
        } else {
            return false;
        }
    }

    public Integer pop(int stackNum) {
        StackMetaData stack = stacks[stackNum];
        if (stack.size == 0) {
            return null;
        } else {
            int val = stackBuffer[stack.pointer];
            stack.pointer--;
            stack.size--;
            return val;
        }
    }

    public Integer peek(int stackNum) {
        StackMetaData stack = stacks[stackNum];
        if (stack.size == 0) {
            return null;
        } else {
            int val = stackBuffer[stack.pointer];
            return val;
        }
    }

    public boolean isEmtpy(int stackNum) {
        StackMetaData stack = stacks[stackNum];
        return stack.size == 0;
    }

    public static void main(String[] args) {
        int stackSize = 10;
        int numOfStacks = 5;

        ArrayStackFixed arrayStack = new ArrayStackFixed(stackSize, numOfStacks);

        for (int i = 0; i < numOfStacks; i++) {
            for (int j = 0; j < stackSize; j++) {
                System.out.printf("push value %d to stack %d: ", j, i);
                System.out.println(arrayStack.push(i, j));
            }
        }

        for (int i = 0; i < numOfStacks; i++) {
            for (int j = stackSize - 1; j >= 0; j--) {
                System.out.printf("pop %d from stack %d: ", i, j);
                System.out.println(arrayStack.pop(i) == j);
            }
        }
    }

    class StackMetaData {
        int start;
        int size;
        int pointer;
        int capacity;

        StackMetaData(int start, int capacity) {
            this.start = start;
            this.pointer = start - 1;
            this.capacity = capacity;
        }
    }
}


