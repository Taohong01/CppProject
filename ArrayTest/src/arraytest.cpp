/*
 * arraytest.cpp
 *
 *  Created on: Apr 23, 2016
 *      Author: Tao
 */
#include <string>
#include <iterator>
#include <iostream>
#include <algorithm>
#include <array>

using namespace std;
int main()
{
    int MyArray[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    array<int, 3> LittleArray;
    LittleArray[0] = 1;
    LittleArray[1] = 3;
    //{1, 2, 3};

    for(int i = 0; i < 10; i++){
    	cout << MyArray[i] << endl;
    	cout << LittleArray[1] << endl;
    };



    return 0;
}
