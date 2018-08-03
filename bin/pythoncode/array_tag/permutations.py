
class Solution:
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        nums.sort()
        self.dfs(result, [], nums)
        return result

    def dfs(self, result, subList, nums):
        if len(subList) == len(nums):
            result.append(list(subList))
        else:
            for i in range(0, len(nums)):
                if subList.__contains__(nums[i]):
                    continue
                subList.append(nums[i])
                self.dfs(result, subList, nums)
                subList.pop(len(subList)-1)

if __name__=='__main__':
    s = Solution()
    r = s.permute([1,2,3])
    print(r)
