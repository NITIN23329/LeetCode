// time complexity : O(nlogn), space compleity : O(N)
/*
--> The approach is to use biggest element in A for biggest element in B.
--> If no bigger element is there in A that can satisy B, we will use smallest possible element in A.
--> Why smallest? because if we use a relatively bigger element, then it make leave any B value unsatisfied which may be satisfied by our bigger element.
*/
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n = A.length;
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->(b[0]-a[0]));
        for(var i =0;i<n;i++)pq.add(new int[]{B[i],i});
        int[] ans = new int[n];
        int r = n-1;
        int l = 0;
        while(!pq.isEmpty()){
            int[] x = pq.poll();
            if(x[0]<A[r])ans[x[1]] = A[r--];
            else ans[x[1]] = A[l++];
        }
        return ans;
    }
}
