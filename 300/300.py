# class Solution(object):
#     def lengthOfLIS(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         current_longests = []
#         for num in nums:
#             if current_longests != []:
#                 add_into_exist = False
#                 for longlist in current_longests:
#                     if num > longlist[-1]:
#                         longlist.append(num)
#                         add_into_exist = True
#                 if not add_into_exist:
#                     current_longests.append([num])
#             else:
#                 current_longests.append([num])
#         longest = 0
#         for i in current_longests:
#             longest = len(i) if len(i) > longest else longest
#         return longest
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == []:
            return 0
        N = len(nums)
        LIS, max_so_far = [1]*N, 0
        for i in range(N):
            for j in range(i):
                if nums[i] > nums[j]:
                    LIS[i] = max(LIS[i], LIS[j]+1)
            max_so_far = max(max_so_far, LIS[i])
        return max_so_far


sol = Solution()
print sol.lengthOfLIS([1,2,3,4,5])