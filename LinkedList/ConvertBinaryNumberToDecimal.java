//problem link : https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

//efficient solution by shit operator

class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while(head!=null){
            res = res<<1; //or res=res*2
            res+=head.val;
            head=head.next;
        }
        return res;
    }
}

// another solution by finding lenth of list
class Solution {
    public int getDecimalValue(ListNode head) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            System.out.println(head.val);
            temp = temp.next;
            len++;
        }
        
        int res = 0;
        while(head!=null){
            res+=head.val*Math.pow(2,len-1);
            len--;
            head=head.next;
        }
        return res;
    }
}

// another solution by convert list to string
class Solution {
    public int getDecimalValue(ListNode head) {
        String str="";
        while(head!=null){
            str+=head.val;
            head=head.next;
        }
        int count=0;
        int decimalVal=0;
        
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='1')
                decimalVal+=Math.pow(2,count);
            count++;
        }
        return decimalVal;
        
    }
}
