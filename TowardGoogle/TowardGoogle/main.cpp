//
//  main.cpp
//  TowardGoogle
//
//  Created by Tao on 10/18/16.
//  Copyright © 2016 Tao. All rights reserved.
//
//============================================================================
// Name        : HelloWorld.cpp
// Author      : Tao Hong
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <array>
//#include "vector_homemade.hpp"
#include "linkedlist_homemade.hpp"
#include <stdexcept>
#include "exceptionTest.hpp"
#include <vector>
#include <map>
#include <iostream>
#include <cassert>

using namespace std;


class CartisianCoordinates{
public:
    double x, y, z;
    CartisianCoordinates(double x, double y, double z);
    ~CartisianCoordinates(){};
    
};
class Atom{
    double atomMass;
    int atomicNumber;
    
};

void merge(int arr[], int size, int low, int middle, int high){
    int temp[size];
    for(int i = low; i <= high; ++i) {
        temp[i] = arr[i];
        
    }
    int i = low;
    int j = middle + 1;
    int k = low;
    
    while (i <= middle && j <= high) {
        if (temp[i] <= temp[j]){
            arr[k] = temp[i];
            ++i;
        }
        else {
            arr[k] = temp[j];
            ++j;
        }
        ++k;
    }
    while (i <= middle) {
        arr[k] = temp[i];
        ++k;
        ++i;
    }
}

void mergeSort(int arr[], int size, int low, int high){
    if (low < high){
        int middle = (low + high) / 2;
        mergeSort(arr, size, low, middle);
        mergeSort(arr, size, middle+1, high);
        merge(arr, size, low, middle, high);
    }
}


void tryThrowCaptureTest() {
    
    const int DividByZero = 1;
    
    int a = 100;
    int b = 0;
    
    try{
        if ( b==0 ){
            throw DividByZero;
            
        }else{
            cout << a/b << endl;
        }
    }
    catch(int e){
        if ( e == 1){
                cout << " can't divided by zero" << endl;
            }
            
    }
    
}


double quotient(double numerator, double denominator){
    if (denominator == 0){
        throw DivideByZero();
        
    }
    else{
        return numerator / denominator;
    }
}



//insertion sort
void swap(double* A, double* B){
    double temp;
    temp = *A;
    *A = *B;
    *B = temp;
    
}


void insertSort( double Arr[], int Size ){
    double x;
    int j;

    for (int i = 1; i < Size ; i++){
        j=i-1;
        x = Arr[i];
        while (j >=0 && Arr[j] > x){
            swap(Arr+j, Arr+j+1);
            j--;
        }
        Arr[j+1] = x;
        
    }
    
}



//quickSort(): pivot, a[low], a[low+1], ...., a[high-1], a[high]
int getPivot(double Arr[], int low, int high){
    double pivot = Arr[(low + high) / 2];
    int i = low;
    int j = high;
    
    while(i <= j) {
        while ( Arr[i] < pivot ) {
            //double Arr1[8] = {1.0, .05, 2.3, .8, 8.3, 1.35, 2.5, 2.3 };

            i++;
            cout << i << " " << Arr[i] << " pivot = "<< pivot << " :  ";
        
        };
        cout << endl;
    
       while ( Arr[j] > pivot ) {
            j--;
            cout << j << " " << Arr[j] << "  pivot = "<< pivot << " :  ";
       };//while(Arr[j] >= pivot);
        cout << endl;
        if ( i <= j ) {
            swap(Arr+i, Arr+j);
            i++;
            j--;
            cout << "----" <<endl;
        }
    };//while(i<j);
    cout << "out" << endl;
    swap(Arr[i], Arr[low]);
    return i;
}
void quickSort(double Arr[], int low, int high){
     cout << "enter" << endl;
    for (int i = low; i <= high; i++){
        cout << Arr[i] << " ";
    }
    cout << endl;
    
    int pivot_i;
    if (low < high){
        pivot_i = getPivot(Arr, low, high);
        cout << pivot_i << endl;
        if (low < pivot_i){
        quickSort(Arr, low, pivot_i-1);
        }
        if (pivot_i < high){
        quickSort(Arr, pivot_i+1, high);
        }
    }

    
}

void quickSort2(double arr[], int left, int right) {
    int i = left, j = right;
    double tmp;
    double pivot = arr[(left + right) / 2];
    
    /* partition */
    while (i <= j) {
        while (arr[i] < pivot)
            i++;
        while (arr[j] > pivot)
            j--;
        if (i <= j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    };
    
    /* recursion */
    if (left < j)
        quickSort2(arr, left, j);
    if (i < right)
        quickSort2(arr, i, right);
}

//merge sort

//heap sort

//bubble sort

//find maximum or find minimum

//find median

//find the k-th largest element

//shell sort


// what I learned today is about quick find, quick union, and weighted quick union

void quickFind(){
    //assuming we have an array of numbers, and we have some union functions to join
    // these numbers together, two a time. and then we want to find out blocks of
    // these numbers. Say, if we are given two numbers, we need a way to find out
    // if these two numbers belong a same block or not.
    //int a[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    
}

class node{
private:
    
    int label = NULL;
    node *rootp = nullptr;
    node **subp = nullptr;
    int numSubp = 0;
    
public:

    node(int label){
        this->label = label;
    }
    void set_lable(int label){
        this->label = label;
    }
    int get_label(){
        return this->label;
    }
    
    void set_rootp(node * rootp){
        this->rootp = rootp;
    }
    node* get_rootp(){
        return this->rootp;
    }
    
    void set_subp(node* subp){
        if (this->subp == NULL){
            this->subp = new node*;
        }
        this->subp[this->numSubp] = subp;
        this->numSubp += 1;
        
    }
    
    node** get_subp(){
        node** pp = nullptr;
        if (this->subp != nullptr){
            pp = this->subp;
            return pp;
        }
        return pp;
    }
    
    int get_numSubp(){
        return this->numSubp;
    }
    
    void unionWith(node *nodeBp){
        if (this->get_label() < nodeBp->get_label()){
            nodeBp->set_rootp(this);
            this->set_subp(nodeBp);
        }
        else{
            this->set_rootp(nodeBp);
            nodeBp->set_subp(this);
        }
    }
    
    ~node(){
    }
    
};


int main() {
    
    node **Nodepp;
    Nodepp = new node*;
    int a[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (int i = 0; i < 10; i++){
        cout << a[i];
        cout << endl;
        Nodepp[i] = new node(a[i]);
        cout << Nodepp[i]->get_label() << "<-Node label" << endl;
    }

    cout << "start union" << endl;
    Nodepp[2]->unionWith(Nodepp[3]);
    cout << "one union is successful" << endl;
    Nodepp[4]->unionWith(Nodepp[1]);
    cout << "2nd union is successful" << endl;
    Nodepp[8]->unionWith(Nodepp[1]);
    //cout << endl;
    //cout << endl;
    cout << "      " << endl;
    
    
    
    for (int i = 0; i < 10; i++){
        cout << Nodepp[i]->get_label() << endl;
        if (Nodepp[i]->get_rootp() != NULL){
            cout << "tada: "<<Nodepp[i]->get_rootp()->get_label() << endl;
        }
        cout << Nodepp[i]->get_numSubp() << endl;
    }
    
    for (int i = 0; i < 10; i++){
        delete [] Nodepp[i];
        
    }
    //delete [] Nodepp;
    
    
    
    
    
    std::map<std::string, int> m; // map<std::string, int> Map, then Map["string"] = intvalue
    m["hello"] = 23;
    //m["world"] = 40;
    
    cout << m["hello"] << " ";// << m["world"] <<endl;
    
    
    // check if key is present
    if (m.find("world") != m.end())
        std::cout << "map contains key world!\n";
    // retrieve
    std::cout << m["hello"] << '\n';
    std::map<std::string, int>::iterator i = m.find("hello");
    assert(i != m.end());
    std::cout << "Key: " << i->first << " Value: " << i->second << '\n';
    
    
    
    
    double Arr1[8] = {0.8, .05, 2.3, .8, 8.3, 1.35, 2.5, 0.8 };
    int Arr2[8] = {1, 5, 2, 8, 8, 1, 2, 2};
    
    //insertSort(Arr1, 8);
    quickSort2(Arr1, 0, 8-1);
    cout << " this is final result" << endl;
    for (int i = 0; i < 8; i++){
        cout << Arr1[i] << endl;
    }
    
    tryThrowCaptureTest();
    
    double x;
    try{
        x = quotient(10.1, 0.0);
    }
    catch(DivideByZero &except){
        
        cout << except.what() << endl;
        
    }
    cout << x << endl;
    
    cout << "This is a test of the merge sort algorithm" << endl;
    const int size = 10;
    int numbers[] = {5, 10, 1, 5, 2, 4, 2, 3, 2,5};
    cout << "original array :" << endl;
    for (int i = 0; i < size; i++){
        cout << numbers[i] << ' ';
    }
    cout << endl;
    
    mergeSort(numbers, size, 0, 9);
    cout << "after sorting, it becomes: " << endl;

    for (int i = 0; i < size; ++i) {
        cout << numbers[i] << " ";
    
    }
    cout << endl;
    cout << "As we have seen, it works very well." << endl;
    
    /*Node testing
     * Author: Tao Hong
     */
/*
    Node testNode(1.0);
    Node testNode2(2.0, &testNode);
    cout << testNode.getValue() << endl;
    cout << testNode2.getValue() << endl;
    
    
    
    //Example, how to initialize class instances.
    // note only when the defined class instance is a pointer,
    // we use vecPointer = new Vector(); for initialization;
    
    Vector Vec1(1.0, 2.0, 3.0);
    Vector Vec2(2.0, 2.5, 3.5);
    Vector Vec3(3.0, 2.5, 1.5);
    //Vector Vec4(), Vec5();
    Vec1.x = 5.0;
    array<Vector, 3> VecArray;
    VecArray[0] = Vec1;
    VecArray[2] = Vec3;
    
    Vector Vec4, Vec5;
    Vec4 = Vec1 + Vec2;
    Vec5 = Vec1 - Vec2;
    
    Vec5.x = 50;
    
    cout << Vec4.y << endl;
    cout << Vec5.x << endl;
    
    for (int i=0;i<10;i++){
        cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
    }
    
    int j=0;
    
    do{
        cout << 10-j << endl;
        j++;
        
    }while(10-j>0);
    j=0;
    while(10-j >0){
        cout << j * 2 << endl;
        j++;
    }
    double myarray[10][10];
    for (int i=0; i<10; i++){
        for (int j=0; j<10; j++){
            myarray[i][j] = i+j;
            
        }
    }
    
    
    
    for(int i=0; i<10; i++){
        for(int j=0; j<10; j++){
            cout << "new" << endl;
            cout << myarray[i][j] << endl;
        }
    }
    
    for(int i=0; i<3; i++){
        cout << "VecArray.z is ";
        cout << VecArray[i].z << endl;
    }
*/
    
    vector<double> vec;
    vector<CartisianCoordinates> coordinates;
    for (int i = 0; i < 10; i++){
        //coordinates = new CartisianCoordinates(i*0.1, i+0.2; i/0.2);
        //coordinates[i].x = i * 0.5;
        vec.push_back(i * 0.3);
    }
    
    for (int i = 0; i < vec.size(); i++){
        cout << vec[i]<< endl;
    }
    cout << "This is the end of this program." << endl;
    
    
    return 0;
}