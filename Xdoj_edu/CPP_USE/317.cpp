#include <iostream>

using namespace std;

int main()
{
    int n;
    while(cin >> n && n){
        char tree[1002][1002] = {'\0'};
        int layer = 1, num = 1, index = 0;
        for(int i = 0 , j = 1; i < n ; i ++){
            char cur;
            cin >> cur;
            if(j <= num){
                tree[layer][j++] = cur;
            }
            if(j > num){
                layer++;
                num *= 2;
                j = 1;
            }
        }
        int des = 0;
        num = 1;
        cin >> des;
        if(des != 1) {
            for(int i = 1 ; i < des ; i ++){
                num *= 2;
            }
        }
        for(int i = 1 ; i <= num ;i ++){
            if(tree[des][i] != '\0')
            cout << tree[des][i] << ' ';
            else {
                cout << "EMPTY ";
            }
        }
        cout << endl;
    }
}