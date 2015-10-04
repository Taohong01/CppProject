//============================================================================
// Name        : MorningTest.cpp
// Author      : Tao Hong
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cv.h>
#include <highgui.h>
using namespace cv;
using namespace std;

int main() {
	cvNamedWindow( "My Window", 1 );
	IplImage *img = cvCreateImage( cvSize( 640, 480 ), IPL_DEPTH_8U, 1 );
	  CvFont font;
	  double hScale = 1.0;
	  double vScale = 1.0;
	  int lineWidth = 1;
	  cvInitFont( &font, CV_FONT_HERSHEY_SIMPLEX | CV_FONT_ITALIC,
	                hScale, vScale, 0, lineWidth );
	    cvPutText( img, "Hello World!", cvPoint( 200, 400 ), &font,
	               cvScalar( 255, 255, 0 ) );
	    cvShowImage( "My Window", img );
	    cvWaitKey();
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	return 0;
}
