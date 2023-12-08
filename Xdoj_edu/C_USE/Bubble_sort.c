#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // 交换元素位置
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
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
    // 对数组进行冒泡排序
    bubbleSort(arr, n);
    end = clock();
    printf("冒泡排序所消耗的时间 %d 毫秒\n ", (int)(end - start));
    // 打印排序后的数组
    printf("sorted array (Bubble Sort):\n");
    for (int i = 0; i < n; i++) {
        if(i % 25 == 0){
            printf("\n");
        }
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
