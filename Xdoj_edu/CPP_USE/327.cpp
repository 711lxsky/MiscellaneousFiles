//求解关键路径长度
//只需要求关键路径长度，不需要打印关键路径
//所以只需要在TopoSort()上进行改进即可
#include<stdio.h>
#include<queue>
#include<algorithm>
using namespace std;
#define MaxN 100  //最大顶点数
int n;  //顶点数
int G[MaxN][MaxN];  //邻接矩阵保存图
int InDegree[MaxN] = {0}, Ve[MaxN];  //入度矩阵
//Ve数组：事件最早开始时间，初始化为0
int TopoSort();  //拓扑排序

int main(){
    int i,j,w;
    scanf("%d",&n);
    for(i = 0; i < n; i++){  //读入邻接矩阵
        for(j = 0; j < n; j++){
            scanf("%d",&w);
            G[i][j] = w;
            if(w) InDegree[j]++;  //j顶点入度+1
        }
    }
    int Path_Length = TopoSort();
    if(Path_Length == -1) printf("No");
    else printf("%d", Path_Length);
}

int TopoSort(){  //改动后的拓扑排序，返回关键路径长度
    fill(Ve,Ve+n,0);  //初始化Ve数组
    queue<int> q;
    int i,node;
    for(i = 0; i < n; i++){
        if(InDegree[i] == 0)
            q.push(i);
    }
    while(!q.empty()){
        int u = q.front();
        q.pop();
        for(i = 0; i < n; i++){
            if(G[u][i] != 0){
                InDegree[i]--;
                if(InDegree[i] == 0)
                    q.push(i);
                //更新Ve数组：在原TopoSort()基础上添加的部分
                if(Ve[u] + G[u][i] > Ve[i])
                    Ve[i] = Ve[u]+G[u][i];
            }
        }
        node++;
    }
    if(node !=n) return -1;  //存在有向环，拓扑排序失败
    else         return Ve[n-1];  //拓扑排序成功，返回关键路径长度
}

