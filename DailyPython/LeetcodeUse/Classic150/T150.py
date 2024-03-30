import math


class MinStack:

    def __init__(self):
        self.numStack = []
        self.minStack = [math.inf]


    def push(self, val: int) -> None:
        self.numStack.append(val)
        self.minStack.append(min(val, self.minStack[-1]))

    def pop(self) -> None:
        self.numStack.pop()
        self.minStack.pop()


    def top(self) -> int:
        return self.numStack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]