//
//  main.cpp
//  sorting
//
//  Created by Tao on 2/25/17.
//  Copyright © 2017 Tao. All rights reserved.
//

#include <iostream>

//
//  shellsort.cpp
//  TowardGoogle
//
//  Created by Tao on 2/25/17.
//  Copyright © 2017 Tao. All rights reserved.
//

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
        while(arr[i] < pivot){
            i++;
        }
        while(arr[j] > pivot){
            j--;
        }
        if(i <= j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    if(j > left){
        quicksort(arr, left, j);
    }
    if(i < right){
        quicksort(arr, i, right);
    }
}

void merge(double *arr, int left, int middle, int right){
    int i = left, j = middle + 1, k = 0;
    double *temp = new double[right-left+1];
    
    while(i <= middle && j <= right){
        if(arr[i] < arr[j]){
            
            temp[k] = arr[i];
            i++;
            k++;
        }
        else{
            temp[k] = arr[j];
            j++;
            k++;
        }

    }
    while(i <= middle){
        temp[k] = arr[i];
        i++;
        k++;
    }
    while(j <= right){
        temp[k] = arr[j];
        j++;
        k++;
    }
    k = 0;
    for(int i = left; i <= right; i++){
        arr[i] = temp[k];
        k++;
    }
    return;
}
void mergesort(double *arr, int left, int right){
    int middle = (left + right) / 2;
    if(left < right){
        mergesort(arr, left, middle);
        mergesort(arr, middle+1, right);
        merge(arr, left, middle, right);
    }
    return;
    
}

void heapfy(double *arr, int size){
        //todo: build up relationship between an array and node nuber in a binary tree
    int N;//start from array index 1
    int left = 2 * N, right = 2 * N + 1;

}
void heapsort(){
    
}


#include <vector>
//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
//For example, Given input array A = [1,1,2],
//Your function should return length = 2, and A is now [1,2].
class removeDuplicatesSolution{
public:
    //you have an array in form of vectors
    int removeDuplicates(vector<int>& nums){
        if(nums.empty()){
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.size(); i++){
            if(nums[index] != nums[i]){
                nums[++index] = nums[i];
                
            }
        }
        return index + 1;
    }
    
};

void removeDuplicatesSolutionTest(){
    vector<int> Vec(10);
    Vec = {1, 2, 5, 5, 7, 7, 7, 8, 9, 9, 9, 9};
    removeDuplicatesSolution rD;
    int endIndex = rD.removeDuplicates(Vec);
    
    for (int i = 0; i < endIndex; i++){
        cout << Vec[i] << endl;
    }
}

//Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice? For example, Given sorted array A = [1,1,1,2,2,3],
//Your function should return length = 5, and A is now [1,1,2,2,3]
class removeDuplicatesIISolution{
public:
    int removeDuplicates(vector<int> & nums){
        if(nums.size() < 2){
            return nums.size();
        }
        int index = 0;
        int count = 0;
        for (int i = 1; i < nums.size(); i++){
            if (nums[index] == nums[i]){
                if (count < 1){
                    nums[++index] = nums[i];
                    count++;
                }
            }
            else{
                nums[++index] = nums[i];
                count = 0;
            }
        
        }
        return index + 1;
    }
};

void removeDuplicatesIISolutionTest(){
    vector<int> Vec(10);
    Vec = {1, 2, 5, 5, 7, 7, 7, 8, 9, 9};
    removeDuplicatesIISolution rD;
    int endIndex = rD.removeDuplicates(Vec);
    
    for (int i = 0; i < endIndex; i++){
        cout << Vec[i] << endl;
    }
}



//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no duplicate exists in the array.

class searchRotateArraySolution{
//public:
//    int searchRotateArray(vector<int> &nums){
//        if (nums.size()>0){
//            return 0;
//        }
//        int left = 0, right = nums.size();
//        int mid;
//        while (left != right){
//            mid = (left + right)/2;
//        }
//    }
    
    
public:
    bool search(const vector<int>& nums, int target) {
        int first = 0;
        int last = nums.size();
        while (first != last) {
            const int mid = first  + (last - first) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[first] < nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else if (nums[first] > nums[mid]) {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            } else
                //skip duplicate one
                first++;
        }
        return false;
    }

    
};

void searchRotateArraySolutionTest(){
    vector<int> vec = {5, 7, 8, 9, 12, 34, 1, 2, 2, 4, 5};
    searchRotateArraySolution sRA;
    cout << "---- "<< endl;
    cout << sRA.search(vec, 9) << endl;
}

#include <map>

void testMap(){
    map<int, int> mytestmap;
    mytestmap.insert(pair<int, int>(1, 5));
    mytestmap.insert(pair<int, int>(2, 8));
    cout << mytestmap[2] << endl;
    
}


// assuming we have an array of numbers and we want to find out
//sum of 2 numbers give a target value.
//void findPairGivenTarget(){
//    int arr[8] = {1, 3, 4, 5, 8, 2, 4, 5};
//    map<int, int> mapvalue2index;
//    for (int i = 0; i < 8; i++){
//        mapvalue2index.insert(pair<>)
//    }
//    mapvalue
//}
#include <unordered_map>
class Solution{
public:
    vector<int> twoSum(vector<int> &nums, int target){
        unordered_map<int, int> mapping;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++){
            mapping[nums[i]] = i;
        }
        for (int i = 0; i < nums.size(); i++){
            const int gap = target - nums[i];
            if (mapping.find(gap) != mapping.end() && mapping[gap] > i){
                result.push_back(i + 1);
                result.push_back(mapping[gap] + 1);
                break;
            }
        }
        return result;
    }
    
};



class SolutionFor2Sum{
public:
    vector<int> twoSum(vector<int> &nums, int target){
        unordered_map<int, int> mapping;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++){
            mapping[nums[i]] = i;
        }
        for (int i = 0; i < nums.size(); i++){
            int gap = target - nums[i];
            if (mapping.find(gap) != mapping.end() && mapping[gap] > i){
                result.push_back(i+1);
                result.push_back(mapping[gap]+1);
            }
        }
        return result;
    }
    
    int Bsearch(vector<int> &nums, int key, int start){
        int L = start;
        int R = nums.size() - 1;
        //cout << R << endl;
        if (key > nums[R] || key < nums[L]){
            return 0;
        }
        while (L < R){
            int M = (L + R) / 2;
            if (nums[M] < key){
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (L == R && nums[L] == key) ? L : -1;
    }
    
    vector<int> twoSumViaBsearch(vector<int> nums, int target){
        vector<int> result;
        for (int i = 0; i < nums.size(); i++){
            int j = bsearch(nums, target - nums[i], i + 1);
            if (j != -1){
                
                result.push_back(i + 1);
                result.push_back(j + 1);
                
            }
        }
        return result;
    }
    
// using two pointers:
    vector<int> twoSum2Pointers(vector<int> &nums, int target){
        int i = 0, j = nums.size() - 1;
        vector<int> result;
        while (i < j){
            int sum = nums[i] + nums[j];
            if (sum < target){
                i++;
            }else if (sum > target){
                j--;
            }else{
                result.push_back(i + 1);
                result.push_back(j + 1);
                break;
                //cout << " done" << endl;
            }
        }
        return result;
    }
    
// assuming an array is sorted in ascending order
// and how to find a target value using a binary search:
private:
    int bsearch(vector<int> &nums, int key, int start){
        int L = start, R = nums.size() - 1;
        while (L < R){
            int M = (L + R) / 2;
            if (nums[M] < key) {
                L = M + 1;
            } else{
                R = M;
            }
        }
        return (L == R && nums[L] == key) ? L : -1;
    }
    
};

void testSolutionFor2Sum(){
    vector<int> arr = {1, 3, 4, 5, 8, 2, 4, 5};
    vector<int> result;
    SolutionFor2Sum twoSum;
    
    result = twoSum.twoSum(arr, 13);
    cout << "first element: "<< result[0] << " second element: " << result[1] << endl;
    
    cout << twoSum.Bsearch(arr, 5, 0) << endl;
    arr = {1, 3, 4, 8, 9, 20, 34, 35};
    result = twoSum.twoSum2Pointers(arr, 28);
    cout << "result 0: " << result[0] << endl;
    cout << "result 1: " << result[1] << endl;
    
}





int main(int argc, const char * argv[]){
    
    double a[10] = {1.0, 3.2, 0.5, 8.9, 0.9, 10.5, 11.5, 12, 53, 1};
    //shellsort(a, 10);
    //quicksort(a, 0, 9);
    mergesort(a, 0, 9);
    for (int i = 0; i < 10; i++){
        cout << a[i] << endl;
        
    }
    cout << endl;
    cout << endl;
    

    
    //removeDuplicatesSolutionTest();
    //removeDuplicatesIISolutionTest();
    //searchRotateArraySolutionTest();
    //testMap();
    testSolutionFor2Sum();
        
    return 0;
}

