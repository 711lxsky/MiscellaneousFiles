#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void selectionSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int min_index = i;

        // 找到未排序部分的最小元素的索引
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min_index]) {
                min_index = j;
            }
        }

        // 交换最小元素与当前元素的位置
        int temp = arr[i];
        arr[i] = arr[min_index];
        arr[min_index] = temp;
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

    // 对数组进行选择排序
    selectionSort(arr, n);

    end = clock();
    printf("选择排序所消耗的时间 %d 毫秒\n ", (int)(end - start));

    // 打印排序后的数组
    printf("Sorted array (Selection Sort):\n");
    for (int i = 0; i < n; i++) {
        if(i % 25 == 0){
            printf("\n");
        }
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
