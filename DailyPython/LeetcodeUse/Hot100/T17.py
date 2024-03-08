from ast import List
import itertools


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return list()
        
        phone = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        combinations = list()
        combination = list()
        def backtrack(index : int):
            if index == len(digits):
                combinations.append(''.join(combination))
                return
            else :
                digit = digits[index]
                for letter in phone[digit]:
                    combination.append(letter)
                    backtrack(index + 1)
                    combination.pop()
        backtrack(0)
        return combinations
    


class Solution:
        def letterCombinations(self, digits: str) -> List[str]:
            if not digits:
                return list()
        
            phone = {
                '2': 'abc',
                '3': 'def',
                '4': 'ghi',
                '5': 'jkl',
                '6': 'mno',
                '7': 'pqrs',
                '8': 'tuv',
                '9': 'wxyz'
            }

            groups = (phone[digit] for digit in digits)
            return ["".join(combination) for combination in itertools.product(*groups)]