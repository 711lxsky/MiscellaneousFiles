#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// 堆排序的堆调整操作
void heapify(int arr[], int n, int i) {
    int largest = i; // 初始化根节点为最大值
    int left = 2 * i + 1; // 左子节点的索引
    int right = 2 * i + 2; // 右子节点的索引

    // 如果左子节点比根节点大，更新最大值索引
    if (left < n && arr[left] > arr[largest]) {
        largest = left;
    }

    // 如果右子节点比根节点大，更新最大值索引
    if (right < n && arr[right] > arr[largest]) {
        largest = right;
    }

    // 如果最大值不是根节点，交换根节点和最大值
    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;

        // 递归调整子树
        heapify(arr, n, largest);
    }
}

// 堆排序
void heapSort(int arr[], int n) {
    // 构建最大堆
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }

    // 逐个从堆中取出元素
    for (int i = n - 1; i > 0; i--) {
        // 将当前最大值（根节点）与数组末尾元素交换
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        // 重新调整堆，排除末尾的最大值
        heapify(arr, i, 0);
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

    // 对数组进行堆排序
    heapSort(arr, n);

    end = clock();
    printf("堆排序所消耗的时间 %d 毫秒\n ", (int)(end - start));

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
