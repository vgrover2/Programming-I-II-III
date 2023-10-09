//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Inbox Reader
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

import java.util.Iterator;

/**
 * @author vedantgrover
 * 
 * This class represents the inbox where all received/loaded
 * unread and read messages are stored and managed. 
 *
 */
public class Inbox {
  private MessageStack readMessageBox; // stack which stores read messages
  private MessageStack unreadMessageBox; // stack which stores unread messages
  
  /**
   * This no-argument constructor creates a new empty inbox and initializes its instance fields.
   * Both unreadMessageBox and readMessageBox stacks of this inbox are  initially empty.
   *  
   * 
   */
  public Inbox() {
    this.readMessageBox = new MessageStack(); //New empty message stacks 
    this.unreadMessageBox = new MessageStack();
  }
  
  /**
   * Reads the message at the top of the unreadMessageBox, once read the message is moved from the
   * unreadMessageBox to the readMessageBox.
   * 
   * @return the string representation of the message at the top of the unreadMessageBox,
   * or "Nothing in Unread" if the unreadMessageBox of this inbox is empty 
   *  
   */
  
  public String readMessage() {
  // 
    if(unreadMessageBox.isEmpty()) {
      return "Nothing in Unread";
    }
    else {
      unreadMessageBox.peek();
      readMessageBox.push(unreadMessageBox.pop());//moves top message from unread box to read box
      return readMessageBox.peek().toString(); //reads message after just moved to read box
    }
  }
  
  /**
   * Reads message a top of readMessageBox
   * 
   * @return the string representation of the message at the top of the readMessageBox,
   * or "Nothing in Read" if the readMessageBox of this inbox is empty 
   *  
   */
  public String peekReadMessage() {
    //checks first if there are any messages in read box
    if(readMessageBox.isEmpty()) {
      return "Nothing in Read";
    }
    else {
      return readMessageBox.peek().toString();
    }
  }
  
  /**
   * Marks all messages in the unread message box as read and moves them to the read message box
   * 
   * @return the total number of messages marked as read
   *  
   */
  public int markAllMessagesAsRead() {
  
    int readMessages = unreadMessageBox.size();
    while(!(unreadMessageBox.isEmpty())) { //will keep moving messages from unread to read box till unread is empty  
      readMessageBox.push(unreadMessageBox.pop());
    }
    return readMessages;
  }
  /**
   * Pushes a newMessage into the unread message box
   * 
   * @param newMessage represents a reference to the received message
   *  
   */
  public void receiveMessage(Message newMessage) {
  
    unreadMessageBox.push(newMessage);//adds new message to top of unread message stack
  }
  /**
   * Removes permanently all the messages from the readMessageBox
   * 
   * @return total number of removed messages
   *  
   */
  public int emptyReadMessageBox() {
  
    int removedMessages = readMessageBox.size();
    while(!(readMessageBox.isEmpty())) {
      readMessageBox.pop(); //keeps removing messages from read stack till its empty
    }
    return removedMessages;
  }
  
  /**
   * Gets the statistics of this inbox
   *    
   * @return a string showing number of unread and number of read messages
   *  
   */
  public String getStatistics() {
  
    int size1 = unreadMessageBox.size();
    int size2 = readMessageBox.size(); 
    return "Unread (" + size1 + ")" + "\n" + "Read (" + size2 + ")";
  }
  
  /**
   * Traverses all the unread messages
   *    
   * @return a String representation of the contents of the unread message box
   *  
   */
  public String traverseUnreadMessages() {
    String dataLine = "";
    Iterator<Message> iterator = unreadMessageBox.iterator();
    for(Message m: unreadMessageBox) { //iterates through the unread stack till there are no more elements
      if(iterator.hasNext()) {
        m = iterator.next();
        dataLine += ""+m.getID()+" "+m.getSUBJECT()+"\n";
      }
    }
    return "Unread" + "(" + unreadMessageBox.size() + ")" + "\n" + dataLine;
  }
  /**
   * Traverses all the read messages
   *    
   * @return a String representation of the contents of the read message box
   *  
   */
  public String traverseReadMessages() {
    String dataLine = "";
    Iterator<Message> iterator = readMessageBox.iterator();
    for(Message m: readMessageBox) { //iterates through the read stack till there are no more elements
      if(iterator.hasNext()) {
        m = iterator.next();
        dataLine += ""+m.getID()+" "+m.getSUBJECT()+"\n";
      }
    }
    return "Read" + "(" + readMessageBox.size() + ")" + "\n" + dataLine;
  }
  

}
