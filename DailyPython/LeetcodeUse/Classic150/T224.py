class Solution:
    def calculate(self, s: str) -> int:
        nums = list()
        nums.append(0)
        ops = list()
        s = s.replace(" ", "")
        n = len(s)
        i = 0
        while i < n:
            if s[i] == '(':
                ops.append(s[i])
            elif s[i] == ')' :
                while len(ops) > 0 :
                    op = ops[-1]
                    if op != '(' :
                        self.calc(nums, ops)
                    else :
                        ops.pop()
                        break
            else :
                if self.isNum(s[i]) :
                    num = 0
                    while i < n and self.isNum(s[i]) :
                        num = num * 10 + int(s[i])
                        i += 1
                    i -= 1
                    nums.append(num)
                else : 
                    if i > 0 and ( s[i-1] == '(' or s[i-1] == '+' or s[i-1] == '-') :
                        nums.append(0)
                    while len(ops) > 0 and ops[-1] != '(' :
                        self.calc(nums, ops)
                    ops.append(s[i])
            i += 1
        while len(ops) > 0 :
            self.calc(nums, ops)
        return nums[-1]

    def calc(self, nums, ops):
        if len(nums) < 2 or len(ops) < 1 :
            return
        num2 = nums.pop()
        num1 = nums.pop()
        op = ops.pop()
        if op == '+' :
            nums.append(num1 + num2)
        elif op == '-' :
            nums.append(num1 - num2)


    def isNum(self, c):
        return c >= '0' and c <= '9'