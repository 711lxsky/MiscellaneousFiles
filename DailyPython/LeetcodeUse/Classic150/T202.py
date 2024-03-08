class Solution:
    def isHappy(self, n: int) -> bool:
        record = set()
        def getSumOfSquare(n: int) -> int:
            sum = 0
            while n:
                sum += (n % 10) ** 2
                n //= 10
            return sum
        while n != 1:
            record.add(n)
            n = getSumOfSquare(n)
            if n in record:
                return False
        return True