// --== CS400 File Header Information ==--
// Name: Vedant Grover
// Email: vgrover2@wisc.edu
// Team: Red Team
// Group: <your groups name: two letters>
// TA: Sid Mohan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;
import java.util.LinkedList;


/**
 * This class implements a hash table using arrays to store key-value pairs. 
 * Key-value pairs are chained using Linked Lists, remove, size, get methods are
 * all included in this class
 * 
 * @author Vedant Grover
 *
 * @param <KeyType>   key
 * @param <ValueType> value
 */


public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  private LinkedList[] hashArray;
  private int size;
  private int capacity;
  
  /**
   * The constructor for the class, it initializes the array to the provided 
   * capacity and assigns the size 
   * 
   * @param capacity length of array which stores key-value pairs
   */
  
  public HashTableMap(int capacity) {
    hashArray = new LinkedList[capacity];
    this.size = 0;
    this.capacity = capacity;
  }
  /**
   * Default constructor, size is assigned and array is initialized to 
   * default capacity of 10  
   */
  
  public HashTableMap() {
    hashArray = new LinkedList[10]; // with default capacity = 10
    this.size = 0;
    this.capacity=10;
  }
  

  @Override
  public boolean put(KeyType key, ValueType value) {

    if (containsKey(key)) { // value is already in the table
      return false;
    }
    int index = Math.abs(key.hashCode()) % capacity;
    if (hashArray[index] == null) {
        hashArray[index] = new LinkedList<ListNode>(); // new linked list created
    }
    
    hashArray[index].add(new ListNode(key, value));
    size++;
    if ((double) size / capacity >= 0.85) { // checking if resizing is required
      rehash();
  }
  return true;
    
  }
  private void rehash() {
    LinkedList[] tempArray = new LinkedList[2 * this.capacity]; // new hash array
    this.capacity = 2 * this.capacity;
    for (int i = 0; i < hashArray.length; i++) { // iterating through old hash array
        if (hashArray[i] != null) {
            LinkedList<ListNode> tempList = hashArray[i];
            // iterating through the linked list, rehashing and inserting each element into
            // new hash array
            for (int j = 0; j < tempList.size(); j++) {
                int newIndex = Math.abs(tempList.get(j).getKey().hashCode()) % capacity;
                if (tempArray[newIndex] == null) {
                    tempArray[newIndex] = new LinkedList<ListNode>();
                    tempArray[newIndex].add(tempList.get(j));
                } else {
                    tempArray[newIndex].add(tempList.get(j));
                }
            }
        }
    }
    // assigning new hash array
    this.hashArray = tempArray;
  }

  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    if (!containsKey(key)) {
      throw new NoSuchElementException();
  }
  // searching for matching key by iterating through the list
  int index = Math.abs(key.hashCode()) % capacity;
  for (int i = 0; i < hashArray[index].size(); i++) {
      if (((ListNode) hashArray[index].get(i)).getKey().equals(key)) {
          return (ValueType) ((ListNode) hashArray[index].get(i)).getValue();
      }
  }
  return null;
  }

  @Override
  public int size() {
    return this.size;

  }

  @Override
  public boolean containsKey(KeyType key) {

    int index = Math.abs(key.hashCode()) % capacity;
    if (hashArray[index] == null) {
        return false;
    }
    // iterating through list to find matching key 
    
    for (int i = 0; i < hashArray[index].size(); i++) {
        if (((ListNode) hashArray[index].get(i)).getKey().equals(key)) {
            return true;
        }
    }
    return false;
  }

  @Override
  public ValueType remove(KeyType key) {
    
    if (!containsKey(key)) {
      return null;
  }
  // searching for matching key by iterating through the list
  int index = Math.abs(key.hashCode()) % capacity;
  for (int i = 0; i < hashArray[index].size(); i++) {
      if (((ListNode) hashArray[index].get(i)).getKey().equals(key)) {
          size--;
          return (ValueType) ((ListNode) hashArray[index].remove(i)).getValue();
      }
  }
  return null;

  }

  @Override
  public void clear() {

    for (int i = 0; i < this.capacity; i++) {
      hashArray[i] = null;
  }
  this.size = 0;
  }
  

}
