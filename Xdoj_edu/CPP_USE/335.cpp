#include<iostream>
#include<vector>
using namespace std;
 
//构建小顶堆 递归~~~
//len 是 num长度 index是第一个非叶子节点的下标
//确保此节点符合标准
void adjust2min(vector<int> &num, int len, int index) {
	int l = 2 * index + 1;  //左子节点
	int r = 2 * index + 2;  //右子节点
 
	int minIdx = index;
	if (l < len && num[l] < num[minIdx]) {
		minIdx = l;
	}
	if (r < len && num[r] < num[minIdx]) {
		minIdx = r;
	}
	if (minIdx != index) {
		swap(num[minIdx], num[index]);
		adjust2min(num, len, minIdx);
	}
}
 
void heapSort(vector<int> &num, int size) {
	//构建小根堆（从最后一个非叶子节点向上）
	for (int i = size / 2 - 1; i >= 0; i--) {
		adjust2min(num, size, i);
	}
 
	//调整小根堆（题干未要求）
//	for (int i = size - 1; i >= 1; i--) {
//		swap(num[0], num[i]); //尾部最小
//		adjust2min(num, i, 0); //继续堆排序
//	}
}
 
int main() {
	
	vector<int> num;
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int k;
		cin >> k;
		num.push_back(k);
	}
	heapSort(num, num.size());
	for (int i = 0; i < n; i++) {
		cout << num[i] << ' ';
	}
 
 
}