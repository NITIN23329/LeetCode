// time complexity : O(nlogn) and space complexity O(n)
/*
  --> Consider 1 pair as (value,label)
  --> Sort all pairs in decreasing order of their value.
  --> Then start taking sum of values until num_wanted>0 and we have pair left.
  --> One thing to note is we can take only use_limit # of same labels pair otherwise ignore current pair and contiue doing above step.
*/
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        int n = values.length;
        for(int i=0;i<n;i++)
            pq.add(new int[]{values[i],labels[i]});
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        while(!pq.isEmpty() && num_wanted>0){
            int[] x = pq.poll();
            int label = x[1];
            int value = x[0];
            if(!map.containsKey(label) || map.get(label)<use_limit){
                map.put(label,map.getOrDefault(label,0)+1);
                num_wanted--;
                sum+=value;
            }
        }
        return sum;
    }
}
