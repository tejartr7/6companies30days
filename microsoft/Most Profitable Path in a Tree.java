class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        final int n = amount.length;
		// Build adjacency lists (graph):
        final IntList[] graph = IntList.arrayOfSize(n);
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
		// Find Bob's path to 0 by searching depth-first from 0 to Bob's starting location:
        final Node root = new Node(0);
        final Node bobNode = findBob(root, bob, graph, null);
        final int bobLength = bobNode.length;
		// Resolve Bob's impact on amounts as a result of his path.
        {
            Node node = bobNode;
			// Handle nodes before the halfway point (if any).
            while (node.length > (bobLength >> 1)) {
                amount[node.index] = 0;
                node = node.parent;
            }
			// If there is a halfway point, take or pay half of the amount at that node.
			// Is bobLength (number of steps, not nodes) even?  If so there's a halfway point.
			// And, because of the way we've iterated, if it exists, it is `node`, because we
			// have stopped zeroing out amounts just short of that midway point.
            if ((bobLength & 1) == 0) {
                amount[node.index] /= 2;
            }
        }
		// Now, optimize Alice's path with a depth-first search and return her max income.
        int[] max = new int[] { Integer.MIN_VALUE };
        optimizeAlice(0, -1, graph, amount, amount[0], max);
        return max[0];
    }

    private Node findBob(Node node, int bob, IntList[] graph, Node parent) {
        if (node.index == bob) {
            return node;
        }
        for (int n : graph[node.index]) {
			// Search neighbors except the neighbor we just came from.
            if (parent == null || parent.index != n) {
                final Node bobNode = findBob(new Node(n, node), bob, graph, node);
                if (bobNode != null) {
                    return bobNode;
                }
            }
        }
        return null;
    }

    private void optimizeAlice(int i, int lastI, IntList[] graph, int[] amount, int income, int[] max) {
		// Track number of children (neighbors not equal to lastI) so we know when we are at a leaf.
        int children = 0;
        for (int n : graph[i]) {
			// Search neighbors except the neighbor we just came from.
            if (n != lastI) {
                children++;
                optimizeAlice(n, i, graph, amount, income + amount[n], max);
            }
        }
        if (children == 0) {
            // We are at a leaf - check if income is a new maximum.
            if (income > max[0]) {
                max[0] = income;
            }
        }
    }

    static class IntList extends ArrayList<Integer> {

        static IntList[] arrayOfSize(int n) {
            final IntList[] out = new IntList[n];
            for (int i = 0; i < n; ++i) {
                out[i] = new IntList();
            }
            return out;
        }
    }

    static class Node {
        int length;
        int index;
        Node parent;

        Node(int index) {
            this.index = index;
            this.length = 0;
        }

        Node(int index, Node parent) {
            this(index);
            this.parent = parent;
            this.length = 1 + parent.length;
        }
    }
	
}