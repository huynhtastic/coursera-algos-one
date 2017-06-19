import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {

    private boolean sitesGrid[][];
    private WeightedQuickUnionUF connectedGrid;
    private int gridLength;
    private int virtualTop;
    private int virtualBottom;

    public Percolation(int n) throws IllegalArgumentException
    {
        if (n > 0) {
            gridLength = n;
            sitesGrid = new boolean[n][n]; // initialize closed sites
            // create WQunionfind object to track connected status and virtual top+bottom sites
            connectedGrid = new WeightedQuickUnionUF(n*n + 2);
            virtualTop = gridLength * gridLength;
            virtualBottom = virtualTop + 1;
            // connect top row to virtual top and bottom row to virtual bottom
            for (int i = 0; i < gridLength; i++) {
                connectedGrid.union(virtualTop, i);
                connectedGrid.union(virtualBottom, virtualTop - i - 1);
            }
        } else {
            throw new IllegalArgumentException("N cannot be less than 1.");
        }
    }

    private void checkCoords(int row, int col)
    {
        if (row < 0 || col < 0 || row > gridLength - 1 || col >  gridLength - 1) 
            throw new IndexOutOfBoundsException("Row and Col cannot be less than 0 or more than N.");
    }

    public void open(int row, int col)
    {
        if (!isOpen(row, col)) {
            sitesGrid[row][col] = true; // open the site
            int openedSite = gridLength * row + col;
            // connect with other sites
            if (row - 1 >= 0) { // check for above site
                int adjSite = gridLength * (row - 1) + col;
                if (isOpen(row - 1, col) && !connectedGrid.connected(openedSite, adjSite)) 
                    connectedGrid.union(openedSite, adjSite);
            }
            if (col + 1 < gridLength) { // check for right site
                int adjSite = gridLength * row + (col + 1);
                if (isOpen(row, col + 1) && !connectedGrid.connected(openedSite, adjSite))
                    connectedGrid.union(openedSite,adjSite);
            }
            if (row + 1 < gridLength) { // check for below site
                int adjSite = gridLength * (row + 1) + col;
                if (isOpen(row + 1, col) && !connectedGrid.connected(openedSite, adjSite)) 
                    connectedGrid.union(openedSite, adjSite);
            }
            if (col - 1 > 0) { // check for left site
                int adjSite = gridLength * row + (col - 1);
                if (isOpen(row, col - 1) && !connectedGrid.connected(openedSite, adjSite))
                    connectedGrid.union(openedSite,adjSite);
            }
        }
    }

    public boolean isOpen(int row, int col) 
    {
        checkCoords(row, col);
        return sitesGrid[row][col];
    }
    
    public boolean isFull(int row, int col)
    {
        checkCoords(row, col);
        int queriedSite = gridLength * row + col;
        return (isOpen(row, col) && connectedGrid.connected(virtualTop, queriedSite));
    }

    public int numberOfOpenSites()
    {
        int sum = 0;
        for (int row = 0; row < gridLength; row++) {
            for (int col = 0; col < gridLength; col++) {
                if (sitesGrid[row][col]) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public boolean percolates()
    {
        return connectedGrid.connected(virtualTop, virtualBottom);
    }

    public static void main(String[] args) {   // test client (optional)
    }
}