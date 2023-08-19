/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author NITRO 5
 */
public interface StackInterface<T> {
    /**
     * Adds a new entry to the top of the stack.
     *
     * @param newEntry The object to be added as a new entry.
     */
    void push(T newEntry);

    /**
     * Removes and returns the stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    T pop();

    /**
     * Retrieves the stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    T peek();

    /**
     * Detects whether the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Removes all entries from the stack.
     */
    void clear();
}
