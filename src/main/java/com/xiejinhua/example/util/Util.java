package com.xiejinhua.example.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Util {
	private static File file = new File("D:\\a.txt");

	public static synchronized void write(String str) {
		try {
			FileWriter fw = new FileWriter(file , true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(str);
			pw.flush();
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
