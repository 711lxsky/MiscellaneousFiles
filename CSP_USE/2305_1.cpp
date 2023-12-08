#include <iostream>
#include <map>

using namespace std;

int main()
{
    int n;
    cin >> n;
    map<string, int> records;
    for(int i = 0 ; i < n ; i ++){
        string str = "";
        for(int j = 0 ; j < 8; j ++){
            string cur;
            cin >> cur;
            str += cur;
        }
        auto findRes = records.find(str);
        if( findRes != records.end()){
            records[str] = records.find(str) -> second + 1;
            cout << records.find(str) -> second << endl;
        }
        else {
            cout << 1 << endl;
            records[str] = 1;
        }
    }
    return 0;
}