// time complexity : O(n), space complexity : O(n), can be reduced to O(1)
/*
    approach :
      --> We have 2 cases : a_prefix + b_suffix  or b_prefix + a_suffix. Both cases are interconvertable if we swap both strings.
      --> First check if some a_prefix + b_suffix is a palindrom or not. The 2nd one can be same in same way by swapping.
      --> Try to match first characters of 'a' with last characters of 'b'. a[i++] == b[j--]
      --> From the first point of dismatch a[i] != b[j]. The rest all chacacters can be taken by 'a' or 'b'.
      --> if we take 'a' then a[i++] == b[j--] untill i<=j
      --> if we take 'b' then b[i++] == b[j--] unti;l i<=j.
      --> If either of them true, we found a palindromic string.
*/
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int n = aa.length;
        return helper(aa,bb,n) || helper(bb,aa,n);
    }
    private boolean helper(char[] a,char[] b,int n){
        int i = 0;
        int j = n-1;
        while(i<=j && a[i]==b[j]){
            i++;j--;
        }
        int ii = i,jj=j;
        // if the remaining character is taken from a
        while(i<=j && a[i]==a[j]){
            i++;j--;
        }
        // if the remaining character is taken from b
        while(ii<=jj && b[ii]==b[jj]){
            ii++;jj--;
        }
        return i>j || ii>jj;
    }
}
