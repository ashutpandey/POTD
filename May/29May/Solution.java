class Solution {
    public static int numSteps(String s) {

        /* works on the approach if we set the carry to 1 once it will never get's converted to a zero for the entire traversal also it takes 1 operation to remove a 0 to 0 and 2 operations to remove a 1 because 1 operation it will take to convert it to a 0 and then removing zero takes one operation 
        */
        int res=0;

        int n=s.length();
        int digit=0,carry=0;
        for(int i=n-1;i>=1;i--){
            digit=((int)s.charAt(i)+carry)%2;
            if(digit==0){
                res+=1;
            }
            else{
                carry=1;
                res+=2;
            }
        }
        return res+carry;
    }
    public static void main(String args[]){
        String s="1011";
        System.out.println(numSteps(s));
        


    }
}