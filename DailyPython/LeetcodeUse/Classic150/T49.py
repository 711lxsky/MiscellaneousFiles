from ast import List
import collections


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        record = collections.defaultdict(list)

        for word in strs:
            key = "".join(sorted(word))
            record[key].append(word)
        return list(record.values())
    
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        record = collections.defaultdict(list)
        for str in strs:
            cnt = [0] * 26
            for ch in str:
                cnt[ord(ch) - ord('a')] += 1
            # tuple属于原生数据类型，长度不可变化，可以进行哈希化; 反之，list长度可变，不可哈希化
            record[tuple(cnt)].append(str)
        return list(record.values())