package cci;

/**
 * Created by xzhang71 on 7/14/14.
 */
public class ArrayStackDynamic {

    private int defaultCapacity;
    private int numOfStacks;
    private int totalCapacity;

    private StackMetaData[] stacks;
    private Integer[] stackBuffer;

    public ArrayStackDynamic(int defaultCapacity, int numOfStacks) {
        this.defaultCapacity = defaultCapacity;
        this.numOfStacks = numOfStacks;
        totalCapacity = defaultCapacity * numOfStacks;
        stacks = new StackMetaData[numOfStacks];
        for (int i = 0; i < numOfStacks; i++) {
            stacks[i] = new StackMetaData(i * defaultCapacity, defaultCapacity);
        }
        stackBuffer = new Integer[totalCapacity];
    }

    public Integer push(int stackNum, int item) {
        StackMetaData stack = stacks[stackNum];
        if (stack.size >= stack.capacity) {
            if (totalSize() >= totalCapacity) {
                return null;
            } else {
                expand(stackNum);
            }
        }

        stack.pointer = nextIndex(stack.pointer);
        stackBuffer[stack.pointer] = item;
        stack.size++;
        return item;
    }

    public Integer pop(int stackNum) {
        StackMetaData stack = stacks[stackNum];
        if (stack.size == 0) {
            return null;
        } else {
            Integer val = stackBuffer[stack.pointer];
            stackBuffer[stack.pointer] = 0;
            stack.pointer = previousIndex(stack.pointer);
            stack.size--;
            return val;
        }
    }

    public Integer peek(int stackNum) {
        StackMetaData stack = stacks[stackNum];
        if (stack.size == 0) {
            return null;
        } else {
            return stackBuffer[stack.pointer];
        }
    }

    public boolean isEmpty(int stackNum) {
        StackMetaData stack = stacks[stackNum];
        return stack.size == 0;
    }

    private int nextIndex(int index) {
        if (index == totalCapacity - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    private int previousIndex(int index) {
        if (index == 0) {
            return totalCapacity - 1;
        } else {
            return index - 1;
        }
    }

    private int totalSize() {
        int totalSize = 0;
        for (StackMetaData stack : stacks) {
            totalSize += stack.size;
        }
        return totalSize;
    }

    private void shift(int stackNum) {
        StackMetaData stack = stacks[stackNum];
        if (stack.size >= stack.capacity) {
            int nextStackNum = (stackNum + 1) % numOfStacks;
            shift(nextStackNum);
        }

        for (int i = (stack.start + stack.capacity - 1) % totalCapacity; stack.isWithinStack(i, totalCapacity) && i != stack.start; i = previousIndex(i)) {
            stackBuffer[i] = stackBuffer[previousIndex(i)];
        }

        stackBuffer[stack.start] = 0;
        stack.start = nextIndex(stack.start);
        stack.pointer = nextIndex(stack.pointer);
        stack.capacity--;
    }

    private void expand(int stackNum) {
        shift((stackNum + 1) % numOfStacks);
        stacks[stackNum].capacity++;
    }

    public static void main(String[] args) {
        int defaultSize = 2;
        int numOfStacks = 2;
        ArrayStackDynamic arrayStackDynamic = new ArrayStackDynamic(defaultSize, numOfStacks);

        for (int stackNum = 0; stackNum < 2; stackNum++) {
            for (int i = 0; i < defaultSize * numOfStacks; i++) {
                System.out.printf("push %d to stack %d returns %d: ", i, stackNum, i);
                System.out.println(arrayStackDynamic.push(stackNum, i) == i);
            }

            for (int i = 0; i < defaultSize; i++) {
                System.out.printf("push %d to stack %d returns null: ", i, stackNum);
                System.out.println(arrayStackDynamic.push(stackNum, i) == null);
            }

            System.out.printf("total size = %d\n\n", arrayStackDynamic.totalSize());

            for (int i = defaultSize * numOfStacks - 1; i >= 0; i--) {
                System.out.printf("pop %d from stack %d returns %d: ", i, stackNum, i);
                System.out.println(arrayStackDynamic.pop(stackNum) == i);
            }

            for (int i = defaultSize - 1; i >= 0; i--) {
                System.out.printf("pop %d from stack %d return null: ", i, stackNum);
                System.out.println(arrayStackDynamic.pop(stackNum) == null);
            }

            System.out.printf("total size = %d\n\n", arrayStackDynamic.totalSize());
        }
    }

    class StackMetaData {
        int start;
        int pointer;
        int size;
        int capacity;

        StackMetaData(int start, int capacity) {
            this.start = start;
            this.pointer = start - 1;
            this.size = 0;
            this.capacity = capacity;
        }

        boolean isWithinStack(int index, int totalCapacity) {
            if (start <= index && index < start + capacity) {
                return true;
            } else if (start + capacity > totalCapacity && index < (start + capacity) % totalCapacity) {
                return true;
            }
            return false;
        }
    }
}