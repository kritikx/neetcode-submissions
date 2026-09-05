class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        i,j = 0,0

        d = {}
        ans = 0

        while j < len(s):

            d[s[j]] = d.get(s[j],0) + 1

            if len(d) < j - i + 1:
                while len(d) < j - i + 1:
                    d[s[i]] -= 1
                    if d[s[i]] == 0:
                        del d[s[i]]
                    i += 1
            else:#len(d) = j - i + 1
                ans = max(ans,j-i+1)
            j += 1
        return ans
