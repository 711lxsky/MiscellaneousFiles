#include<stdio.h>
#include<iostream>//c++代码
#include<queue>//c++封装好的队列
using namespace std;
typedef struct{
	int vexnum;
	int arcs[100][100];
}Graph;
int visited[100]={0};
int count=0;
int FirstAdjVex(Graph G,int v)
{
	int i;
	for(i=0;i<G.vexnum;i++)
	{
		if(G.arcs[v][i]==1&&visited[i]==0)
			return i;
	}
	return -1;
}
int NextAdjVex(Graph G,int v,int w)
{
	int i;
	for(i=w;i<G.vexnum;i++)
	{
		if(G.arcs[v][i]==1&&visited[i]==0)
			return i;
	}
	return -1;
}
void BFSTraverse(Graph G)
{
	int i=0;
	queue<int> q;
	for(i=0;i<G.vexnum;i++)
	{
		if(visited[i]==0)
		{
			count++;
			q.push(i);
			cout<<i+1<<' ';//输出cout
			visited[i]=1;
			while(!q.empty())
			{
				int v=q.front();
				q.pop();
				for(int w=FirstAdjVex(G,v);w>0;w=NextAdjVex(G,v,w))
				{
					if(visited[w]==0)
					{
						q.push(w);
						cout<<w+1<<' ';
						visited[w]=1;
					}
				
				}
			}
			
		}
	}
	
}
int main()
{
	Graph G;
	cin>>G.vexnum;//输入cin
	int i,j;
	for(i=0;i<G.vexnum;i++)
	{
		for(j=0;j<G.vexnum;j++)
			cin>>G.arcs[i][j];
	}
	BFSTraverse(G);
	cout<<endl<<count;
	
	return 0;
}
