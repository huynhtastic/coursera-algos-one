/*package per.algo.wkone

public class Percolation {

  private int[][] grid;

  public Percolation(int n) throws IllegalArgumentException {    
    // create n-by-n grid, with all sites blocked
    if (n > 0) { 
      grid = new int[n][n];
      for (int row=0; row < n; row++) {
        for (int col=0; col < n; col ++) {
          grid[row][col] = null;
        }
      }
    } else {
      throw new IllegalArgumentException("n cannot be less than 1.");
    }
  }

  public void union(int p, int q) {
    int i = root(p);
    int i = root(q);
    if (sz[i] < sz[j])  { id[i] = j; sz[j] += sz[i]; }
    else        { id[j] = i; sz[i] += sz[j]; }
  }

  // open site (row i, column j) if it is not open already
  public void open(int i, int j) {
    if (!isOpen(i, j)) {
      
    }
  }  

  public boolean isOpen(int i, int j) {    // is site (row i, column j) open?
    return grid[i-1][j-1] != null;
  }

  // 
  public boolean isFull(int i, int j) {    // is site (row i, column j) full?
  }
  
  // public boolean percolates()             // does the system percolate?

  public static void main(String[] args) {  // test client (optional)
    Percolation p = new Percolation(0);
    System.out.println(p);
  }

}*/

public class PercolationStats {
    
    public PercolationStats(int n, int trials) {    // perform trials independent experiments on an n-by-n grid
        for (int i = 0; i < n; i++) {
            
        }
    }

    public double mean() {                          // sample mean of percolation threshold
    }

    public double stddev() {                        // sample standard deviation of percolation threshold
    }

    public double confidenceLo() {                  // low  endpoint of 95% confidence interval
    }

    public double confidenceHi() {                  // high endpoint of 95% confidence interval
    }

    public static void main(String[] args) {        // test client (described below)
    }
}