//
//  vector_homemade.hpp
//  TowardGoogle
//
//  Created by Tao on 10/18/16.
//  Copyright © 2016 Tao. All rights reserved.
//

#ifndef vector_homemade_hpp
#define vector_homemade_hpp

#include <iostream>
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





#endif /* vector_homemade_hpp */
