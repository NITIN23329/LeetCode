//time O(nlogn) , space O(n)
class Solution {
    public int leastInterval(char[] tasks, int k) {
        // let n  = tasks.length
        Map<Character,Integer> map = new HashMap<>();
        //map contains frequency of each character
        // takes O(n) time
        for(char c : tasks){
            if(!map.containsKey(c))map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        // character with maximum freq at top (max heap)
        // takes O(nlogn) time 
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1,Pair p2){
                if(p1.data<p2.data)return 1;
                else if(p1.data>p2.data)return -1;
                else return 0;
            }
        });
        //takes O(n) time
        for(char c: map.keySet())
            pq.add(new Pair(map.get(c),c));
        Queue<Pair> q = new LinkedList<>(); //size is  k+1 at max
        int c=0;
        // this while block takes O(n) time in total cuz each tasks enters and exits pq exactly 1time
        while(!pq.isEmpty()){
            q.add(pq.poll());   //adding 1st element
            for(int i=0;i<k && !pq.isEmpty();i++)
                q.add(pq.poll());           //adding k distinct elements in between to queue.
            int z=q.size();
            while(!q.isEmpty()){
                Pair p = q.poll();
                p.data--;
                if(p.data!=0)               //adding only those tasks whose freq left is >0
                    pq.add(p);
            }
            if(pq.isEmpty())c+=z;                       // if no next job left (executed last time)
            else c+=k+1;                                //else k+1 takes k+1 time
          
        }
        return c;
    }
}
// Pair of character and its frequency left
class Pair{
    int data;
    char c;
    public Pair(int d,char ch){
        data=d;
        c=ch;
    }
}
