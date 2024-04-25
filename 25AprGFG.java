class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        // code here
        int max=Integer.MIN_VALUE;
        if(n<=2||m<=2){
            return -1;
        }
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                int sum=mat[i][j]+mat[i][j+1]+mat[i][j+2]+
                    mat[i+1][j+1]+mat[i+2][j]+
                    mat[i+2][j+1]+mat[i+2][j+2];
                max=Math.max(max,sum);
                
            }
        }
        return max;
    }
};
