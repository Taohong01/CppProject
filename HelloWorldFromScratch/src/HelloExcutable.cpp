/*
 * HelloExcutable.cpp

 *
 *  Created on: Apr 22, 2016
 *      Author: Tao
 */
/*
#include <iostream>
#include <cv.h>
#include <highgui.h>


using namespace cv;

//using namespace std;
//it is weird that the std was shown as unsolved when I just typed
// the code here. After shutting down eclipse and reload it, the
// the error disappeared.

//MY 1st GOAL: build a image processing program and learn how to use
//class in C++.


//question, what array class that c++ already have and what's the
//most popular library used for this purpose.

//in case of images, opencv should give a lot of convenience data
//and class types that already well defined with a purpose of
//facilitating image processing tasks.

class Image{
private:
	int _NumPixels_x, _NumPixels_y;

public:
	int Pixel[5][5];

	Image(int NumPx, int NumPy){
		this->_NumPixels_x = NumPx;
		this->_NumPixels_y = NumPy;
		for(int i=0; i<this->_NumPixels_x; i++){
			for(int j=0; j<this->_NumPixels_y; j++){
				Pixel[i][j] = 0;
				cout << Pixel[i][j] << endl;
			}
		}

	}

	~Image(){

	}

};




int main( int argc, char** argv )
{
  Mat image;
  image = imread( argv[1], 1 );

  if( argc != 2 || !image.data )
    {
      printf( "No image data \n" );
      return -1;
    }

  namedWindow( "Display Image", CV_WINDOW_AUTOSIZE );
  imshow( "Display Image", image );

  waitKey(0);

  return 0;
}


int main(){
	cout << "start running:" << endl;
	Image image(2, 2);
	cout << "stop running." << endl;

}

*/

#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace std;
using namespace cv;

Mat src; Mat dst;
char window_name1[] = "Unprocessed Image";
char window_name2[] = "Processed Image";

int main( int argc, char** argv )
{
    /// Load the source image
    src = imread( argv[1], 1 );

    namedWindow( window_name1, WINDOW_AUTOSIZE );
    imshow("Unprocessed Image",src);

    dst = src.clone();
    GaussianBlur( src, dst, Size( 15, 15 ), 0, 0 );

    namedWindow( window_name2, WINDOW_AUTOSIZE );
    imshow("Processed Image",dst);

    waitKey();
    return 0;
}
