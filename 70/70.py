class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        one_step = 0
        two_stpe = 0
        return_number = lambda n: self.climbStairs(n-1)+self.climbStairs(n-2) if n>=2 else self.climbStairs(n-1) if n == 1 else 1
        return return_number(n)
        # if n >= 2:
        #     one_step = self.climbStairs(n-1)
        #     two_step = self.climbStairs(n-2)
        #     return one_step + two_step
        # elif n == 1:
        #     one_step = self.climbStairs(n-1)
        #     return one_step
        # else:
        #     return 1

sol = Solution()
print sol.climbStairs(5)
	
        
        
