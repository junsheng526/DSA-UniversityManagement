/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

public interface QueueInterface<T> {
    /**
     * Adds a new entry to the back of this queue.
     *
     * @param newEntry An object to be added.
     */
    void enqueue(T newEntry);

    /**
     * Removes and returns the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyStackException if the queue is empty before the operation.
     */
    T dequeue();

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyStackException if the queue is empty.
     */
    T getFront();

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Removes all entries from this queue.
     */
    void clear();
}
