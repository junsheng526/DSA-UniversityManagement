/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.EmptyStackException;

public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queueArray;
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[initialCapacity];
        queueArray = tempArray;
        frontIndex = 0;
        backIndex = -1;
    }

    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % queueArray.length;
        queueArray[backIndex] = newEntry;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T front = queueArray[frontIndex];
        queueArray[frontIndex] = null;
        frontIndex = (frontIndex + 1) % queueArray.length;
        return front;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queueArray[frontIndex];
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == (backIndex + 1) % queueArray.length;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            int currentIndex = frontIndex;
            do {
                queueArray[currentIndex] = null;
                currentIndex = (currentIndex + 1) % queueArray.length;
            } while (currentIndex != (backIndex + 1) % queueArray.length);
        }
        frontIndex = 0;
        backIndex = -1;
    }

    private void ensureCapacity() {
        if (frontIndex == (backIndex + 2) % queueArray.length) {
            int oldCapacity = queueArray.length;
            int newCapacity = oldCapacity * 2;
            @SuppressWarnings("unchecked")
            T[] newQueueArray = (T[]) new Object[newCapacity];
            
            int currentIndex = frontIndex;
            int newIndex = 0;
            do {
                newQueueArray[newIndex] = queueArray[currentIndex];
                currentIndex = (currentIndex + 1) % oldCapacity;
                newIndex = (newIndex + 1) % newCapacity;
            } while (currentIndex != (backIndex + 1) % oldCapacity);

            queueArray = newQueueArray;
            frontIndex = 0;
            backIndex = newIndex - 1;
        }
    }
}
