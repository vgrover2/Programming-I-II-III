import java.util.ArrayList;

public class BallotBox {
  private ArrayList<Ballot> ballots;
  
  public BallotBox() {
    ballots = new ArrayList<Ballot>();
  }
  
  public int getNumBallots() {
    return ballots.size() ;
  }
  
  public void submit(Ballot b) {
    if(!ballots.contains(b)) {
      ballots.add(b);
    }
  }
  
  public Candidate getWinner(String office) {
    ArrayList<Candidate> runningCandidates = Ballot.getCandidates(office);
    int[] numVotes = new int[runningCandidates.size()];
    
    if(runningCandidates.size() == 0) {
      return null;
    }
    else {
      for(int i = 0; i < runningCandidates.size(); i++) {
        for(int j = 0; j < ballots.size(); j++) {
          Candidate candidate = ballots.get(j).getVote(office);
          if(candidate.toString().equals(runningCandidates.get(i).toString())) {
            numVotes[i]++;
          }
        }
      }
    }
    int winner = 0;
    for(int k = 0; k < numVotes.length; k++) {
      if(numVotes[k] > numVotes[winner]) {
        winner = k;
      }
    }
    if(numVotes[winner] != 0) {
      return runningCandidates.get(winner);
    }
    else {
      return null;
    }
    
  }

}
