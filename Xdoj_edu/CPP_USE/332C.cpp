#include<stdio.h>
#define MAXSIZE 1000001 //最大结点数
typedef struct {   //结构体表示结点
    int val;     //结点值
    int lchild;  //结点左子树位置
    int rchild;  //结点右子树位置
}Node;
Node data[MAXSIZE];  //结构体数组表示树
int Judge( Node data);  //递归方法，判断是否为二叉排序树

int main (void) {
    int n, root, i, j, val_i, left_i, right_i, flag;
    scanf ("%d %d", &n, &root);  //输入结点数和根节点位置
    for (i = 1; i <= n; i++) {  //建立树
        scanf ("%d %d %d", &val_i, &left_i, &right_i);
        data[i].val = val_i;
        data[i].lchild = left_i;
        data[i].rchild = right_i;
    }
    flag = Judge (data[root]);  //调用Judge函数
    if (flag) {
        printf ("true\n");
    }
    else {
        printf ("false\n");
    }
    return 0;
}

int Judge(Node p) {
    if (p.lchild == 0 && p.rchild == 0) return 1;  //终止条件，到达叶子结点
    
    //判断当前结点是否满足排序树条件
    if (p.lchild != 0 && p.val <= data[p.lchild].val  //存在左子树且结点值小于左子树的值
        || p.rchild != 0 && p.val >= data[p.rchild].val) //存在右子树且结点值大于右子树的值
        return 0;  //若不满足，返回0
    else { //若满足：
       if(p.lchild != 0) return Judge(data[p.lchild]);  //递归判断左子树
       if(p.rchild != 0) return Judge(data[p.rchild]);  //递归判断右子树
    }
}

