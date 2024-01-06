#include <iostream>

using namespace std;

int main()
{
    int n, m;
    cin >> m >> n;
    int nums1[101], nums2[101] ;
    for(int i = 0; i < m; i ++){
        cin >> nums1[i];
    }
    for(int j = 0; j < n; j ++){
        cin >> nums2[j];
    }
    int nums[202];
    int index1 = 0, index2 = 0, index = 0;
    while(index1 < m && index2 < n){
        if(nums1[index1] <= nums2[index2]){
            nums[index++] = nums1[index1++];
        }
        else {
            nums[index++] = nums2[index2++];
        }
    }
    if(index1 < m){
        while (index1 < m)
        {
            nums[index++] = nums1[index1++];
        }
    }
    if(index2 < n){
        while (index2 < n)
        {
            nums[index++] = nums2[index2++];
        }
    }
    for(int i = 0; i < index; i ++){
        cout << nums[i] << ' ';
    }
    return 0;
}