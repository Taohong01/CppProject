/*
 * StructurePracitice.cpp
 * pratice the usage of struct in C++.
 *  Created on: Oct 4, 2015
 *      Author: Tao
 */
#include <iostream>
#define NULL 0
using namespace std;
// I should use template to define the value type of the node
// but for now I forget how to define a template, so I just temporarily use
// int type

struct SingleNode{
	int Value;
	SingleNode * NextNode; // note: here NextNode is actually a pointer, so when try to get the field of next node, we
					// should use ->
	//Value = NULL;// should I initialize the value in a struct? it seems at least I don't have to do it.
					// how to use NULL?
	//Value = 0;
	//*NextNode = NULL; //it seems any initialization produces error, so I probably shouldn't initialized them anyway.
	//I just recognize that in order to make the NextNode works as a pointer pointing to the next struct variable
	//I should recursively define it as SingleNode type instead of int type.

	//it seems to be possible to make a constructor for a structure to initialize the value of the structure
	SingleNode(){
		Value = 10;
		NextNode = NULL;
	}

};
// try to use struct SingleNode to define some new node variable as below:
//SingleNode NodeA, NodeB; // I saw an error in the beginning, but it turns out there was a typo in the SingleNode name
							// as we find out, defining two struct variables in a row just works fine.
//NodeA.Value = 0;
//NodeA.NextNode = &NodeB;




// I meet some error for the structure should use 'struct'!!!
// as soon as i change structure into struct, it turns into purple color, which means it is now the right key word name.
// but the error message persists until I rebuild all.
/**/




int main(){

	SingleNode NodeA, NodeB, NodeC, NodeD;
	cout << "the value of nodeA just after declaration is : "<< NodeA.Value << endl;
	// it shows that the constructor of struct SingleNode works. The constructor makes difference for the initial value of
	// the internal variable of the struct.

	NodeA.Value = 0;
	NodeA.NextNode = &NodeB;
	NodeB.Value = 1;
	NodeB.NextNode = &NodeC;
	NodeC.Value = 2;
	NodeA.NextNode->NextNode->NextNode = &NodeD;
	NodeA.NextNode->NextNode->NextNode->Value = 3;

	cout <<"The value of Node A is :" << NodeA.Value << endl;
	cout <<" The value of the next node of node A is : %d" << NodeA.NextNode->Value <<endl;
	cout <<"the value of the next node of next node of the next node of node A is :"<< NodeA.NextNode->NextNode->NextNode->Value <<endl;
	cout <<"the value of node D is :" << NodeD.Value<< endl;
	// the result shows that the assignment of the node B address to the node A next node pointer was successful.
	// the




	cout << "test"<< endl;
	cout << " this is really weird"<< endl;




	return 0;
}




