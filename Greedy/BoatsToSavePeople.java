// time and space complexity : O(max(n,3*10^4). We can say it linear.
/*
    --> The optitmal choice is to put larest weight and least weight people in a same boat.
    --> So we can sort people in increasing order of their weight and use a point pointer approach. Let l denotes left pointer and r denotes right pointer.
    --> We use counting sort . Let freq[i] = j denotes we have j people having weight = i.
    --> So we freq[l]>0 and freq[r]>0, we try to put r'th weight person first and then l'th weight person if weight limit doesn't exceeds and at max 2 people can be in a single boat.
*/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int max =  30_001;
        int[] freq = new int[max];
        for(var ele : people)freq[ele]++;
        int l = 1;  
        int r = max-1;
        int boats = 0;  
        int curr_people = 0;      // denote # of people on current boat
        int curr_lim = 0;         // denote weight of current boat.
        while(l<=r){
            if(freq[l]==0)l++;
            if(freq[r]==0)r--;
            if(freq[l]!=0 && freq[r]!=0){
                if(curr_lim+r<=limit && curr_people<2){     // putting more weight person
                    curr_lim+=r;
                    freq[r]--;
                    curr_people++;
                }
                else if(curr_lim+l<=limit && curr_people<2){    // putting less weight person
                    curr_lim+=l;
                    freq[l]--;
                    curr_people++;
                }
                else{                                           // if limit reaches, take a new boat.
                    boats++;
                    curr_lim = 0;
                    curr_people = 0;
                }
            }
        }
        if(curr_lim>0)boats++;                      
        return boats;
    }
}
