class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = ''.join(ch.lower() for ch in s if ch.isalnum())
        revs = s[::-1]
        if s == revs:
            return True
        return False