/*
 * mysourcefilewithcppExtension.cpp
 * This is a memo file for showing how I solve the using namespace std error message issue.
 *  Created on: Oct 3, 2015
 *      Author: Tao
 */
// add include file
#include <iostream>
// add using namespace
using namespace std;
// the old error message still shows up at this moment
// I clicked the save under file drop down menu and then the error message disappeared.
// this is just double confirmed that the std error message is a temporary thing.
int main(){
	cout << "test, test"<<endl;
	return 0;
}
// up to here, so far so good. I save the file and then go to Project dropdown menu and select build all.
// an error message shows up that the main() function can't be void type, it must be int type and require a return value;
// then i change it to int type. the error message still persists, but after build all again, it disappeared.
// run the program and it runs pretty well. no more problems.





