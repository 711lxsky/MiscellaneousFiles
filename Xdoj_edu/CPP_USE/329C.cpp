#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAXSIZE 100
//二叉排序树
typedef struct BiTNode{
	int data;
	struct BiTNode * lchild,*rchild;
}BiTNode,*BiTree;
//思路 通过前序遍历 和 中序遍历 确定一颗唯一的二叉排序树
int sum[MAXSIZE][3]={0};  //分别每个树存放先序遍历 和 中序遍历 的 值
int flag=0;
BiTree Insert(BiTree p,int i){
	//二叉排序树的建立
	if ( p==NULL ) {
		p = (BiTree)malloc(sizeof(BiTNode));
		p->data = i;
		p->lchild = p->rchild = NULL;
	} else if ( i>=p->data ) {
		p->rchild=Insert(p->rchild,i);
	} else {
		p->lchild=Insert(p->lchild,i);
	}
	return p;
}
 
void PreOrder(BiTree p,int i){
	if(p!=NULL){
		//先序遍历
		sum[i][1]=sum[i][1]*10+p->data;
		PreOrder(p->lchild,i);
		PreOrder(p->rchild,i);
	}
 
}
 
 
void MOrder(BiTree p,int i){
	if(p!=NULL){
		//中序遍历
		MOrder(p->lchild,i);
		sum[i][0]=sum[i][0]*10+p->data;
		MOrder(p->rchild,i);
	}
 
}
 
void IfSame(){
	int a,b;
	int i,j,k;
	int n;
	int count = 1;
	
	scanf("%d",&n); //n个需要判断
	if(n==0){
		flag++;
		exit(0);
	}
	n++;
	//将序列按字符串输入
	char end[2]="0";
	char numbers[MAXSIZE][10]={'\0'};
	scanf("%s",&numbers[0]);
	int len = strlen(numbers[0]);
	i=1;
	while(1){
		
		if(count==n){
			break;
		}
		scanf("%s",&numbers[i]);
		strcpy(numbers[count],numbers[i]);
		count++;
		i++;
	}
	//字符串转换为数字
	//	count--; //count wei bijiaode geshu
	int nums[MAXSIZE][10]={0};
	for(i=0;i<n;i++){
		for(j=0;j<len;j++){
			nums[i][j]=numbers[i][j]-'0';
		}
	}
	
	//二叉排序树的生成
	BiTree T[MAXSIZE]={NULL};
	for(i=1;i<=n;i++){
		for(j=0;j<len;j++){
			
			T[i]=Insert(T[i],nums[i-1][j]);
		}
		PreOrder(T[i],i);
		MOrder(T[i],i);
		
	}
	//比对
	for(i=2;i<=n;i++){
		
		
		if(sum[i][1]==sum[1][1]&&sum[i][0]==sum[1][0]){
			printf("YES\n");
		}
		else{
			printf("NO\n");
		}
		
		
	}
}
int main(){
	
	while(1){
		IfSame();
		if(flag!=0){
			exit(0);
		}
	}
	
	return 0;
}