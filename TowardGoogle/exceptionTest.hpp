//
//  exceptionTest.hpp
//  TowardGoogle
//
//  Created by Tao on 10/27/16.
//  Copyright © 2016 Tao. All rights reserved.
//

#ifndef exceptionTest_hpp
#define exceptionTest_hpp

#include <stdio.h>
#include <stdexcept>
using namespace std;

class DivideByZero: public runtime_error{
public:
    DivideByZero(): runtime_error("My own error message: Divided by zero!") {};
};


#endif /* exceptionTest_hpp */
