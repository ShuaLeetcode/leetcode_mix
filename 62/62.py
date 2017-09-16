class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        field = [[0 for x in range(n)] for y in range(m)]
        for i in range(0,len(field),1):
            for j in range(0,len(field[0]),1):
                if i != 0 and j != 0:
                    field[i][j] = field[i-1][j] + field[i][j-1]
                elif i == 0 and j != 0:
                    field[i][j] = field[i][j-1]
                elif i != 0 and j == 0:
                    field[i][j] = field[i-1][j]
                else:
                    field[i][j] = 1
        return field[m-1][n-1]
