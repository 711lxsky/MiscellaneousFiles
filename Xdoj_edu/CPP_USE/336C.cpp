#include <stdio.h>
#include <string.h>
typedef struct Students
{
	char name[20];
	int age;
	int grade;
}St;
 
int main()
{
	int N;
	scanf("%d",&N);
	St stu[100],t;
	for(int i=0;i<N;i++)
	{
		scanf("%s%d%d",stu[i].name,&stu[i].age,&stu[i].grade);
	}
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N-i-1;j++)
		{
			if((stu[j].grade<stu[j+1].grade)||(stu[j].grade==stu[j+1].grade&&stu[j].name[0]>stu[j+1].name[0])||(stu[j].grade==stu[j+1].grade&&stu[j].name[0]==stu[j+1].name[0]&&stu[j].age>stu[j+1].age))
			{
				t=stu[j];
				stu[j]=stu[j+1];
				stu[j+1]=t;
			}
		}
	}
	for(int i=0;i<N;i++)
	{
		printf("%s %d %d\n",stu[i].name,stu[i].age,stu[i].grade);
	}
	return 0;
}