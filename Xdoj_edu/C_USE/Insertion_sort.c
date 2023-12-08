#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        // 移动元素直到找到适当的位置
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}

int main() {
    // 生成1000个随机数
    int n = 1000;
    int arr[n];
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000; // 在0到999之间生成随机数
    }

    // 打印原始数组
    printf("Original array:\n");
    for (int i = 0; i < n; i++) {
        if(i % 25 == 0){
            printf("\n");
        }
        printf("%d ", arr[i]);
    }
    printf("\n\n");

    clock_t start, end;
    start = clock();
    // 对数组进行插入排序
    insertionSort(arr, n);
    end = clock();
    printf("插入排序所消耗的时间 %d 毫秒\n ", (int)(end - start));
    // 打印排序后的数组
    printf("Sorted array (Insertion Sort):\n");
    for (int i = 0; i < n; i++) {
        if(i % 25 == 0){
            printf("\n");
        }
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
