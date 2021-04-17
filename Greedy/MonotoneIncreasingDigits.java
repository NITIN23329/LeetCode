// time and space complexity : O(1) , since atmost we have 10 digits
/*    --> Examples : 12344432 have ans : 12339999.
      --> approach is if digits are increasing str[i] <= str[i+1]. simply append it.
      --> otherwise put digit at staring s[i] digit = s[i]-1 followed by 9.
*/
class Solution {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n)+'a';//'a' is append as a dummy character
        int len = str.length();
        int[] arr = new int[len-1];
        for(int i=0;i<len-1;i++){
            if(str.charAt(i)<=str.charAt(i+1))
                arr[i] = str.charAt(i) - '0';
            else {
                int j = i;
                while(j>0 && str.charAt(i)-'0'==arr[j-1])j--;
                arr[j] = str.charAt(j)-1-'0';
                j++;
                while(j<len-1)arr[j++] = 9;
                break;
            }
        }
        
        int val = 0;
        for(int ele :arr)val = 10*val+ele;
        return val;
    }
}
