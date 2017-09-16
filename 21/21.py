# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    def merge(self, list1, list2):
        part_merge = []
        if len(list1) != 0 and len(list2) != 0:
            if list1[0] <= list2[0]:
                part_merge.append(list1[0])
                return part_merge + self.merge(list1[1:], list2)
            else:
                part_merge.append(list2[0])
                return part_merge + self.merge(list1, list2[1:])
        elif len(list1) == 0:
            return list2
        else:
            return list1

sol = Solution()
print sol.merge([1,2,3,5,6,9],[2,4,6,8])