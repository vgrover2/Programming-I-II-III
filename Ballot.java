import java.util.ArrayList;
import java.util.NoSuchElementException;


public class Ballot {
  private static ArrayList<Party> parties = new ArrayList<>();
  private static int counter;
  
  private Candidate[] votes; 
  private final int ID;
  
  private static void addParty(Party p) {
    boolean contains = false;
    
    for(int i = 0; i < parties.size(); i++) {
      if(parties.get(i).getName().equals(p.getName())) {
        contains = true;
      }
    }
    
    if(contains == false) {
      parties.add(p);
    }
    
  }
  
  public static ArrayList<Candidate> getCandidates(String office){
    ArrayList<Candidate> candidateList = new ArrayList<>();
    
    for(int i = 0; i < parties.size(); i++) {
      try {
        candidateList.add(parties.get(i).getCandidate(office));

      }
      catch(NoSuchElementException e) {
        
      }
    }
    
    return candidateList;

      
  }
      
  public Ballot() {
    this.ID = Ballot.counter;
    this.votes = new Candidate[Candidate.OFFICE.length];
    Ballot.counter++;
    
  }
  
  public Candidate getVote(String office) {
    boolean isVote = false;
    int candidateElement = 0; 
    
    for(int i = 0; i < votes.length; i++) {
      if(votes[i] != null && votes[i].getOffice().equals(office)) {
        isVote = true;
        candidateElement = i;
      }
    }
    if(isVote == true) {
      return votes[candidateElement];
    }
    else {
      return null;
    }
  }
  
  public boolean equals(Object o) {
    if(o == this) {
      return true;
    }
    if(!(o instanceof Ballot)) {
      return false;
    }
    
    Ballot b = (Ballot) o;
    
    return Integer.compare(ID, b.ID) == 0;
  }
  
  public void vote(Candidate c) {
    String office = c.getOffice();
    
    for(int i = 0; i < Candidate.OFFICE.length; i++) {
      if(Candidate.OFFICE[i].equals(office)) {
        votes[i] = c;
      }
    }
    
  }
      

}
