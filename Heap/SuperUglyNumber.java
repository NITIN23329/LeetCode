//time : O(nklog(nk)) 
/*  approach :
    -->get the min super ugly number using min heap
    --> find all next super ugly numbers by multiply it with primes , do this for n-1 times
    --> do care of duplicates
*/
cclass Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        while(n-->1){
            long x = pq.peek();
            while(!pq.isEmpty() && x==pq.peek())pq.poll();
            for(int ele : primes)pq.add(x*ele);
        }
        return (int)(long)pq.poll();
    }
}
// time complexity : O(nlogk) , space complexity O(k+n) , k = size of priority queue
/*  approach :  solution link : https://www.youtube.com/watch?v=pXKB2OovUi4&t=15s
        -->let say primes[] = {2,7,13,15}
        --> so super ugly number sequence : {1,2,4,7,8,13,14,16,19,26,28,32,38....} ,we store them in array or list
        -->create a min heap which stores the nth super ugly number, index of next number in super ugly sequence and the base prime multiplier
        --> corner case is when n==1 we return 1
        --> then we add each  number from primes[] as {primes[i],0,primes[i]} = {number,index of next prime in sequence,base prime multiplier}
        --> find the min super ugly number,generate the next super ugly number by multipling prime multlipier with next super ugly whose index is stored in pq.
        --> do care of duplicates, we will not add duplicates to array
        --> at last return last super ugly number in array.
        --> let say prime[] = {2,7,13,15}
        
        --> 2,4,7,8,13,14......
        --> (2,0,2) -->(4,1,2)-->(8,2,2)-->(14,3,2)
        --> (7,0,7) -->(14,1,7)-->(28,2,7)
        --> (13,0,13) -->(26,1,13)
        --> (19,0,19)
        
        
*/
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1)return 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int[] arr = new int[n-1];
        for(int ele : primes)pq.add(new int[]{ele,0,ele});
        int i=0;
        while(i<n-1){
            int[] x = pq.poll();
            if(pq.isEmpty() || x[0]!=pq.peek()[0]){
                arr[i]=x[0];
                i++;
            }
            x[0] = arr[x[1]]*x[2];
            x[1]++;
            pq.add(x);
        }
        return arr[n-2];
    }
}
