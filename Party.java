import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Party {
  private String name;
  private ArrayList<Candidate> candidates = new ArrayList<>();
  
  public Party(String name) {
    this.name=name;
  }
  
  public String getName() {
    return name;
  }
  
  public int getSize() {
    return this.candidates.size();
  }
  
  public Candidate getCandidate(String office) {
    boolean isFound = false;
    Candidate candidate = null;
    
    for(int i = 0; i < candidates.size(); i++) {
      if(candidates.get(i).getOffice().equals(office)) {
        isFound = true;
        candidate = candidates.get(i);
      }
    }
    if(isFound == false) {
      throw new NoSuchElementException("The candidate was not found");
    }
    
    return candidate;
    
  }
  
  public void addCandidate(Candidate c) {
    boolean isSame = false;
    
    for(int i = 0; i < candidates.size(); i++) {
      if(candidates.get(i).getOffice().equals(c.getOffice())) {
        isSame = true;
        throw new IllegalArgumentException("Another member of the party is running for the same office");
        
      }
    }
    if(isSame == false) {
      candidates.add(c);
    }
  }
  

}
