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

import java.util.NoSuchElementException;


/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PokemonTree.
 *
 */

public class PokemonTreeTester {
  
  /**
   * Checks the correctness of the implementation of both addPokemon() and
   * toString() methods implemented in the PokemonTree class. This unit test
   * considers at least the following scenarios. (1) Create a new empty
   * PokemonTree, and check that its size is 0, it is empty, and that its string
   * representation is an empty string "". (2) try adding one Pokemon and then
   * check that the addPokemon() method call returns true, the tree is not empty,
   * its size is 1, and the .toString() called on the tree returns the expected
   * output. (3) Try adding another Pokemon which is more powerful than the one at
   * the root, (4) Try adding a third Pokemon which is less powerful than the one
   * at the root, (5) Try adding at least two further Pokemons such that one must
   * be added at the left subtree, and the other at the right subtree. For all the
   * above scenarios, and more, double check each time that size() method returns
   * the expected value, the add method call returns true, and that the
   * .toString() method returns the expected string representation of the contents
   * of the binary search tree in an ascendant order from the most powerful
   * Pokemon to the least powerful one. (6) Try adding a Pokemon whose CP value
   * was used as a key for a Pokemon already stored in the tree. Make sure that
   * the addPokemon() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */

  public static boolean testAddPokemonToStringSize() {

    PokemonTree tree = new PokemonTree();
    // Checking if its empty
    if (!tree.isEmpty()) {
      return false;
    }
    // Empty string case
    if (!tree.toString().equals("")) {
      return false;
    }
    // Adding 1 Pokemon
    Pokemon p1 = new Pokemon("Squirtle", "1,2,3");
    tree.addPokemon(p1);
    if (tree.size() != 1) {
      return false;
    }
    if (!tree.toString().equals("[Squirtle CP:123 (A:1 S:2 D:3)]\n")) { // testing toString method
      return false;
    }
    // Adding 4 more pokemons
    Pokemon p2 = new Pokemon("Snorlax", "2,2,4"); // stronger than root
    Pokemon p3 = new Pokemon("Ditto", "4,4,8"); // stronger than previous
    Pokemon p4 = new Pokemon("Charmander", "3,2,1"); // weaker than previous
    Pokemon p5 = new Pokemon("Lapras", "1,1,1"); // left subtree
    tree.addPokemon(p2);
    tree.addPokemon(p3);
    tree.addPokemon(p4);
    tree.addPokemon(p5);
    if (tree.size() != 5) {
      return false;
    }
    // same key case
    Pokemon p6 = new Pokemon("Eevee", "1,1,1");

    if (tree.addPokemon(p6)) { // false case
      return false;
    }
    if (tree.size() != 5) { // size should be the same
      return false;
    }
    // testing toString method
    if (!tree.toString()
        .equals("[Lapras CP:111 (A:1 S:1 D:1)]\n" + "[Squirtle CP:123 (A:1 S:2 D:3)]\n"
            + "[Snorlax CP:224 (A:2 S:2 D:4)]\n" + "[Charmander CP:321 (A:3 S:2 D:1)]\n"
            + "[Ditto CP:448 (A:4 S:4 D:8)]" + "\n")) {
      return false;
    }
    return true;
  }
  
  /**
   * This method checks mainly for the correctness of the PokemonTree.lookup()
   * method. It must consider at least the following test scenarios. (1) Create a
   * new PokemonTree. Then, check that calling the lookup() method with any valid
   * CP value must throw a NoSuchElementException. (2) Consider a PokemonTree of
   * height 3 which consists of at least 5 PokemonNodes. Then, try to call
   * lookup() method to search for the Pokemon at the root of the tree, then a
   * Pokemon at the right and left subtrees at different levels. Make sure that
   * the lookup() method returns the expected output for every method call. (3)
   * Consider calling .lookup() method on a non-empty PokemonTree with a CP value 
   * not stored in the tree, and ensure that the method call throws a
   * NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */

  public static boolean testAddPokemonAndLookup() {
    PokemonTree tree = new PokemonTree();
    Pokemon p1 = new Pokemon("Pikachu", "2,2,4");

    tree.addPokemon(p1);
    try { // NsEe case
      tree.lookup(345);
    } catch (NoSuchElementException e) {
      System.out.println("No pokemon with this CP");
    }
    // 5 nodes, height = 3
    Pokemon p2 = new Pokemon("Lapras", "4,4,8"); // stronger than previous
    Pokemon p3 = new Pokemon("Snorlax", "1,1,2"); // weaker than previous
    Pokemon p4 = new Pokemon("Charmander", "1,1,1"); // left subtree
    Pokemon p5 = new Pokemon("Ditto", "3,3,5");
    tree.addPokemon(p2); 
    tree.addPokemon(p3);
    tree.addPokemon(p4);
    tree.addPokemon(p5);

    if (tree.lookup(224) != p1) { // looking for root
      return false;
    }
    if (tree.lookup(448) != p2) { // right subtree
      return false;
    }
    if (tree.lookup(112) != p3) { // left subtree
      return false;
    }
    if (tree.lookup(335) != p5) { // subtree of right subtree ( level 3)
      return false;
    }
    if (tree.lookup(111) != p4) { // subtree of left subtree ( level 3)
      return false;
    }
    return true;
  }
  
  /**
   * Checks for the correctness of PokemonTree.height() method. This test must
   * consider several scenarios such as, (1) ensures that the height of an empty
   * Pokemon tree is zero. (2) ensures that the height of a tree which consists of
   * only one node is 1. (3) ensures that the height of a PokemonTree with the
   * following structure for instance, is 4. 
   *      (*) 
   *     /   \ 
   *   (*)   (*) 
   *     \   / \ 
   *    (*)(*) (*) 
   *           /
   *         (*)
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */

  public static boolean testHeight() {

    PokemonTree tree = new PokemonTree();

    if (tree.height() != 0) { // empty tree
      return false;
    }
    Pokemon p1 = new Pokemon("Eevee", "2,2,4");
    tree.addPokemon(p1);

    if (tree.height() != 1) { // tree consists of only 1 node
      return false;
    }

    Pokemon p2 = new Pokemon("Snorlax", "4,4,8");
    Pokemon p3 = new Pokemon("Charmander", "1,1,2"); // weaker than previous
    Pokemon p4 = new Pokemon("Lapras", "1,1,1"); // left subtree
    Pokemon p5 = new Pokemon("Pikachu", "3,3,5"); // right subtree
    tree.addPokemon(p2);
    tree.addPokemon(p3);
    tree.addPokemon(p4);
    tree.addPokemon(p5);

    if (tree.height() != 3) { // height should be 3
      return false;
    }
    return true;
  }
  
  /**
   * Checks for the correctness of PokemonTree.getLeastPowerfulPokemon() method.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */

  public static boolean testGetLeastPowerfulPokemon() {
    PokemonTree tree = new PokemonTree();

    Pokemon p1 = new Pokemon("Eevee", "2,2,4");
    Pokemon p2 = new Pokemon("Snorlax", "4,4,8");
    Pokemon p3 = new Pokemon("Charmander", "1,1,2"); // weaker than previous
    Pokemon p4 = new Pokemon("Lapras", "1,1,1"); // left subtree
    Pokemon p5 = new Pokemon("Pikachu", "3,3,5"); // right subtree
    tree.addPokemon(p1);
    tree.addPokemon(p2);
    tree.addPokemon(p3);
    tree.addPokemon(p4);
    tree.addPokemon(p5);
    if (tree.getLeastPowerfulPokemon() != p4) { // Lapras is least powerful with CP 111
      return false;
    }

    return true;
  }
  
  /**
   * Checks for the correctness of PokemonTree.getMostPowerfulPokemon() method.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */

  public static boolean testGetMostPowerfulPokemon() {

    PokemonTree tree = new PokemonTree();

    Pokemon p1 = new Pokemon("Eevee", "2,2,4");
    Pokemon p2 = new Pokemon("Snorlax", "4,4,8");
    Pokemon p3 = new Pokemon("Charmander", "1,1,2"); // weaker than previous
    Pokemon p4 = new Pokemon("Lapras", "1,1,1"); // left subtree
    Pokemon p5 = new Pokemon("Pikachu", "3,3,5"); // right subtree
    tree.addPokemon(p1);
    tree.addPokemon(p2);
    tree.addPokemon(p3);
    tree.addPokemon(p4);
    tree.addPokemon(p5);
    if (tree.getMostPowerfulPokemon() != p2) { // Snorlax is the most powerful with CP 111
      return false;
    }

    return true;
  }

  /**
   * Calls the test methods
   *
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testAddPokemonToStringSize(): " + testAddPokemonToStringSize());
    System.out.println("testAddPokemonAndLookup(): " + testAddPokemonAndLookup());
    System.out.println("testAddPokemonAndLookup(): " + testHeight());
    System.out.println("testGetLeastPowerfulPokemon(): " + testGetLeastPowerfulPokemon());
    System.out.println("testGetMostPowerfulPokemon(): " + testGetMostPowerfulPokemon());
  }

}