#include<stdio.h>
#include<iostream>
using namespace std;
typedef struct SqList{
	int length;
	int r[100];
}SqList;
void InsertSort(SqList &L)
{
	int i,j,k;
	for(i=2;i<=4;i++)
	{
		if(L.r[i]<L.r[i-1])
		{
			L.r[0]=L.r[i];
			L.r[i]=L.r[i-1];
			for(j=i-2;L.r[0]<L.r[j];j--)
				L.r[j+1]=L.r[j];
			L.r[j+1]=L.r[0];
		}
		for(k=0;k<L.length;k++)
		{
			cout<<L.r[k+1]<<' ';
		}
		cout<<endl;
	}
}
int main()
{
	SqList L;
	cin>>L.length;
	int i,j,k;
	for(i=0;i<L.length;i++)
	{
		cin>>L.r[i+1];
	}
	InsertSort(L);

	return 0;
}
