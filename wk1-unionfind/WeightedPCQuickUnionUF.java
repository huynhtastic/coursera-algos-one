// weighted quickunion with path compression

public class WeightedPCQuickUnionUF {
	private int[] id;
	private int[] sz;

	/**
	 * Constructor set id of each object to itself and size at each index to 1
	 * indices are components; values are the parents/roots
	 * runtime: O(n)
	 * @param int N: number of elements to initialize
	 */
	public WeightedQuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
			sz[i] = 1;
	}

	/**
	 * Figure out root of i by accessing parents until the root is reached
	 *  while compressing path to half 
	 * runtime: depth of i; O(depth) = O(log(n))
	 * @param int i: starting node to find root of
	 * @return the root of node i
	 */
	private int root_onepc(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]]
			i = id[i];
		}
		return i;
	}

	/**
	 * Check if two items are connected by checking their roots
	 * runtime: O(log(n))
	 * @param int p: first element to check
	 * @param int q: second element to check
	 * @return boolean: result of whether or not two items in the array are
	 *  connected
	 */
	public boolean connected(int p, int q) { return root(p) == root(q); }

	/**
	 * Connect different components, specifically the smaller tree to the
	 *  bigger tree
	 * runtime: O(log(n))
	 * @param int p: the element of a component to change from
	 * @param int q: the element of a component to change to
	 */
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j])	{ id[i] = j; sz[j] += sz[i]; }
		else				{ id[j] = i; sz[i] += sz[j]; }
	}
}