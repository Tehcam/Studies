#include<iostream>
using namespace std;

int main(){
    int somme = 0;
    int n = 0;
    cout << "votre nombre n=" <<endl;
    cin >> n;
    for(int i=0; i<=n; i++){
        somme += i;
    }
    cout << "la somme des n premiers entiers: " << somme;
}
