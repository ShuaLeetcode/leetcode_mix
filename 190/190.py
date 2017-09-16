class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        binary_string = "{0:b}".format(n)
        if len(binary_string) < 32:
            binary_string = '0'*(32-len(binary_string)) + binary_string
        reverse_string = binary_string[::-1]
        return int(reverse_string,2)
cd 
sol = Solution()
print sol.reverseBits(-1)