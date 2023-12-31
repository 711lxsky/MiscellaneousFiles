#include <iostream>

using namespace std;

bool visit[1001] = {false};
int arr[1001][1001];

void dfs(int i, int n);
int main()
{
    int n, m;
    cin >> n >> m;
    int x , y;
    for(int i = 0;i < m; i ++){
        cin >> x >> y;
        arr[x][y] = 1;
        arr[y][x] = 1;
    }   
    int cnt = 0;
    for(int i = 1; i <= n; i ++){
        if(! visit[i]){
            cnt ++;
            dfs(i, n);
        }
    }
    cout << cnt - 1 << endl;
    return 0;
}

void dfs(int i, int n){
    visit[i] = true;
    for(int j = 1; j <= n; j ++){
        if(arr[i][j]){
            if(! visit[j]){
                dfs(j, n);
            }
        }
    }
}