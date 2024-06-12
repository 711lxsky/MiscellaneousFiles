package practice;

public class T318_240612 {

	class Solution{

		public int maxProduct(String[] words){
			// 思路是位运算，先将单词转换为整数，再&一下，如果没有公共字母肯定为0
			int n = words.length;
			int [] nums = new int[n];
			for(int i = 0; i < n; i ++){
				String curWord = words[i];
				int len = curWord.length();
				int num = 0;
				for(int j = 0; j < len; j ++){
					char curChar = curWord.charAt(j);
					num |= (1 << (curChar - 'a'));
				}
				nums[i] = num;
			}
			int maxLen = 0;
			for(int i = 0; i < n; i ++){
				for(int j = i + 1; j < n; j ++){
					if((nums[i] & nums[j]) == 0){
						maxLen = Math.max(words[i].length() * words[j].length(), maxLen);
					}
				}
			}
			return maxLen;
		}
	}

    public static void main(String[] args){
        String [] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
    }
}
