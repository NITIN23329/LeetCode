//approach1: same as Reorganize string.java

// time O(n) , space O(n)
/*  approach : 
      --> we can put same element alternatively. like 1,2,1,2 or 1,2,1,2,1,3,1,3
      --> but we need to handle the most frequent element first , suppose [1,1,1,3,3], if we take 3 first then : 3,_,3_,_ , so, last 2 ones will be consecutive.
      --> if we handle the most frequent element first 1,_,1_,1 , we can now put 3 into it the gaps.
*/
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxFreq=0;
        int maxEle = -1;
        for(int ele : barcodes){
            if(!map.containsKey(ele))map.put(ele,0);
            map.put(ele,map.get(ele)+1);
            if(maxFreq<map.get(ele)){
                maxFreq = map.get(ele);
                maxEle = ele;
            }
        }
        map.remove(maxEle);
        int[] arr = new int[barcodes.length];
        int ind=0;
        for(int i=0;i<maxFreq;i++){
                arr[ind] = maxEle;
                ind+=2;
                if(ind>=arr.length)ind=1;
        }
        for(int ele : map.keySet()){
            int freq = map.get(ele);
            for(int i=0;i<freq;i++){
                arr[ind] = ele;
                ind+=2;
                if(ind>=arr.length)ind=1;
            }
        }
        return arr;
    }
}
}
