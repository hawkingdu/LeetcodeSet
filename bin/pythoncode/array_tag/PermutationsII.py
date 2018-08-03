

class Solution:
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        nums.sort()
        self.dfs(result, [], nums, [False for i in range(0, len(nums))])
        return result

    def dfs(self, result, subList, nums, used):
        if len(subList) == len(nums) :
            result.append(list(subList))
        else:
            for i in range(0, len(nums)):
                if used[i]:
                    continue
                if i>0 and nums[i] == nums[i-1] and not used[i-1]:
                    continue
                subList.append(nums[i])
                used[i] = True
                self.dfs(result, subList, nums, used)
                used[i] = False
                subList.pop(len(subList)-1)

if __name__=='__main__':
    s = Solution()
    r = s.permuteUnique([1,1,2])
    print(r)