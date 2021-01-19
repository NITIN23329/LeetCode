// time O(n)
/* approach :
    --> do a bfs
    --> at a point , we can either reach from a point on left to it by adding a or from a point right to it by subtracting b
    --> both case is considered as different, so instead of maring points as visited, we marks how we reach points either from backward or forward.
    --> Some solution has furthermost points = max(forbidden)+a+b , but i used 1e4, a loose bound.
*/
class Solution {
	public int minimumJumps(int[] forbidden, int a, int b, int x) {
		Queue<int[]> q = new LinkedList<>();
		Set<Integer> cannotgo = new HashSet<>();
		for(int ele : forbidden)cannotgo.add(ele);
		Set<String> visited = new HashSet<>();
		q.add(new int[]{0,0,1});
		while(!q.isEmpty()){
			int[] z = q.poll();
			if(z[0]==x)return z[1];
			if(z[0]>10000)continue;
			String forward = (z[0]+a)+","+0;
			String backward = (z[0]-b)+","+1;
			if(!cannotgo.contains(z[0]+a) && !visited.contains(forward)){
				q.add(new int[]{z[0]+a,z[1]+1,0});
				visited.add(forward);
			}
			if(z[2]==0 && z[0]-b>0 && !cannotgo.contains(z[0]-b) && !visited.contains(backward)){
				q.add(new int[]{z[0]-b,z[1]+1,1});
				visited.add(backward);
			}
		}
		return -1;
	}
}
