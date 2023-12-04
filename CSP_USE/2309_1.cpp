#include <iostream>

using namespace std;

int main()
{
    int n , m;
    cin >> n >> m;
    int dx = 0 , dy = 0;
    int curDx, curDy;
    for(int i = 0 ; i < n ; i ++){
        cin >> curDx >> curDy;
        dx += curDx;
        dy += curDy;
    }
    int x , y;
    for(int i = 0 ; i < m ; i ++){
        cin >> x >> y;
        cout << x + dx << ' ' << y + dy << endl;
    }
    return 0;
}