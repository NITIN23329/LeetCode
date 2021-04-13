//time and space complexity : o(n)
/*
  approach :
      --> First thing is both must have same length.
      --> Then. we count frequency of each character in both strings and store them in array
      --> if a character is present only 1 string then there is no way we can produce that character in other string , so return false.
      --> For conversion of a character to another in word1, we mush have same freq value in word2 after conversion took place.
      --> example: word1 = "xxyyyy" and word2 = "xxxxyy". After conversion in word1, it becomes word1 = "yyxxxx" So after conversion freq1('x') = freq2('x') and freq1('y') = freq2('y').
      --> Or we can say before conversion of word1 freq1('x') = freq2('y') and freq1('y') = freq2('x').
      --> This gives the idea that we have same freqency count in both words. Let say freqCount[i] = j means we have j # of characters having freqency i.
      --> consider word1 = 'xyyzzzz' and word2 = 'yzzxxxx' In word1 we have freqencyCount1 = [0,1,2,0,1] So in word2 we must have same freqencyCount2 = [0,1,2,0,3]
*/
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        countFreq(word1,freq1);
        countFreq(word2,freq2);
        int n = word1.length();
        int[] freqCount1 = new int[n+1];
        int[] freqCount2 = new int[n+1];
        for(int i=0;i<26;i++){
            if(freq1[i]>0){
                freqCount1[freq1[i]]++;
                if(freq2[i]==0)return false;
            }
            if(freq2[i]>0){
                freqCount2[freq2[i]]++;
                if(freq1[i]==0)return false;
            }
        }
        for(int i=0;i<n+1;i++)
            if(freqCount1[i]!=freqCount2[i])return false;
        return true;
    }
    private void countFreq(String str, int[] freq){
        for(char c : str.toCharArray())
            freq[c-'a']++;
    }
}
