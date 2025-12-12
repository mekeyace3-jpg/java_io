package io;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;

/*
io => 간단한 파일처리, 단순한 파일저장
nio => CDN서버, Streaming서버, 채팅서버, 스토리지 서버


I/O => 파일(읽기,쓰기) => 단방향
String, char => 문서파일
FileReader, FileWriter => Disk 쓰기, 읽기 => Scanner 출력
BufferedReader, BufferedWriter => Buffer기반(메모리) 성능향상 => 단독사용(X)


주의사항 : String => byte변환 (getBytes()) => available 처리
Stream => byte형태 (문서,이미지,pdf,동영상,음악....)
InputStream => FileInputStream, AudioInputStream...
OutputStream => FileOutStream, AudioOutStream...

BufferedInputStream, BufferedOutputStream  => Buffer기반(메모리) 성능향상
(read,readline)
-----------------------------------------------------------------
NIO (비동기통신 -> 파일처리하는 방식) => 양방향
Stream, Buffer, Channel
Path => Paths
ReandomAccessFile <=> Channel
Files => createFile(), createDirectory(), 
delete(), copy(), move(), writeString(), readString()

----------------------------------------------
FileInputStream => InputStreamReader => BufferedReader
FileOutputStream => OutputStreamWriter => BufferedWriter => write => flush
FileWriter => byte[] getBytes() => FileOutputStream
*/
public class review1 {

	public static void main(String[] args) {
		
	}

}
