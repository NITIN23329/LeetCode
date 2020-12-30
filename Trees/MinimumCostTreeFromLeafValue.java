// time O(n^2) , space O(n)
/*  approach :
      --> find minimum product of 2 consecutive leaf nodes.
      -->the mimimum product we got is a non leaf value and hence add to out sum
      --> since we need to get the largest leaf in subtrees for furthur calculation,remove the smallest btw them
*/
class Solution {
    public int mctFromLeafValues(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int res=0;
        for(int ele : arr)list.add(ele);
        while(list.size()>1){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i=0;i<list.size()-1;i++){
                int x = list.get(i)*list.get(i+1);
                if(min>x){
                    min = x;
                    index = i;
                }
            }
            res+=min;
            if(list.get(index)>list.get(index+1))index++;
            list.remove(index);
        }
        return res;
    }
}
