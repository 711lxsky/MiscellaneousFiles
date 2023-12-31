#include <iostream>

using namespace std;

int main()
{
    int n;
    int nums[112];
    int cnt = 0;
    cin >> n;
    for(int i = 0; i < n; i ++){
        cin >> nums[i];
    }
    for(int i = n - 1; i >= 0; i --){
        for(int j = 0; j < i; j ++){
            if(nums[j] > nums[j+1]){
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                cnt ++;
            }
        }
    }
    cout << cnt;
    return 0; 
}