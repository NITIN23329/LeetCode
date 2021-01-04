// time O((k+n)logn) ,min heap space O(n)
/*  approach : is same as merging k sorted arrays using min heap
    --> store first element of each row
    --> get the minimum value and add the next element of that particular row to heap
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int i=0;i<matrix.length;i++)pq.add(new int[]{matrix[i][0],i,0});
        while(k-->1){
            int[] x = pq.poll();
            if(x[2]!=matrix.length-1){
                  x[0] = matrix[x[1]][++x[2]];
                  pq.add(x);
            }
        }
        return pq.poll()[0];
    }
}
