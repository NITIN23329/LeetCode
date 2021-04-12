// time complexity : O(n) , space complexity : O(n)
/*
  --> Conversion of 10' to '01' can be used to shift '0' to right and '1' to left.
  --> If we have a sequence of '0000000', then all zeroes except last one can become '1'.
  --> This give rise to a greddy solution :
  --> We will try to put zeros towards last of string.? How can we do it.
  --> As soon as a zero is found, we will call all zeros right of it towards it and club all zeros and convert all them to 1 but last one.
  --> Consider example '1101100', we found first '0' at index 1, we will push all zeros right of it towards first zero, "1100011". Then it can be converted to '1111011'.
  
*/
class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        char[] maxBinary = new char[n];
        Arrays.fill(maxBinary,'1');
        int startZero = -1;
        int zeros = 0;
        for(int i=0;i<n;i++){
            char c = binary.charAt(i);
            zeros += c=='0'?1:0;
            if(startZero==-1 && c=='0'){
                startZero = i;
            }
        }
        if(startZero!=-1)
            maxBinary[startZero+zeros-1] = '0';
        return String.valueOf(maxBinary);
    }
}

