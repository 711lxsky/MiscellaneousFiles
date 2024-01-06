#include<stdio.h>
#include<stdlib.h>
int n,num[100];
typedef struct BiTNode{
	int data;
	struct BiTNode *lchild,*rchild;
}BiTNode,*BiTree;
void Insert(BiTree &T,int i)
{
	//插入节点必为叶子节点
	if(!T)//创建节点
	{
		T=(BiTree)malloc(sizeof(BiTNode));
		T->data=i;
		T->lchild=NULL;
		T->rchild=NULL;
	}
	//如果节点已经存在，根据i值与节点值的大小判断插入左/右子树
	else if(T->data>i)
		Insert(T->lchild,i);
	else if(T->data<i)
		Insert(T->rchild,i);
}
BiTree Create()
{
	int i=1;
	BiTree T=NULL;
	while(i<=n)
	{
		Insert(T,num[i]);//依次插入
		i++;
	}
	return T;
}
int Search(BiTree &T,int i)
{
	if(T&&(T->lchild||T->rchild))//节点存在且不为叶子节点
	{
		if(i<T->data)//去左子树搜索
		{
			if(T->lchild->data==i)//等于T左孩子
				return T->data;
			else return Search(T->lchild,i);
		}
		if(i>T->data)//去右子树搜索
		{
			if(T->rchild->data==i)
				return T->data;
			else return Search(T->rchild,i);
		}
		else return -1;//根节点的情况
		
	}
	else
		return -1;
}
int main()
{
	int i;
	scanf("%d",&n);
	for(i=1;i<=n;i++)
		scanf("%d",&num[i]);
	BiTree T=Create();//创建二叉排序树
	BiTree B=T;
	for(i=1;i<=n;i++)
		printf("%d\n",Search(T,num[i]));//输出父节点
	return 0;
}
