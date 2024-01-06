//分组统计
//sort排序结构体数组，hash表缩短查找时间
#include<stdio.h>
#include<vector>
#include<algorithm>
using namespace std;
#define MaxN 10010
struct Node{
    int Data;
    int Group;
};
Node Elements[100];  //结构体数组，存储元素及其对应的组号
int Count[MaxN];     //hash表：1.记录所有出现的元素；2.记录每组各元素出现的次数
vector<int> All_Data;  //将hash中的元素转移到变长数组All_Data中避免多次遍历Count数组
void Divide(int n,int Max_Group);  //核心函数：划分组别并输出
bool cmp(Node x, Node y);  
/*对Elements进行排序时的比较函数：
1.先由组别从小到大；2.组别相同时按元素大小从小到大
*/
void Print_Result(int group_num);  //输出结果
vector<int> AllGroupNumber; //存储所有组的编号(组号不一定连续，如1、2、4)
int AllGroup[100];  //将AllGroupNumber复制到AllGroup好调用Sort排序
void Copy(); //复制函数
bool Find(int group); //寻找AllGroupNumber中是否已经有组号group

int main(){
    int m,n,i,data,group,Max_Group;
    scanf("%d", &m);
    while(m--){
        fill(Count, Count+MaxN, -1);  //Count数组初始化为-1
        scanf("%d", &n);
        for(i = 0; i < n; i++){  //输入数据
            scanf("%d", &data);
            Elements[i].Data = data;
            if(Count[data] == -1)
                Count[data]++;
        }
        for(i = 0; i < n; i++){  //输入组别
            scanf("%d", &group);
            Elements[i].Group = group;
            if(!Find(group))
                AllGroupNumber.push_back(group);  //AllGroupNumber记录所有输入的组号
        }
        for(i = 0; i < MaxN; i++){  //将所有输入元素由小到大输入All_Data
            if(Count[i] != -1)
                All_Data.push_back(i);  //All_Data记录所有输入的元素
        }
        Divide(n,Max_Group);  //调用核心函数
        All_Data.clear();   //清空All_Data
        AllGroupNumber.clear();  //清空AllGroupNumber
    }
}

void Divide(int n,int Max_Group){
    int group_num,data,index,i;
    sort(Elements, Elements+n, cmp);  //对Elements数组进行sort排序，用自定的cmp函数
    int size = AllGroupNumber.size();
    Copy();   //把AllGroupNumber的数据复制到AllGroup中（无法对vector调用sort）
    sort(AllGroup, AllGroup+size);  //对AllGroup进行sort排序，默认从小到大
    for(index = 0; index < size; index++){  //循环处理每一个组
        group_num = AllGroup[index];  //得到组号[已经从小到大有序]
        fill(Count, Count+MaxN, 0);   //重新初始化Count数组，为0
        for(i = 0; i < n; i++){       //统计Elements数组中第group组的各个元素的出现次数
            if(Elements[i].Group != group_num)
                continue;
            data = Elements[i].Data;
            Count[data] += 1;  //Count[data] = number表示元素data的出现次数是number
        }
        Print_Result(group_num);  //打印结果
    }
}

void Print_Result(int group_num){
    int i,count;
    printf("%d={", group_num);
    for(i = 0; i < All_Data.size(); i++){  //对于每一个输入的元素，打印出现次数
        count = Count[All_Data[i]];
        if(i == All_Data.size()-1)
            printf("%d=%d}\n", All_Data[i], count);
        else
            printf("%d=%d,", All_Data[i],count);
    }
}

bool cmp(Node x, Node y){  //Elements的比较函数
    if(x.Group != y.Group)  //先有组别从小到大
        return x.Group <= y.Group;
    else                   //组别相同时，按元素大小从小到大
        return x.Data <= y.Data;
}

bool Find(int group){  //判断AllGroupNumber中是否已经含有group
    int i,flag = 0;
    for(i = 0; i < AllGroupNumber.size(); i++){
        if(AllGroupNumber[i] == group)
            flag = 1;
    }
    return flag;
}
void Copy(){   //将AllGroupNumber中的元素复制到AllGroup
    int i,size;
    size = AllGroupNumber.size();
    for(i = 0; i < size; i++)
        AllGroup[i] = AllGroupNumber[i];
}
