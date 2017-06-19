import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

    private double trialResults[];

    public PercolationStats(int n, int trials)
    {
        if (n <= 0 || trials <= 0) 
            throw new IllegalArgumentException("n and trials cannot be less than 1.");

        trialResults = new double[trials];

        for (int trial = 0; trial < trials; trial++) {
            Percolation pc = new Percolation(n);

            while (!pc.percolates()) {
                int row = StdRandom.uniform(n);
                int col = StdRandom.uniform(n);
                pc.open(row, col);
            }

            trialResults[trial] = (double) pc.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() { return StdStats.mean(trialResults); }

    public double stddev() { return StdStats.stddev(trialResults);    }

    public double confidenceLo() { return mean() - (1.96 * stddev() / Math.sqrt(trialResults.length)); }

    public double confidenceHi() { return mean() + (1.96 * stddev() / Math.sqrt(trialResults.length)); }

    public static void main(String[] args)
    {
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println(String.format("95%% confidence interval = [%f, %f]", ps.confidenceLo(), ps.confidenceHi()));
    }
}