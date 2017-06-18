// basic QuickUnion

public class QuickUnionUF {
	private int[] id;

	/**
	 * Constructor sets id of each object to itself
	 * indices are components; values are the parents/roots
	 * runtime: O(n)
	 * @param int N: number of elements to initialize
	 */
	public QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	/**
	 * Figure out root of i by accessing parents until the root is reached
	 * runtime: depth of i; O(depth)
	 * @param int i: starting node to find root of
	 * @return the root of node i
	 */
	private int root(int i) {
		while (i != id[i]) i = id[i];
		return i;
	}

	/**
	 * Check if two items are connected by checking their roots
	 * runtime: O(n)
	 * @param int p: first element to check
	 * @param int q: second element to check
	 * @return boolean: result of whether or not two items in the array are
	 *  connected
	 */
	public boolean connected(int p, int q) { return root(p) == root(q); }

	/**
	 * Connect different components, specifically anything with pid to qid
	 * runtime: depth of p to root + depth of q to root; O(2n)
	 * @param int p: the element of a component to change from
	 * @param int q: the element of a component to change to
	 */
	public void union(int p, int q) {
		int i = root(p);
		int i = root(q);
		id[i] = j;
	}
}