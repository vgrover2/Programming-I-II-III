// --== CS400 File Header Information ==--
// Name: Vedant Grover
// Email: vgrover2@wisc.edu
// Team: Red Team
// Group: <your groups name: two letters>
// TA: Sid Mohan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/**
 * New class created to hold key-value pairs that are inserted into the Linked List. 
 * Key and value both kept generic.
 * 
 * @author Vedant Grover 
 *
 * @param <KeyType>   key
 * @param <ValueType> value
 */

public class ListNode<KeyType, ValueType> {
  private KeyType key;
  private ValueType value;
  
  public ListNode(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
}
  public KeyType getKey() {
    return key;
}
  public ValueType getValue() {
    return value;
}


}
