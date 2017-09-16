class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sorted_nums = sorted(nums)
        left, right = 0, len(nums)-1
        while left < right and nums[left] == sorted_nums[left]:
            left += 1
        while left < right and nums[right] == sorted_nums[right]:
            right -= 1
        return right - left + 1 if right > left else 0
                
