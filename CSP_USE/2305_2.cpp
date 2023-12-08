#include <iostream>

using namespace std;

typedef long long LL;

#define N 10001
#define D 21

LL Q[N][D], K[N][D], V[N][D];
LL W[N];
LL temp[D][D] = {0};
LL res[N][D] = {0};

int main()
{
    int n, d;
    cin >> n >> d;
    for(int i = 0 ; i < n ; i ++){
        for(int j =0 ; j <d; j ++){
            cin >> Q[i][j];
        }
    }
    for(int i = 0; i < n; i ++){
        for(int j = 0; j < d; j ++){
            cin >> K[i][j];
        }
    }
    for(int i = 0 ; i < n; i ++){
        for(int j =0; j < d; j ++){
            cin >> V[i][j];
        }
    }
    for(int j = 0; j < n; j ++){
        cin >> W[j];
    }
    // 先算K^T * V
    for(int row = 0 ; row < d; row ++){
        for(int line = 0; line < d; line ++){
            for(int k = 0; k < n; k ++){
                temp[row][line] += K[k][row] * V[k][line];
            }
        }
    }
    // 再去乘矩阵Q
    for(int row = 0; row < n; row ++){
        for(int line = 0; line < d; line ++){
            for(int k = 0; k < d; k ++){
                res[row][line] += Q[row][k] * temp[k][line];
            }
        }
    }

    // 最后乘向量
    for(int row = 0; row <  n; row ++){
        for(int line = 0; line < d; line ++){
            res[row][line] *= W[row];
        }
    }

    for(int i = 0 ; i < n; i ++){
        for(int j = 0; j < d; j ++){
            cout << res[i][j] << ' ';
        }
        cout << endl;
    }
    return 0;
}