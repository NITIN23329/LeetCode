// time complexity : O(n+26log26) = O(n), space complexity : O(26+n) = O(n)
/*
    --> Approach :
    --> First check when the answer is not possible, Say we have 5 'a'. Then we must need atleast 4 other character to added in btw consecutive 'a's.
    --> Upon this observation we can say when maxFreq > restFreq-1, then we dont have sufficient characters to put in btw of maxFreq character.
    --> Otherwise it is possible to create a string.
    --> Now first we try to put all max freq character first, as they are the pain in ass.
    --> So sort character accoriding to their frequency.
    --> Then first put max freq element first , then we have to put atleast 1 character in btw each of them.
    --> We can assume there is a window of infinite size in btw maxFreq character.
    --> We put a character in a particular window  only one time and move on to next window if there are more freq of a character.
    --> Suppose our string: 'aaabc', then we have a____a___a. Then we see we have 'b', put it in first window a_b_a___a. Then we see we have 'c'. 
    --> We will put 'c' in next window and not in current window. a_b_a_c_a. So we put characters in window sequentially.

*/
class Solution {
    public String reorganizeString(String str) {
        int[][] freq = new int[26][2];
        for(var c : str.toCharArray()){
            freq[c-'a'][0]++;
            freq[c-'a'][1] = c-'a';
        }
        Arrays.sort(freq,(a,b)->(b[0]-a[0]));
        int maxFreq = freq[0][0];
        int restFreq = str.length() - maxFreq;
        if(maxFreq>restFreq+1)return "";    // not possible
        StringBuffer[] arr = new StringBuffer[maxFreq];
        for(int i=0;i<maxFreq;i++)arr[i] = new StringBuffer();
        int j=0;
        for(int i=0;i<26;i++){
            for(int k = 0;k<freq[i][0];k++){
                arr[j%maxFreq].append((char)(freq[i][1]+'a'));
                j++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(StringBuffer ele:arr)sb.append(ele);
        return sb.toString();
    }
}
