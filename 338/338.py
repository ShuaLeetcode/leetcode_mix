class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        init = [0, 1]
        bit = 0
        whole_number = 1
        temp_num = num
        while temp_num != 0:
            temp_num = temp_num >> 1
            bit += 1
            whole_number *= 2
        if whole_number % num == 0:
            whole_number = num
        # print whole_number
        if num == 0:
            return [0]
        elif num == 1:
            return init
        elif num == whole_number:
            whole_minus_one = self.countBits(whole_number - 1)
            return whole_minus_one + [1]
        elif num == whole_number - 1:
            previous = self.countBits(num / 2)
            return previous + [i + 1 for i in previous]
        else:
            whole_minus_one = self.countBits(whole_number - 1)
            top_minus_one = self.countBits(whole_number / 2)
            diff = len(whole_minus_one) - len(top_minus_one)
            append = whole_minus_one[diff + 1: diff + 1 + num - whole_number / 2]
            append = [i+1 for i in append]
            return top_minus_one + append


sol = Solution()
print sol.countBits(14)