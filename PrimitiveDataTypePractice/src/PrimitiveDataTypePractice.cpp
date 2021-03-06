/*
 * PrimitiveDataTypePractice.cpp
 * this is a memo for practicing primitive data types
 * what I learn at here is : how many different primitive data types,
 *                           in particular, bool, char, short int, long int, long double
 *                           and their memory size definition. a function we can use is sizeof()
 *                           in case of primitive data types, once declared, the memory will be automatically
 *                           allocated.
 *
 *
 *
 * for C++ primitive data types, when we define a variable in one of these types, the system will automatically
 * allocate memory for it. These primitive data types are:
 * bool, 1 bit !!!!!
 * char, 1 byte
 * short int, 2 bytes
 * int, 4 bytes
 * float, 4 bytes
 * double, 8 bytes
 * void,
 * wchar_t, 2 or 4 bytes
 *
 * signed
 * unsigned
 * short
 * long
 *
 * double, 8 bytes, long double, 8 bytes
 *
 * short int, 2 bytes, signed short int, unsigned short int
 * int, 4 bytes, signed int, unsigned int
 * long int, 4 bytes, signed long int, unsigned long int
 *
 *
 *
 *
 *
 *
 *  Created on: Oct 4, 2015
 *      Author: Tao
 */
#include <iostream>
using namespace std;
int main(){

	bool BooleanA, BooleanB;
	char CharA, CharB;
	int NoahHasAnInteger, StevenHasAnInteger;
	//void NoValue; // note: in c++, we can define a variable as void, this is new to me, I wonder what size it is
	// it generates error, so it seems impossible to declare a variable in the type of void. or probably in a very
	// special situation, it can be used. I am not clear at this time. I might revisit this later.


	cout << endl << endl;
	cout << "size of boolean variable, defined by using bool is :   " << sizeof(BooleanA) << endl;
	// sizeof() function is a function defined in the std namespace. it returns the number of bytes taken by a variable
	// of certain data type. since
	CharA = 'N';// for all the single letters, we should use single quotes, like 'n', instead of ""
	CharB = 'o';
	cout << "look, here is the value in CharA : " << CharA << endl;
	cout << "look, look, here is the value in CharB : " << CharB << endl;
	CharA = CharB;
	cout << "look, look, now CharA's new value is :" << CharA << endl;
	cout << "size of char A is : " << sizeof(CharA) << endl;
	cout << " size of char B is : " << sizeof(CharB) << endl;

	BooleanB = true;
	cout <<"the value of boolean B is  : "<< BooleanB << endl;
	BooleanB = false;
	cout << "the value of boolean B is : " << BooleanB << endl;
	cout << " the size of Boolean B is : " << sizeof(BooleanB) << endl;

	NoahHasAnInteger = 1000;
	StevenHasAnInteger = 150;

	cout << "this is the value of the integer what Noah has : " << NoahHasAnInteger << endl;
	cout << "Steven has a different integer, which is :" << StevenHasAnInteger << endl;
	NoahHasAnInteger = StevenHasAnInteger;

	cout << "this is the value of the integer what Noah has : " << NoahHasAnInteger << endl;
	cout << " the size of NoahHasAnInteger is : " << sizeof(NoahHasAnInteger) << endl;
	cout << " the size of an double variable is : " << sizeof(double) << endl;
	cout << " the size of a int variable is :" << sizeof(int) << endl;
	cout << " the size of a short int variable is :" << sizeof(short int) << endl;
	cout << " the size of a long int variable is :" << sizeof(long int) << endl;
	cout << " the size of a long double variable is :" << sizeof(long double) << endl;

	// try to find out what size of void data variable is
	//cout << "the size of a void variable is :" << sizeof(void) << endl; // an error message shows I can use sizeof() for void
	//cout << " the size of a void variable, NoValue is : " << sizeof(NoValue) << endl;



	return 0;
}



