class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        trace_record = [[triangle[0][0]]]
        for i in range(1,len(triangle)):
            trace_record.append([])
            for j in range(len(triangle[i])):
                if j != 0 and j != len(triangle[i])-1:
                    trace_record[i].append(min(trace_record[i-1][j-1]+triangle[i][j],trace_record[i-1][j]+triangle[i][j]))
                elif j == 0:
                    trace_record[i].append(trace_record[i-1][0]+triangle[i][j])
                elif j == len(triangle[i])-1:
                    trace_record[i].append(trace_record[i-1][j-1]+triangle[i][j])
        return sorted(trace_record[len(trace_record)-1])[0]
