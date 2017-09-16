class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return max(nums[0],nums[1])
        else:
            while len(nums) > 3:
                nums[1] = max(nums[0],nums[1])
                nums[2] += nums[0]
                nums.pop(0)
            return max(nums[0]+nums[2],nums[1])
        
