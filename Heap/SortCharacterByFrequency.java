//time O(n+ 130*log(130)) = O(n), space O(130)
/*  approach :
    --> maintain a heap such that the maximum freq character appears at top , and if frequency is same , character found previous found at top
*/
class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer[] i1,Integer[] i2){
                if(i1[0]!=i2[0])return i2[0]-i1[0];
                return i1[1]-i2[1];
            }
        });
        Integer[][] freq = new Integer[130][];
        for(int i=0;i<130;i++)freq[i] = new Integer[]{0,0};
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            freq[c][0]++;
            freq[c][1]=i;
        }
        for(int i=0;i<130;i++)
            pq.add(new Integer[]{freq[i][0],freq[i][1],i});
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            Integer[] t = pq.poll();
            for(int i=0;i<t[0];i++)str.append((char)((int)(t[2])));
        }
        return str.toString();
    }
}
