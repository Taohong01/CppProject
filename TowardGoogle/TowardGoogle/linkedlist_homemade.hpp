//
//  linkedlist_homemade.hpp
//  TowardGoogle
//
//  Created by Tao on 10/18/16.
//  Copyright © 2016 Tao. All rights reserved.
//

#ifndef linkedlist_homemade_hpp
#define linkedlist_homemade_hpp

#include <iostream>
using namespace std;

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



#endif /* linkedlist_homemade_hpp */
