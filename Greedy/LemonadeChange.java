// time complexity O(n), space complexity O(1)
/*
  approach :
    --> We keep track of $5 and $10 change we have cuz we can pay back with the help of them.
    --> if bill is of $10, we need to return $5.
    --> if bill is of $20, we need to return $15, we can either pay $10 + $5 or $5 + $5 + $5. Greedy approach is to use $10 if possible so that $5 can be used more optimally.
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int _5 = 0;
        int _10 = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5)_5++;
            else if(bills[i]==10){
                _10++;
                if(_5==0)return false;
                _5--;
            }
            else{
                int remain = 15;
                if(_10>0){
                    _10--;
                    remain-=10;
                }
                if(remain/5<=_5)
                    _5 -= remain/5;
                else return false;
            }
        }
        return true;
    }
}
