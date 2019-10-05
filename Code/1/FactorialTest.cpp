#include<iostream>
using namespace std;

int main(){
	int num[50]={0},nowPlus[50]={0},inNum,i,j,k,useSize;
	cin>>inNum;
	num[0]=inNum;
	useSize=0;
	for(i=inNum-1;i>1;i--){
		for(j=0;j<=useSize;j++){
			num[j]*=i;
			if(num[j]>10000){
				nowPlus[j+1]=num[j]/10000;
				num[j]%=10000;
				if(j+1>useSize)useSize++;
			}
		}
		for(j=0;j<=useSize;j++){
			num[j]+=nowPlus[j];
			nowPlus[j]=0;
		}
	}
	for(i=useSize;i>=0;i--){
		if(num[i]<1000&&num[i]>99&&i!=useSize)cout<<"0";
		else if(num[i]<100&&num[i]>9&&i!=useSize)cout<<"00";
		else if(num[i]==0)cout<<"000";
		cout<<num[i];
	}
	cout<<endl;
}
