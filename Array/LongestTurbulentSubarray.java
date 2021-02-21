// time and space complexity: O(n)
/*  approach : LTS = longest turbulent subarray.
      --> for every element , we store 3 things: LTS considering current element at lower value , LTS considering current element at higher value and maximum LTS found so far.
      --> let say the array is .....5,7....... , where i is at element 5
      --> in this case arr[i]<arr[i+1] , so lower LTS of i  = Higher LTS of i+1 , higher LTS of i is 1 then.
      --> let say array is ....7,5........ , where i is at element 7
      --> in this case , arr[i]>arr[i+1] , so higher LTS of i = lower LTS of i+1 and lower LTS of i is 1.
      -->  let say array is ....5,5........ , where i is at element 1st i
      --> in this case lower LTS and higher LTS of i is 1.
      --> find max of lower and higher LTS of i .
*/
class Solution {
    public int maxTurbulenceSize(int[] arr) {
         return recursiveHelper(0,arr)[2];
    }
    private int[] recursiveHelper(int i,int[] arr){
        if(i==arr.length-1)return new int[]{1,1,1};
        int[] ans = new int[3];
        int[] next = recursiveHelper(i+1,arr);
        if(arr[i]>arr[i+1]){
             ans[1] = 1 + next[0];
             ans[0] = 1;
        }   
        else if(arr[i]<arr[i+1]){
            ans[0] = 1 + next[1];
            ans[1] = 1;
        } 
        else{
            ans[0] = 1;
            ans[1] = 1;
        }
        ans[2] = Math.max(next[2],Math.max(ans[1],ans[0]));
        return ans;
    }
}
