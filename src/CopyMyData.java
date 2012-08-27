package ru.thetekst.software.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMyData {
	
//	final String COPYfrom = "e:\\video\\torrents\\mainbg3.jpg";
//	final String COPYto = "e:\\video\\mainbg3.jpg";
	
	public void copyFile(String from, String to) {
		
		try{
			// Copy from file: "mainbg3.jpg", size: 63471 byte
			DataInputStream in = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(from)));
			// Copy to: path
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(to)));
			
			System.out.println(in.toString());
		
			byte[] buf = new byte[1024]; // size: 1024 byte
			int len;
			
			while((len = in.read(buf)) > 0){
				System.out.println(len);
				out.write(buf, 0, len);
			}
			
			in.close();
			out.close();
			
			// End try
			
		} catch(FileNotFoundException e){
			System.out.println("Файл не найден: " + e.getMessage());
		} catch(EOFException e1){
			System.out.println("Достигнут конец файла: " + e1.getMessage());
		} catch(IOException e2){
			System.out.println("Проблема при чтении файла: " + e2.getMessage());
		} finally{
			System.out.println("Операция прошла успешно");
		}
	}
		
/**	Program test
 * 
 */
//	public static void main( String [] args ) {
//
//		CopyMyData md = new CopyMyData();
//		md.copyFile(COPYfrom, COPYto);
//	}
}