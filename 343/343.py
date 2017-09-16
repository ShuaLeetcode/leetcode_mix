# class Solution(object):
#     def integerBreak(self, n):
#         """
#         :type n: int
#         :rtype: int
#         """
#         multi = []
#         if n == 2:
#             return 1
#         elif n == 3:
#             return 2
#         elif n == 4:
#             return 4
#         else:
#             for i in range(n/2-1):
#                 left = self.integerBreak(n-i-2) if n-i-2 > 4 else n-i-2
#                 right = self.integerBreak(i+2) if i+2 >= 4 else i+2
#                 multi.append(left * right)
#             return max(multi) 
class Solution(object):
    def integerBreak(self, n):
        
        if n==2:
            return 1
        if n==3:
            return 2
        if n==4:
            return 4
        if n==5:
            return 6

        k=n%3
        x=n//3
        if k==0:
            return 3**x
        if k==1:
            return 3**(x-1)*4
        else:
            return 3**x*2
        
                
