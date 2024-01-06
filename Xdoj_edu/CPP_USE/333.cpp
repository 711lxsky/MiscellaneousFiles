#include<iostream>
#include<string>
#include<queue>
using namespace std;
typedef struct{
	int mark;  //字符的ASCII码 
	int num;  //字符的个数
	queue<int> add;  //队列储存字符的位置
}Char;

Char da[62];

void init(){//初始化，放入0-9,A-Z,a-z; 
	int i;
	for(i = 0;i < 10;i++){
		da[i].mark = '0'+i;
		da[i].num = 0;
	}
	for(i = 10;i < 62;i++){
		da[i].mark = 'A'+i;
		da[i+26].mark = 'a'+i;
		da[i].num = da[i+26].num = 0;
	} 
}

int main(){
	init();
	string str;
	cin>>str; 
	int i,k;
	for(i = 0;i < str.size();i++){
		if(str[i] < 'A'){
			k = str[i] - '0';	
		} 
		else if(str[i] < 'a'){
			k = str[i] - 'A' + 10;
		}
		else if(str[i] > 'Z'){
			k = str[i] - 'a' + 36;
		}
		da[k].num++;
		da[k].add.push(i);
	}
	
	for(i = 0;i < str.size();i++){
		if(str[i] < 'A'){
			k = str[i] - '0';	
		} 
		else if(str[i] < 'a'){
			k = str[i] - 'A' + 10;
		}
		else if(str[i] > 'Z'){
			k = str[i] - 'a' + 36;
		}
		if(da[k].add.size() > 1){//当字符有重复时输出，输出后该字符的储存位置的队列清空了
			while(!da[k].add.empty() && da[k].add.size() > 1){
				cout<<str[i]<<':'<<da[k].add.front()<<',';
				da[k].add.pop();
			}
			cout<<str[i]<<':'<<da[k].add.front()<<endl;
			da[k].add.pop();
		}
	}
	return 0;
}