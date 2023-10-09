
public class BallotBoxTester {
  
  public static boolean testCandidate() {
    try {
      
      Candidate c1 = new Candidate("Neil", Candidate.OFFICE[0]);
      Candidate c2 = new Candidate("Mike", Candidate.OFFICE[1]);
      
      if(!c1.getName().equals("Neil")) {
        return false;
      }
      
      if(!c2.getName().equals("Mike")) {
        return false;
      }
      
      if(!c1.getOffice().equals(Candidate.OFFICE[0])) {
        return false;
      }
      
      if(!c2.getOffice().equals(Candidate.OFFICE[1])) {
        return false;
      }
      
      String expectedOutput = "Neil (" + Candidate.OFFICE[0] + ")";
      if(!c1.toString().equals(expectedOutput)) {
        return false;
      }
      String expectedOutput2 = "Mike (" + Candidate.OFFICE[1] + ")";
      if(!c1.toString().equals(expectedOutput2)) {
        return false;
      }
    }
    catch(Exception e) {
      return false; //No exception is expected to be thrown
    }
    
    return true; // this statement was added to make the code compile without errors
    
  }
  
  public static boolean testPartyGetName() {
    try {
      Party party = new Party("Republican");
      Party party2 = new Party("Democrat");
      
      String expectedOutput = "Republican";
      String expectedOutput2 = "Democrat";
      
      if(!party.getName().equals(expectedOutput)) {
        return false;
      }
      if(!party2.getName().equals(expectedOutput2)) {
        return false;
      }
      
    }
    catch(Exception e) {
      return false; //No exception is expected to be thrown
    }
    
    return true; // this statement was added to make the code compile without errors
  }
  
  public static boolean testBallotGetVote() {
    try {
      Ballot ballot = new Ballot();
      
      //passing an incorrect String for office
      if(ballot.getVote("brhfrj") != null) {
        return false;
      }
      
    }
    catch(Exception e) {
      return false; //No exception is expected to be thrown
    }
    return true; // this statement was added to make the code compile without errors

  }
  
  
  public static boolean testBallotBoxConstructor() {
    try {
      BallotBox ballotbox = new BallotBox();
      //testing if constructor has worked to create an object

      if(ballotbox == null) {
        return false;
      }
      
    }
    catch(Exception e) {
      return false;
    }
    
    return true;
  }
  
  
  

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("testCandidate: " + testCandidate());
    System.out.println("testPartyGetName: " + testPartyGetName());
    System.out.println("testBallotGetVote: " + testBallotGetVote());
    System.out.println("testBallotBoxConstructor: " + testBallotBoxConstructor());
    
  }

}
