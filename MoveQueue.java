//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Battle System
// Course: CS 300 Fall 2020
//
// Author: Vedant Grover
// Email: vgrover2@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * @author vedantgrover
 * 
 * This class will be a priority queue of battle character objects, implementing the 
 * PriorityQueueADT interface using an array max heap
 * 
 *
 */

public class MoveQueue implements PriorityQueueADT<BattleCharacter>{
  private int size; // an int which keeps tack of the number of BattleCharacters stores in this MoveQueue
  private BattleCharacter[] data; //a max-heap array of BattleCharacters. The root (greatest battle character) is at
  //index 0 of this array.
  /**
   * 
   * Constructor that builds an empty priority queue with the given capacity
   * 
   * @param capacity of the queue
   * @throws IllegalArgumentException if capacity is zero or negative
   *
   */
  public MoveQueue(int capacity) {
    if(capacity < 1) {
      throw new IllegalArgumentException("Capacity is either zero or negative");
    }
    data = new BattleCharacter[capacity];
    
  }
  /**
   * 
   * Constructor that builds an empty priority queue with array size 10
   *
   */
  public MoveQueue() {
    data = new BattleCharacter[10];
    
  }
  
  /**
  * Returns a String representation of the current contents of the MoveQueue
  * in order from first to last.
  * @author Michelle
  */
  
  @Override
  public String toString(){  
    String s = ("[ ");
    for (int i =0; i< size; i++){
    s += (data[i].toString() + " | ");
    }
    s += ("]");
    return s;
  }
  
  /**
   * Returns the current size of this priority queue.
   * 
   * @return the size of this priority queue
   */
  @Override
  public int size() {
    return size;
  }
  
  /**
   * Checks if this priority queue is empty. Returns true if it is empty and false otherwise.
   */
  @Override
  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Removes all the elements from this priority queue. The queue must be empty after this method
   * returns.
   */
  @Override
  public void clear() {
    for(int i = 0; i < size; i++) {
      data[i] = null;
    }
    size = 0;
  }

  /**
   * Adds the given element to the priority queue in the correct position based on the natural
   * ordering of the elements.
   * 
   * @param element to be added to this queue
   * @throws IllegalArgumentException if element is null
   * @throws IllegalStateException of this priority queue is full
   */
  @Override
  public void enqueue(BattleCharacter element) {
    if(element == null) {
      throw new IllegalArgumentException("Element is null");
    }
    else if(size >= data.length) {
      throw new IllegalStateException("Queue is full");
    }
    data[size] = element;
    size++;     //incrementing size
    for(int i = 0; i < size; i++) {
      percolateUp(i);
    }
  }
  
  /**
  * Recursively propagates max-heap order violations up.
  * Checks to see if the current node i violates the max-heap order property by checking its
  * parent. If it does, swap them and continue to ensure the heap condition is satisfied.
  * @param i index of the current node in this heap
  */
  protected void percolateUp(int i) { 
    if(this.data[i].compareTo(this.data[(i-1)/2]) == -1 || i == 0) {
      return;
    }
    else {
      BattleCharacter temp;
      temp = this.data[i];
      this.data[i] = this.data[(i-1)/2];
      this.data[(i-1)/2] = temp;
      percolateUp((i-1)/2); //recursive call
      return;
    }
  }
  
  /**
   * Returns and removes the element at the front (aka root position) of this queue (the element
   * having the highest priority).
   * 
   * @return the removed element
   * @throws NoSuchElementException if this queue is empty
   */
  
  @Override
  public BattleCharacter dequeue() {
    if(isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    else {
      BattleCharacter temp = data[0];
      data[0] = data[size-1];
      data[size-1] = null;
      size--;
      percolateDown(0);
      return temp;
    }
    
  }
  
  /**
   * 
  * Recursively propagates max-heap order violations down.
  * Checks to see if the current node i violates the max-heap order
  * property by checking its children. If it does, swap it with the optimal
  * child and continue to ensure the heap condition is met.
  * Uses three helper methods, left, right, swap
  * 
  * @param i index of the current node in this heap
  */
  protected void percolateDown(int i) { 
    int index = i;
    if (index >= size) {
      return;
    }
    int left = left(index);
    int right = right(index);
    if (right < size && data[right].compareTo(data[left]) > 0
        && data[right].compareTo(data[index]) > 0) { // swap right
      swap(index, right);
      percolateDown(right); //recursive call
    } 
    else if (left < size && data[left].compareTo(data[index]) > 0) { // swap left
      swap(index, left);
      percolateDown(left); //recursive call
    }
    
  }
  
  private int left(int index) {
    return index * 2 + 1; //helper method
  }

  private int right(int index) {
    return index * 2 + 2; //helper method
  }

  private void swap(int a, int b) {
    BattleCharacter tmp = data[a];
    data[a] = data[b]; //helper method
    data[b] = tmp;
  }
  
  
  /**
  * Eliminates all heap order violations from the heap data array
  */
  protected void heapify() { 
    for(int i =(size/2) -1; i>= 0; i--) {
      percolateDown(i);
    }
  }
  
  
  /**
   * Returns without removing the element at the front (aka root position) of this queue (the element
   * having the highest priority).
   * 
   * @return the element with the highest priority in this queue
   * @throws NoSuchElementException if this queue is empty
   */
  @Override
  public BattleCharacter peekBest() {
    if(isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    BattleCharacter temp = this.data[0];
    return temp;
  }
  
  /**
   * Finds matching character in the MoveQueue, replaces it with the updated version of 
   * the character. If the character is dead, it's removed entirely
   * 
   * @param updateChara updated version of the character
   */
  
  public void updateCharacter(BattleCharacter updateChara){
    int index = 0;
    for(int i = 0; i < size; i++) {
      if(updateChara.equals(data[i])) {
        index = i; //finding matching character
        
      }
    }
    if(data[index] == null) {
      int gapIndex = index; //eliminating null references
      for (int i = gapIndex; i < size; i++) {
        if (i == data.length - 1)
        data[i] = null;
        data[i] = data[i + 1];
      }
      
    }
    else if(data[index].isAlive()){
      data[index] = updateChara; //replacing with updated version of character
    }
  }
}
