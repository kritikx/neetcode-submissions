class Solution:
    def minWindow(self, s: str, t: str) -> str:
        i,j = 0,0

        d = {}
        for ch in t:
            d[ch] = d.get(ch,0) + 1
        count = len(d)

        ans = ""

        while j < len(s):

            if s[j] in d:
                d[s[j]] -= 1
                if d[s[j]] == 0:
                    count -= 1
            
            while count == 0:
                if ans == "" or j - i + 1 < len(ans):
                    ans = s[i:j+1:1]
                if s[i] in d:
                    if d[s[i]] == 0:
                        count += 1
                    d[s[i]] += 1
                i += 1
            j += 1
        return ans