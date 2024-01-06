//网络时延
//最短路径问题: Dijstra
#include<stdio.h>
#include<algorithm>
using namespace std;
#define MaxN 100  //最大顶点数
#define INF 10000
int N;  //顶点数
int G[MaxN][MaxN];  //邻接矩阵保存图G
int d[MaxN];  //d[u] = num：顶点u到起点的距离为num,初始化为INF
bool Vis[MaxN] = {false};  //Vis[i] == true：顶点i已被访问
int Dijstra(int s);  //Dijstra算法，输入起点s

int main(){
    int M,K,Min_Length;
    int i,j;
    int u,v,w;
    fill(G[0],G[0]+MaxN*MaxN,0);  //初始化图G
    scanf("%d%d%d",&M,&N,&K);   //读入图G的边
    for(i = 0; i < M; i++){
        scanf("%d%d%d",&u,&v,&w);
        G[u-1][v-1] = w;
    }
    Min_Length = Dijstra(K-1);  //调用Dijstra算法
    printf("%d", Min_Length);   //打印最短路径
}

int Dijstra(int s){
    fill(d,d+N,INF);
    d[s] = 0;
    int i,u,v,Min;
    for(i = 0; i < N; i++){  //循环N次
        u = -1, Min = INF;
        for(v = 0; v < N; v++){  //未访问 && 距离起点最近的点
            if(Vis[v] == false && d[v] < Min){
                u = v;
                Min = d[v];
            }
        }
        if(u == -1) return -1;   //不连通，返回-1
        Vis[u] = true;
        for(v = 0; v < N; v++){  //以u为中介点优化u未被访问的邻接点
            if(Vis[v] == false && G[u][v] != 0 && d[u]+G[u][v] < d[v])
                d[v] = d[u] + G[u][v];
        }
    }

    int Min_Length = -1;  //返回结果
    for(u = 0; u < N; u++){
        if(d[u] > Min_Length)
            Min_Length = d[u];
    }
    return Min_Length;
}
