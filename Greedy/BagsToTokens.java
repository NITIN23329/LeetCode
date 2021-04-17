// time coplexity : o(nlogn), space complexity : o(1)
/*
    approach :
      --> if we want to play a token face up, we should play with min possible token value so as each playable token has score only 1 but we want to save power.
      --> If don't have enough power, we will try to play a token face down to get some power. As each playable token will reduce our score by 1 but we want to gain maximum power.
      --> We can also have a choice of stopping if we dont have enough power to play. But we dont know if we play face down would lead to more score or not.
      --> So we try to play face down and take maximum score possible.
      
*/
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int currPower = P;
        int currScore = 0;
        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length-1;
        int max = 0;
        while(l<=r){
            if(currPower>=tokens[l]){
                currPower-=tokens[l];
                l++;
                currScore++;
            }
            else if(currScore>0){
                currScore--;
                currPower+=tokens[r];
                r--;
            }
            else break;
            max = Math.max(max,currScore);
        }
        return max;
    }
}

