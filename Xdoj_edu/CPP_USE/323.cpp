//判断有向图中是否有环
//本质：拓扑排序
#include<stdio.h>
#include<queue>
#include<algorithm>
using namespace std;
#define MaxN 100  //最大顶点数
int n;  //顶点数
int G[MaxN][MaxN];  //邻接矩阵保存图
int InDegree[MaxN] = {0};  //保存顶点入度
void TopoSort();     //拓扑排序判断有向环

int main(){
    int num, i, j, flag;
    scanf("%d", &num);
    while(num--){   //多点输入：执行num次
        scanf("%d", &n);
        fill(InDegree,InDegree+MaxN,0);  //每次都要重置InDegree数组！
        for(i = 0; i < n; i++){   //输入图的邻接矩阵
            for(j = 0; j < n; j++){
                scanf("%d", &flag);
                G[i][j] = flag;
                if(flag != 0)
                   InDegree[j]++;
            }
        }
        TopoSort();  //拓扑排序
    }
}

void TopoSort(){
    queue<int> q;
    int u,v;
    int node = 0;
    for(u = 0; u < n; u++){  //将入度为0的顶点入队
        if(InDegree[u] == 0){
            q.push(u);
        }
    }
    while(!q.empty()){  //若队列非空
        u = q.front();
        q.pop();  //u出队
        for(v = 0; v < n; v ++){  //扫描u的邻接点
            if(G[u][v] != 0){
                InDegree[v]--;  //邻接点入度-1
                if(InDegree[v] == 0)  //若入度变为0，入队
                    q.push(v);
            }
        }
        node++;  //已完成拓扑排序的顶点数目+1
    }
    if(node == n) printf("0");  //拓扑排序成功：无有向环
    else         printf("1");   //拓扑排序失败：存在有向环
}
