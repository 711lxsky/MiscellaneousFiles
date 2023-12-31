#include<iostream>
using namespace std;
int main()
{
	int a[105],m,p,i,j,k,flag=0;
	for(i=0;i<105;i++)
	a[i]=-1;
	cin>>m>>p;
	cin>>k;
	j=0;
	while(k!=-1)
	{
		i=k%p;
		if(a[i]!=k&&a[i]!=-1)
		{
			while(i<=m-1&&a[i]!=k)
				i++;
			if(a[i]==k)
			{
			cout<<i<<endl;
			flag=1;
			}
		}
		if(flag==1)
			{
			flag=0;
			cin>>k;
			continue;
		    }
		i=k%p;
		if(a[i]==k)
		{
		cout<<i<<endl;
	    }
		else
		{
			if(j==m-1)
			{
				cout<<"Table full"<<endl;
				break;
			}
			else
			{
				while(a[i]!=-1)
				i++;
				a[i]=k;
				cout<<i<<endl;
				j++;
			}
		}
		cin>>k;
	}
	
 } 
