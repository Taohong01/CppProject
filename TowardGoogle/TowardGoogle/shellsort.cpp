//
//  shellsort.cpp
//  TowardGoogle
//
//  Created by Tao on 2/25/17.
//  Copyright © 2017 Tao. All rights reserved.
//

#include "shellsort.hpp"
#include <iostream>
using namespace std;

void shellsort(double *arr, int N){

    int gap = N / 2;
    int j;
    double temp = NULL;
    while (gap > 0){
        for (int i = gap; i < N; i++){
            temp = arr[i];
            j = i;
            while (j - gap >= 0 && arr[j - gap] > temp){
                arr[j] = arr[j - gap];
                j -= gap;
                
            }
            arr[j] = temp;
        }
        gap = gap / 2;
    }
}

void quicksort(double *arr, int left, int right){
    double temp;
    int i = left, j = right;
    double pivot = arr[(left + right) / 2];
    
    while(i <= j){
        while(arr[i] <= pivot){
            i++;
        }
        while(arr[j] >= pivot){
            j--;
        }
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
    if(j > left){
        quicksort(arr, left, j);
    }
    if(i < right){
        quicksort(arr, i, right);
    }
}

void mergesort(){
    
}

void heapsort(){
    
}

//void binarytree{
    
//}

int main(){
    
    double a[10] = {1.0, 3.2, 0.5, 8.9, 0.9, 10.5, 11.5, 12, 53, 1};
    //shellsort(a, 10);
    quicksort(a, 0, 10);
    for (int i = 0; i < 10; i++){
        cout << a[i] << endl;
    
    
    
    }
    return 0;
}
