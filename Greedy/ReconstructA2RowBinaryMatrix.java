// time complexity : O(colsum.length)
/*
    --> There are columns with 2 ones, 1 ones and 0 ones.
    --> The column with 2 ones and 0 ones have only 1 choice, both row have to be either 1 or 0 respectively.
    --> But the columns having 1 have a opetion if add 1 to first row or to second row.
    --> So first put 1 in both rows whose colsum is 2.
    --> After that put 1 to first row until upper >0 and then put 1 to second row until lower > 0
*/
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> twoIndex = new ArrayList<>();
        List<Integer> oneIndex = new ArrayList<>();
        // finding those col whose sum is 2 and 1 
        for(int i=0;i<colsum.length;i++)
            if(colsum[i]==2)twoIndex.add(i);
            else if(colsum[i]==1)oneIndex.add(i);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        // initialize every element by 0
        for(int i=0;i<colsum.length;i++){
            ans.get(0).add(0);
            ans.get(1).add(0);
        }
        // first initilaize those col whose sum is 2.
        for(int ind : twoIndex){
            ans.get(0).set(ind,1);
            ans.get(1).set(ind,1);
            upper--;
            lower--;
        }
        // then initilaize those column whose sum is 1
        for(int ind : oneIndex){
            if(lower>0){
                ans.get(1).set(ind,1);
                lower--;
            }
            else {
                ans.get(0).set(ind,1);
                upper--;
            }
        }
        if(upper!=0 || lower!=0)return new ArrayList<>();
        return ans;
    }
}
