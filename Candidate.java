
public class Candidate {
  
  protected static final String[] OFFICE = new String[]{"President", "Vice President", "Secretary"};
  
  private String name;
  private String office;
  
  public Candidate(String name, String office) {
    
    boolean isValid = false;
    
      for(int i = 0; i < OFFICE.length; i++) {
        if(OFFICE[i].equals(office)) {
          this.name = name;
          this.office = office;
          isValid = true;
        }
      }
      
      if(isValid == false) {
        throw new IllegalArgumentException("Office value passed is not included in the list.");
      }
    
  }
  
  public String getName() {
    return name;
  }
  
  public String getOffice() {
    return office;
  }
  
  public String toString() {
    return name + " (" + office + ")";
  }
}
