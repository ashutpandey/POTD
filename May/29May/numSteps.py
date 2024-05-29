class Solution:
    def numSteps(self,s):
        '''O(N) approach which takes into account that once carry set to a 1 it will never become 0 again and 
        operations it take to remove the last digit if it's a 0 is 1 and if it's a one is two because we convert that to a 0 in one step and then one step for 
        a zero to be removed from the string
        '''
        carry=0
        res=0
        for i in reversed(range(1,len(s))):
            digit=(int(s[i])+carry)%2
            if digit==0:
                res+=1
            else:
                carry=1
                res+=2
        return res+carry


        #O(N^2) solution where we change the input string and count how such operation we needed to do
        # def addOne(s):
        #     i=len(s)-1
        #     s=list(s)
        #     while i>=0 and s[i]=='1':
        #         s[i]='0'
        #         i-=1
        #     if i==-1:
        #         s=['1']+s
        #     else:
        #         s[i]='1'
        #     return ''.join(s)

        # res=0
        # while s!='1':
        #     if s[-1]=='0':
        #         s=s[:-1]
        #     else:
        #         s=addOne(s)
        #     res+=1
        # return res

s=Solution()
ans=s.numSteps('1011')
print(ans)