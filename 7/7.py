class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        return self.doit(x)
        
    def check(self, number):
        if number < 2147483647 and number > -2147483648:
            return number
        else:
            return 0
        
    def doit(self,number):
        stringx = list(str(number))
        inverse = []
        if stringx[0] == '-':
            inverse.append('-')
            for i in range(len(stringx)-1,0,-1):
                inverse.append(stringx[i])
            inverse = map(str,inverse)
            return self.check(int(''.join(inverse)))
        else:
            for i in range(len(stringx)-1,-1,-1):
                inverse.append(stringx[i])
            inverse = map(str,inverse)
            return self.check(int(''.join(inverse)))
