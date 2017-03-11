//import java.util.*;
//public class ReaderNBytes extends Reader4{
//	private char[] buffer = new char[4];
//	int read4(char[] buf);
//	int offset = 0, bufsize = 0, readyCharNum;
	/*set n, the number of bytes we can load into this buffer
	 * always check if the left buffer of n is still enough
	 * to load new readings. if not just load the number equal
	 * to n
	 * int readBytesNum = 0;
	 * readyBytesNum = read(buffer);
	 * if (readyBytesNum == 4){
	 * NBuffer.append(buffer);
	 * readCharNum += 4;
	 * }
	 * else{
	 * if (readBytesNum == 0){end the program;}
	 * else{
	 * NBuffer.append(buffer);
	 * readCharNum += readyBytesNum
	 * 
	 * }
	 * keep reading chars into buffer and load them into the n 
	 * buffer, with a flag showing continue or stop and return
	 * when it should stop:
	 * 1. size larger than or equal to n
	 * 2. no more data to read, as indicated the return number 
	 * of bytes from reader is smaller than 4
	 * 3. keep adding all the read character into the char buffer
	 * 
	 * 
	 * */ 
//	public static int reader(char[] buf, int n){
//		int readCharNum = 0;
//		int readBytesNum = 4;
//		while(readBytesNum == 4 && n - readCharNum >= 0){
//			readBytesNum = reader4(buffer);
//			readCharNum += readBytesNum;
//		}
//		return readCharNum;
//	}
//
//}
