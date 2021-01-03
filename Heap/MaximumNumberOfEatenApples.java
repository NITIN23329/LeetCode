//time compleity  O(max(n,max(days[i]+i))* log(n))
/*  approach :
      --> maintain a min heap having closest rooten apple on top , 
      --> rooten day of ith apple is days[i] + i
      --> for each day , find the top most non rotten apple, reduce it by one and increment the counter
      --> do this until each apple gets rotten
*/
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        int c = 0;
        for(int i=0;;i++){
            if(i<apples.length && apples[i]>0)
                pq.add(new int[]{apples[i],i+days[i]-1});
           if( i>=apples.length && pq.isEmpty())break;
            while(!pq.isEmpty() && pq.peek()[1]<i)pq.poll();
            if(!pq.isEmpty()){
                if(--pq.peek()[0]==0)pq.poll();
                c++;
            }
        }
        return c;
    }
}

