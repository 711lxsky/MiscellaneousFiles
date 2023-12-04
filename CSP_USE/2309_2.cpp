// 不用保存上一次的计算结果，只需要对角度进行计算，最后算一下角度变换即可

#include <iostream>
#include <cmath>

#define PI 3.1415926

using namespace std;

int main()
{
    int n , m ;
    // 前伸缩，后角度
    double ope[100002][2] = {0};
    int type[100002] = {0};
    cin >> n >> m;
    for(int i = 0 ; i < n ; i ++){
        cin >> type[i];
        if(type[i] == 1){
            cin >> ope[i][0];
            ope[i][1] = 0.0;
        }
        else {
            cin >> ope[i][1];
            ope[i][0] = 1.0;
        }
    }
    for(int i = 1 ; i < n ; i ++){
        ope[i][0] *= ope[i-1][0];
        ope[i][1] += ope[i-1][1];
    }
    int i , j;
    double x , y;
    for(int k = 0 ; k < m ; k ++){
        cin >> i >> j >> x >> y;
        int left = i - 1, right = j - 1;
        double changeK, changeAngle;
        if(left == 0){
            changeK = ope[right][0];
            changeAngle = ope[right][1];
        }
        else {
            changeK = ope[right][0] / ope[left-1][0];
            changeAngle = ope[right][1] - ope[left-1][1];
        }
        //changeAngle /= PI;
        double tempX = x , tempY = y;
        x = tempX * changeK * cos(changeAngle) - tempY * changeK * sin(changeAngle);
        y = tempX * changeK * sin(changeAngle) + tempY * changeK * cos(changeAngle);
        printf("%.3lf %.3lf\n", x, y);
    }
    return 0;
}