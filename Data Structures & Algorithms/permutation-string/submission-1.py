class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:

        i,j = 0,0

        d = {}
        for ch in s1:
            d[ch] = d.get(ch,0) + 1

        count = len(d)
        k = len(s1)
        hasPermutation = False

        while j < len(s2):

            if s2[j] in d:
                d[s2[j]] -= 1
                if d[s2[j]] == 0:
                    count -= 1
                    
            if j - i + 1 > k:
                while j - i + 1 > k:
                    if s2[i] in d:
                        if d[s2[i]] == 0:
                            count += 1
                        d[s2[i]] += 1
                    i += 1

            if j - i + 1 == k:
                if count == 0:
                    hasPermutation = True

            j += 1
        return hasPermutation
        