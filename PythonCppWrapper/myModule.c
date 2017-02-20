#include <Python.h>
#include <math.h> 
#include <stdio.h>
#include <iostream>
// this is a demo showing how to write a c or c++ code and then
// use "python setup.py install" to compile and link the code
// build it as a module
// then how to use "python test.py" to import the module and
// run python commands
// call functions coded in c or cpp.
using namespace std;

class myNewClass{
 public:
  double i;
  myNewClass(){
    printf("instantiate myNewClass");
  }
  double myfuction(double x){
    this->i = x * x * x; 
    return this->i;
  }

  ~myNewClass(){
  }
}

double MyCSin(double x)
{ printf("this is a print to stdout test from c code: %f", cos(x));
  return sin(x);
}

double MyCard(double x)
{
  double result;
  printf("this is my new function called MyCard");
  myNewClass *newclass;
  newclass = new myNewClass();
  result = newclass.myfunction(5.5);
  printf("this is a new result produced by the new class method: %d", result);


  return x * x;
}

int Cfib(int n)
{
  if (n < 2)
    return 100;
  else
    return Cfib(n-1) + Cfib(n-2);
}
 
static PyObject* fib(PyObject* self, PyObject* args)
{
  int n;
 
  if (!PyArg_ParseTuple(args, "i", &n))
    return NULL;
 
  return Py_BuildValue("i", Cfib(n));
}

static PyObject* mysin(PyObject* self, PyObject* args)
{
  double x;
  if (!PyArg_ParseTuple(args, "d", &x))
    return NULL;

  return Py_BuildValue("d", MyCSin(x));

}

static PyObject* mycard(PyObject* self, PyObject* args)
{
  double x;
  if (!PyArg_ParseTuple(args, "d", &x))
    return NULL;
  return Py_BuildValue("d", MyCard(x));
}


static PyObject* version(PyObject* self)
{
  return Py_BuildValue("s", "This is a test: Version 1.0");
}
 
static PyMethodDef myMethods[] = {
  {"fib", fib,    METH_VARARGS, "Calculate the Fibonacci numbers."},
  {"csin", mysin, METH_VARARGS, "Calculate sine value of input."},
  {"mycard", mycard, METH_VARARGS, "calculate my card value."},
  {"version", (PyCFunction)version, METH_NOARGS, "Returns the version."},
  {NULL, NULL, 0, NULL}
};
 
PyMODINIT_FUNC initmyModule(void)
{
  (void) Py_InitModule("myModule", myMethods);
}

