#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool visit[32] = {false};
bool gra[32][32] = {false};
int t = 1;

void dfs(int, int);
int main()
{
    int n , m;
    cin >> n >> m;
    for(int i = 0; i < m; i ++){
        int x , y;
        cin >> x >> y;
        gra[x][y] = gra[y][x] = true;
    }
    int cnt = 0;
    vector<int> ans;
    for(int i = 1; i <= n; i ++){
        if(! visit[i]){
            t = 1;
            dfs(i, n);
            cnt ++;
            ans.push_back(t);
        }
    }
    cout << cnt << endl;
    sort(ans.begin(), ans.end());
    for(int num : ans){
        cout << num << ' ';
    }
    return 0;
}

void dfs(int i, int n)
{
    visit[i] = true;
    for (int j = 1; j <= n; j ++){
        if(gra[i][j]){
            if(! visit[j]){
                dfs(j, n);
                t ++;
            }
        }
    }
}