/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {
    private T[] stackArray;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[initialCapacity];
        stackArray = tempArray;
        topIndex = -1;
    }

    @Override
    public void push(T newEntry) {
        ensureCapacity();
        topIndex++;
        stackArray[topIndex] = newEntry;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T top = stackArray[topIndex];
        stackArray[topIndex] = null;
        topIndex--;
        return top;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    private void ensureCapacity() {
        if (topIndex == stackArray.length - 1) {
            int newCapacity = stackArray.length * 2;
            T[] newStackArray = (T[]) new Object[newCapacity];

            for (int i = 0; i <= topIndex; i++) {
                newStackArray[i] = stackArray[i];
            }

            stackArray = newStackArray;
        }
    }
}
