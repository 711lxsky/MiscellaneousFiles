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
        if(records.find(str) != records.end()){
            cout << records.find(str) -> second << endl;
            records[str] = records.find(str) -> second + 1;
        }
        else {
            cout << 1 << endl;
            records[str] = 1;
        }
    }
    return 0;
}