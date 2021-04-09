// time and space complexity : O(1)
/*
  --> for minutes, maximum we can get is 59 and no restrictions are there.
  --> for hours, both 1st and 2nd digits are dependent on each other.
  --> if 1st digit is 2, 2nd digit can be of max 3.
  --> if 1st digit is 0/1, 2nd digit can be upto 9.
*/
class Solution {
    public String maximumTime(String time) {
        char m1,m2,h1,h2;
        m2 = time.charAt(4)=='?'?m2 = '9':time.charAt(4);
        m1 = time.charAt(3)=='?'?m1 = '5':time.charAt(3);
        if(time.charAt(0)=='?' && time.charAt(1)=='?'){
            h1 = '2';h2 = '3';
        }
        else if(time.charAt(0)=='?'){
            h2 = time.charAt(1);
            h1 = h2<='3'? '2':'1';
        }
        else if(time.charAt(1)=='?'){
            h1 = time.charAt(0);
            h2 = h1=='2'?'3':'9';
        }
        else {
            h1 = time.charAt(0);
            h2 = time.charAt(1);
        }
        return ""+h1+h2+":"+m1+m2;
    }
}
