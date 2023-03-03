class Solution {
	public boolean canFinish(int n, int[][] p) {
		ArrayList<List<Integer>> list = new ArrayList<>();

		for(int i=0;i<n;i++)list.add(new ArrayList<>());
		for(int i=0;i<p.length;i++)list.get(p[i][0]).add(p[i][1]);

		int[] degree = new int[n];
		for(int i=0;i<n;i++){
			for(int j:list.get(i)){
				degree[j]++;
			}
		}

		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0;i<n;i++){
			if(degree[i]==0)q.offer(i);
		}

		int count=0;
		while(!q.isEmpty()){
			int node = q.poll();
			count++;
			for(int i:list.get(node)){
				degree[i]--;
				if(degree[i]==0){
					q.offer(i);
				}
			}
		}

		return count==n?true:false;

	}
}