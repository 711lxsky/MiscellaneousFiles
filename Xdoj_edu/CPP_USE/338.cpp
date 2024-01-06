#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    int nums[101];
    for(int i = 0; i < n; i ++){
        cin >> nums[i];
    }
    int left = 0, right = n -1;
    int cmp = nums[0];
    while(left < right){
        while(left < right && nums[right] >= cmp){
            right --;
        }
        if(left < right){
            nums[left] = nums[right];
        }
        while (left < right && nums[left] < cmp)
        {
            left ++;
        }
        if(left < right){
            nums[right] = nums[left];
        }
    }
    nums[left] = cmp;
    for(int i = 0; i < n; i ++){
        cout << nums[i] << ' ';
    }
    return 0;
}