#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// 归并排序的合并操作
void merge(int arr[], int left, int middle, int right) {
    int i, j, k;
    int n1 = middle - left + 1;
    int n2 = right - middle;

    // 创建临时数组
    int L[n1], R[n2];

    // 将数据复制到临时数组 L[] 和 R[]
    for (i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[middle + 1 + j];

    // 合并临时数组到 arr[left..right]
    i = 0; // 初始化左子数组的索引
    j = 0; // 初始化右子数组的索引
    k = left; // 初始化合并子数组的索引

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    // 将剩余的元素复制到 arr[]
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

// 归并排序的递归操作
void mergeSort(int arr[], int left, int right) {
    if (left < right) {
        int middle = left + (right - left) / 2;

        // 递归地排序左右子数组
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);

        // 合并排序后的子数组
        merge(arr, left, middle, right);
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

    // 对数组进行归并排序
    mergeSort(arr, 0, n - 1);

    end = clock();
    printf("归并排序所消耗的时间 %d 毫秒\n ", (int)(end - start));

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
