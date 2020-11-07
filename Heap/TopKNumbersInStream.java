//problem link : https://practice.geeksforgeeks.org/problems/top-k-numbers3425/1
// time O(n*k*logn)
class Solution
{
    static ArrayList<Integer> kTop(int[] a, int n, int k)
    {   
        Map<Integer,Pair> map= new HashMap<>();         //stores distinct element and its corresponding pair
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1 , Pair p2){      // first short according to frequency and then by value
                if(p1.freq>p2.freq)return -1;
                else if(p1.freq<p2.freq)return 1;
                else {
                    return p1.data-p2.data;
                }
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(a[i])){        //if true then the element is present in pq, just increase its frequency
                pq.remove(map.get(a[i]));
                map.get(a[i]).freq++;
                pq.add(map.get(a[i]));
            }
            else {                          // if not present , add to pq and give same pair refrence to hashmap also , helpful to remove particular pair from pq
                Pair p = new Pair(a[i],1);
                map.put(a[i],p);
                pq.add(p);
            }
            ArrayList<Pair> t = new ArrayList<>();
            int x = pq.size();
            for(int j=0;j<Math.min(k,x);j++)
                t.add(pq.poll());
            for (Pair p : t){
                list.add(p.data);
                pq.add(p);
            }
        }
        return list;
    }
}
class Pair{
    int data;
    int freq;
    public Pair(int d,int f){
        data=d;
        freq=f;
    }
}
