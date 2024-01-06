#include <iostream>

using namespace std;

int matrix[101][101];
bool visit[101] = {false};

void dfs(int, int);
int main()
{
    int n;
    cin >> n;
    for(int i = 0; i < n; i ++){
        for(int j = 0; j < n; j ++){
            cin >> matrix[i][j];
        }
    }
    int cnt = 0;
    for(int i = 0; i < n; i ++){
        if(! visit[i]){
            cnt ++;
            dfs(i, n);
        }
    }
    cout << endl << cnt ;
    return 0;
}

void dfs(int i, int n){
    visit[i] = true;
    cout << i + 1 << ' ';
    for(int j = 0; j < n; j ++){
        if(matrix[i][j] && ! visit[j]){
            dfs(j, n);
        }
    }
}