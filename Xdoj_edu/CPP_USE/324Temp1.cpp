#include <iostream>
#include <queue>

using namespace std;

int n = 0;
bool map[101][101] = {false};
bool visit[101] = {false};

void bfs(int);

int main()
{
    cin >> n;
    for(int i = 0; i < n; i ++){
        for(int j = 0; j < n; j ++){
            cin >> map[i][j];
        }
    }
    int cnt = 0;
    for(int i = 0; i < n; i ++){
        if(! visit[i]){
            bfs(i);
            cnt ++;
        }
    }
    cout << endl << cnt ;

    return 0;
}

void bfs(int cur){
    cout << cur + 1 << ' ' ;
    visit[cur] = true;
    queue<int> relation;
    relation.push(cur);
    while(! relation.empty()){
        int start = relation.front();
        relation.pop();
        for(int i = 0; i < n; i ++){
            if(map[start][i] && !visit[i]){
                cout << i + 1 << ' ';
                visit[i] = true;
                relation.push(i);
            }
        }
    }
}