// time O(nlogk) , space O(n)
/*  approach :
      --> maintain a. in heap in which least frequent string appears at top
      --> and if freq is same , highest chronological string will appears at top because we will add it early to linkedlist
      --> so, higher chronological string will be removed first and added towards last to the linkedlist.
*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String ele: words){
            if(!map.containsKey(ele))map.put(ele,0);
            map.put(ele,map.get(ele)+1);
        }
        PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<>(){
            @Override 
            public int compare(Data d1,Data d2){
                if(d1.freq==d2.freq)return d2.str.compareTo(d1.str);
                return d1.freq-d2.freq;
            }
        });
        for(String ele : map.keySet()){
            pq.add(new Data(map.get(ele),ele));
            if(pq.size()>k)pq.poll();
        }
        LinkedList<String> list = new LinkedList<>();
        while(!pq.isEmpty())
            list.addFirst(pq.poll().str);
        return list;
    }
}
class Data{
    int freq;
    String str;
    public Data(int f,String s){
        freq=f;str=s;
    }
}
