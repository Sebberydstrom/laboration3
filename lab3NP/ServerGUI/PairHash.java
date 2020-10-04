package lab3NP.ServerGUI;

public class PairHash {

	
// PAIR_LIMIT is 23170
// Keeping the inputs below this level prevents overflow, and guarantees
// the hash will be unique for each pair of positive integers. This
// lets you use the hashCode in the equals method.
	public static final int PAIR_LIMIT = (int) (Math.sqrt(Integer.MAX_VALUE))/2;
	private final int hash;

	public PairHash(int a, int b) {
		
		  assert a >= 0;
		  assert b >= 0;
		  assert a < PAIR_LIMIT;
		  assert b < PAIR_LIMIT;
		  int sum = a + b;
		  hash = sum * (sum + 1) / 2 + a;
		 
	}

		  public int hashCode() { return hash; }

		  public boolean equals(Object other) {
		    if (other instanceof PairHash){
		      return hash == ((PairHash) other).hash;
		    }
		    return false;
		  }
}

