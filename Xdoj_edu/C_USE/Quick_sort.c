#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// 快速排序的划分操作
int partition(int arr[], int low, int high) {
    int pivot = arr[high]; // 选择最后一个元素作为基准
    int i = (low - 1); // 初始化小于等于基准的元素的索引

    for (int j = low; j <= high - 1; j++) {
        // 如果当前元素小于等于基准，交换arr[i+1]和arr[j]
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // 将基准元素arr[high]放到正确的位置arr[i+1]，并返回该位置
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
}

// 快速排序
void quickSort(int arr[], int low, int high) {
    if (low < high) {
        // 划分操作，获取基准的索引
        int pi = partition(arr, low, high);

        // 递归地对基准左右两侧进行排序
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
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

    // 对数组进行快速排序
    quickSort(arr, 0, n - 1);

    end = clock();
    printf("快排所消耗的时间 %d 毫秒\n ", (int)(end - start));

    // 打印排序后的数组
    printf("Sorted array:\n");
    for (int i = 0; i < n; i++) {
        if(i % 25 == 0){
            printf("\n");
        }
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
