#include<stdio.h>
#include<stdlib.h>
int n;
int num[100];
typedef struct BiNode{
	int key;
	struct BiNode *lchild,*rchild;
}BiNode,*BiTree;

void Insert(BiTree &T,int i)
{
	if(!T){
		T = (BiTree)malloc(sizeof(BiNode));
		T->key = i;
		T->lchild = NULL;
		T->rchild = NULL;
	}
	else{
		if(i>T->key)  Insert(T->rchild,i);
		if(i<T->key)  Insert(T->lchild,i);
	}
}

void Create(BiTree &T){
	int i;
	for(i=1;i<=n;i++)
		Insert(T,num[i]);
}

void PreOrderTraverse(BiTree T)
{
	if(T!=NULL) {
	printf("%d ",T->key);
	PreOrderTraverse(T->lchild);
	PreOrderTraverse(T->rchild);
	}
}

void InOrderTraverse(BiTree T)
{
	if(T!=NULL) {
	
	InOrderTraverse(T->lchild);
	printf("%d ",T->key);
	InOrderTraverse(T->rchild);
	}
}

void PostOrderTraverse(BiTree T)
{
	if(T!=NULL) {
	
	PostOrderTraverse(T->lchild);
	PostOrderTraverse(T->rchild);
	printf("%d ",T->key);
	}
}


int main()
{
	int i;
	scanf("%d",&n);
	for(i=1;i<=n;i++)
		scanf("%d",&num[i]);
	BiTree T=NULL;
	Create(T);
	PreOrderTraverse(T);
	printf("\n");
	InOrderTraverse(T);
	printf("\n");
	PostOrderTraverse(T);
	return 0;
}
