// time complexity : O(nlogn)
/*
  approach :
    --> Suppose we have much fuel to reach upto 3 next gas stations but not enough to goto target, So we need some extra fuel.
    --> Now on which gas station do we need to stop at? The one having maximum fuel , this station's fuel will help us to goto maximum possible distance.
    --> This gives rise to some kind of greedy thinking.
    --> The approach is consider all stations reachable with our current fuel. If we need some extra fuel we will use the station having maximum fuel
    --> We add that station's fuel to our current fuel and we again reach some next stations. Again we are out of fuel, we can use that stations having maximum fuel uptil now which is not previously used.
    --> We do this until we reach our target. If somewhere in between we dont have any gas stations to fill, we return -1.
*/
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int fuel = startFuel;
        int i = 0;
        int count = 0;
        int n = stations.length;
        while(fuel<target){
            while(i<n && fuel>=stations[i][0]){
                pq.add(stations[i++][1]);
            }
            if(pq.isEmpty())return -1;
            fuel+=pq.poll();
            count++;
        }
        return count;
    }
}
