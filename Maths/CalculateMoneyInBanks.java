// time and space complexity : o(1)
/*
  approach : based on observation
  week0: 1 2 3 4 5 6 7
  week1: 2 3 4 5 6 7 8
  week2: 3 4 5 6 7 8 9
  week3: 4 5 6 7 8 9 10
  --> # of complete weeks for given n is weeks = (n-1)/7. (0 based indexing)
  --> so we need to find full sum upto previous week.
  --> for ith week sum : (7 + i)(8 + i)/2 - (i)(i + 1)/2 = 7*i + 28
  --> to find full sum upto previous week , sum over all week sum from i = 0 to weeks-1. And the sum comes out to be: 28*(weeks) + 7*(weeks)*(weeks-1)/2
  --> then on current week = weeks'th week, we will add some days sum .
  --> Let start = cost of monday of weeks'th week = weeks+1.
  --> Let end = cost of out nth day = n - 7*(start-1) + (start-1);
  --> current weeks contribution = (end)*(end+1)/2 - (start)*(start-1)/2;
  --> we add current weeks contribution + sum uptp previous week to get answer.
*/
class Solution {
    public int totalMoney(int n) {
        int weeks = (n-1)/7;
        int prevWeekSum = 28*(weeks) + 7*(weeks)*(weeks-1)/2;
        int start = weeks+1;
        int end = n - 7*(start-1) + (start-1);
        int sum = prevWeekSum + (end)*(end+1)/2 - (start)*(start-1)/2;
        return sum;
    }
}

