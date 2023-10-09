//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Pokemon Catalog
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

public class PokemonNode {
  
  private Pokemon data; // data field of this PokemonNode
  private PokemonNode leftChild; // reference to the left child
  private PokemonNode rightChild; // reference to the right child
  
  public PokemonNode (Pokemon data) {
    //Pokemon temp = new Pokemon()
    if(data == null) {
      throw new IllegalArgumentException("Data is null");
    }
    else {
      this.data = data;
      this.leftChild = null;
      this.rightChild = null;
    }
  }
  // A one-argument constructor which sets leftChild and rightChild to null and initializes the
  //data field.
  // Throws an IllegalArgumentException if data is null
  public PokemonNode getLeftChild() {
    return leftChild;
    
  }
  //○ Returns a reference to the left child of this PokemonNode
  public PokemonNode getRightChild() {
    return rightChild;
    
  }
  //○ Returns a reference to the right child of this PokemonNode
  public Pokemon getPokemon() {
    return data;
    
  }
  //○ Returns a reference to the Pokemon contained in this PokemonNode
  public void setLeftChild(PokemonNode left) {
    this.leftChild = left;
  }
  //○ Sets the left child of this PokemonNode (null values allowed)
  public void setRightChild(PokemonNode right) {
    this.rightChild = right;
  }
  //○ Sets the right child of this PokemonNode (null values allowed)
  

}
