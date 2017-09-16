class Solution(object):
    # def minPathSum(self, grid):
    #     """
    #     :type grid: List[List[int]]
    #     :rtype: int
    #     """
    #     """
    #     0123
    #     3456
    #     6789
    #     """
    #     visited_node = dict()
    #     return self.check_SP(grid, len(grid) - 1, len(grid[0]) - 1,visited_node)[0]
    #
    # def check_SP(self, grid, x, y,visited_node):
    #     try:
    #         return visited_node[(x,y)],visited_node
    #     except KeyError:
    #         if x != 0 and y != 0:
    #             min_value = min(self.check_SP(grid, x, y - 1,visited_node)[0] + grid[x][y], self.check_SP(grid, x - 1, y,visited_node)[0] + grid[x][y])
    #             visited_node[(x,y)] = min_value
    #             return min_value,visited_node
    #         elif x == 0 and y == 0:
    #             visited_node[(x,y)] = grid[0][0]
    #             return grid[x][y],visited_node
    #         elif x == 0:
    #             min_value = self.check_SP(grid, x, y - 1,visited_node)[0] + grid[x][y]
    #             visited_node[(x, y)] = min_value
    #             return min_value, visited_node
    #         elif y == 0:
    #             min_value = self.check_SP(grid, x-1, y,visited_node)[0] + grid[x][y]
    #             visited_node[(x, y)] = min_value
    #             return min_value, visited_node

    def minPathSum(self, grid):
        m, n = len(grid), len(grid[0])
        r = []
        for i in xrange(m):
            r.append([])
            for j in xrange(n):
                r[i].append(grid[i][j])
                if i and j == 0:
                    r[i][j] += r[i-1][j]
                elif j and i == 0:
                    r[i][j] += r[i][j-1]
        for i in xrange(1, m):
            for j in xrange(1, n):
                r[i][j] += min(r[i-1][j], r[i][j-1])
        return r[m-1][n-1]

Sol = Solution()
list = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
print Sol.minPathSum(list)