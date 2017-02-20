//============================================================================
// Name        : HelloWorld.cpp
// Author      : Tao Hong
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <array>
using namespace std;

class Vector{
	/*define a generic vector and relevant operations.
	 * Author: Tao Hong
	 * Data: 8/30/2015
	 * Version: 1.0*/
public:
	double x, y, z;
	Vector(double xin, double yin, double zin){
		x = xin;
		y = yin;
		z = zin;
	}
	Vector(){
			x = 0;
			y = 0;
			z = 0;
	}


	Vector operator + (Vector Vecin){
		//Note the input argument Vecin can't be initialized using Vector Vecin();
		//I don't know why yet.
		Vector SumVec;// SumVec can't be initialized either. I don't know why.
		SumVec.x = x + Vecin.x;
		SumVec.y = y + Vecin.y;
		SumVec.z = z + Vecin.z;

		return SumVec;
	}

	Vector operator - (Vector Vecin){
		Vector SumVec;

		SumVec.x = x - Vecin.x;
		SumVec.y = y - Vecin.y;
		SumVec.z = z - Vecin.z;
		return SumVec;
	}


	~Vector(){
		cout << "A Vector Instance is deleted." << endl;
	}

};




class CartisianCoordinates{
	double x, y, z;

};
class Atom{
	double atomMass;
	int atomicNumber;

};
/* Define a Node classes
 * Author: Tao Hong
 * plan for next: add a template for the type definition of the node value
 * so that it can be more flexible for future application
 */
class Node{

private:
	double _value;
	Node *_subNode;

public:
	Node(void) : _subNode(NULL) {
		_value = NULL;
	}//constructor without any input argument
	Node(double inputValue, Node *psubNode){
		_value = inputValue;
		_subNode = psubNode;
	}//constructor with an input value and an input subNode
	Node(double inputValue){
		_value = inputValue;
		_subNode = NULL;
	}//constructor with an input value
	double getValue(void){
		return _value;
	}//get the node value as a return
	void setValue(double inputValue){
		_value = inputValue;
	}// set the node value with an input
	void addNode(Node *subNode){
		_subNode = subNode;
	}//attache a subnode to the node
	Node* getSubNode(void){
		return _subNode;
	}
	~Node(){
		cout << "node instance with value," << _value << ", is deleted." << endl;
	}

};

/* Define a linked list class based on the Node class
 * Author: Tao Hong
 *
 */
class LinkedList{
private:
	int _Length = 0;
	Node *Node0;
public:
	LinkedList(int LengthofList){
		_Length = LengthofList;
		//Node;

	}

};

int main() {

	/*Node testing
	 * Author: Tao Hong
	 */
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

	cout << "This is the end of this program." << endl;
	return 0;
}
