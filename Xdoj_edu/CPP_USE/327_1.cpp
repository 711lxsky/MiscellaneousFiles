#include<stdio.h>
int main()
{
	int n,i,j,k,num1,num2,top;
	int D[100][100],Path[100][100],Stack[100];
	/*D存储的是结点间最短路径长度
	Path存储的是最短路径中结点的前驱结点：比如1->3的最短路径是1 6 4 2 3，则Path[1][3]=2,Path[1]      [2]=4,Path[1][4]=6,Path[1][6]=1.
	Stack作为栈，便于输出最短路径  */
	top=-1;
	scanf("%d",&n);
	for(i=0;i<n;i++){//各对节点之间初始已知路径及距离
		for(j=0;j<n;j++)
		{
			scanf("%d",&D[i][j]);
			if(D[i][j]<1000)//从i到j之间有直接路径
			 Path[i][j]=i;
			else Path[i][j]=-1;
		}
	}
	for(k=0;k<n;k++)//加入结点k
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
			{
				if(D[i][j]>D[i][k]+D[k][j])//从i到k再到j的路径更短
				{
					D[i][j]=D[i][k]+D[k][j];//更新路径
					Path[i][j]=Path[k][j];//j的前驱结点改为k
				}
			}
	while(scanf("%d %d",&num1,&num2)!=EOF&&num1!=-1&&num2!=-1)
	{

		if(Path[num1][num2]==-1)//没有通路
		{
			printf("No");
			printf("\n");
		}
		else //有通路
		{
			printf("%d",D[num1][num2]);//输出路径长度
			printf("\n");
			j=num2;
			while(Path[num1][j]!=num1)//当j的前驱结点不等于起点时，即中间路径已经走完
			{
				top++;
				Stack[top]=Path[num1][j];//将数据存到栈里，因为是从终点到起点倒着走的
				j=Path[num1][j];
			}
			printf("%d ",num1);
			while(top!=-1)
			{
				printf("%d ",Stack[top]);//弹栈
				top--;
			}
			printf("%d\n",num2);
		}
	}
	return 0;
}
