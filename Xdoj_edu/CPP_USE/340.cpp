#include<iostream>
#define MAXSIZE 100
using namespace std;
 
void shell(int num[], int n) {
 
	int d;
	for (d = n / 2; d >=1; d /= 2) { //步长初始化
		for(int i=0;i<d;i++){  //第一个元素下标
			for(int j=i;j<n;j+=d){     //冒泡一下
				for(int k=i;k+d<n-(j-i);k+=d){
					if(num[k]>num[k+d]){
						swap(num[k],num[k+d]);
					}
				}
			}
		}
		break;  //题干只要第一趟
	}
}
int main() {
 
	int n;
	cin>>n;
	int num[MAXSIZE] = {0};
	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}
	shell(num, n);
	for (int i = 0; i < n; i++) {
		cout << num[i]<<' ';
	}
	return 0;
}