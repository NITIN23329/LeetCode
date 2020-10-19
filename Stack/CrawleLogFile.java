class Solution {
    public int minOperations(String[] logs) {
        int c = 0;
        for(String ele : logs){
            if(ele.equals("../"))c = Math.max(0,c-1);
            else if(ele.equals("./"));
            else{
                c++;
            }
        }
        return c;
    }
}
