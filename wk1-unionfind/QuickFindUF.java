// basic QuickFind

public class QuickFindUF {
	private int id[];

	/**
	 * Constructor set id of each object to itself
	 * runtime: O(n)
	 * @param int N: number of elements to initialize
	 */
	public QuickFindUF(int N) {
		id = new Int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	/**
	 * Check if two items are connected in the array
	 * runtime: O(1)
	 * @param int p: first element to check
	 * @param int q: second element to check
	 * @return boolean: result of whether or not two items in the array are
	 *  connected
	 */
	public boolean connected(int p, int q) { return id[p] == id[q]; }

	/**
	 * Connect different components, specifically anything with pid to qid
	 * runtime: 2N + 2 = O(n)
	 * 	2 from accessing the ids; why 2N?
	 * @param int p: the element of a component to change from
	 * @param int q: the element of a component to change to
	 */
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		// loop through and change anything that contains pid to qid
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid) id[i] = qid;
	}
}