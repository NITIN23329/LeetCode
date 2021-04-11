// time complexity : O(N), auxilarry space complexity :O(1)
/*
    --> To reduce max(depth(A), depth(B)), we need to minimize both depth(A), depth(B)
    --> So we keep track of both open parenthesis in A and B, If openA > OpenB, the new '(' should goto B instead of A. So that we dont increase  max(depth(A), depth(B))
    --> Similarly, if If openA > OpenB, then new ')' goto A instead of B so that hmax(depth(A), depth(B) can be reduced.
*/
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int openA = 0;
        int openB = 0;
        int n = seq.length();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            char ch = seq.charAt(i);
            if(ch=='('){
                if(openA<openB){
                    openA++;
                    arr[i] = 0;
                }else{
                    openB++;
                    arr[i] = 1;
                }
            }
            else {
                if(openA>openB){
                    openA--;
                    arr[i] = 0;
                }
                else{
                    openB--;
                    arr[i] = 1;
                }
            }
        }
        return arr;
    }
}
