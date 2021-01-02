//time complexity O(nlog26) , space Complexity(26)
/*  approach :
      --> we can see that if maximum frequncy of any character > ceil{n/2} , then we can not organinse the given string anyway.
      --> store the freq of each character in map
      --> maintain a max heap according to freq of characters
      --> each time we take out 2 most frequent character , write side by side and again add it to max , heap
      --> by this we can ensure no 2 consecutive characters are same in the string.
      --> for proof refer : https://leetcode.com/problems/reorganize-string/solution/
*/
class Solution {
    public String reorganizeString(String S) {
        Map<Integer,Integer> map = new HashMap<>();
        for(char c : S.toCharArray()){
            int x = (int)c;
            if(!map.containsKey(x))map.put(x,0);
            map.put(x,map.get(x)+1);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer[] a,Integer[] b){
                return b[1]-a[1];
            }
        });
        for(Integer ele : map.keySet()){
            if(map.get(ele)>Math.ceil(S.length()/2.0))return "";
            pq.add(new Integer[]{ele,map.get(ele)});
        }
        StringBuilder str = new StringBuilder();
        while(pq.size()>1){
            Integer[] a = pq.poll();
            Integer[] b = pq.poll();
            str.append((char)((int)(a[0]))).append((char)((int)(b[0])));
            if(a[1]-->1)
                pq.add(a);
            if(b[1]-->1)
                pq.add(b);  
        }
        if(!pq.isEmpty()){
            Integer[] a = pq.poll();
            str.append((char)((int)(a[0])));
        }
        return str.toString();
        
    }
}
