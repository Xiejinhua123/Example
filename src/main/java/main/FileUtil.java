package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.alibaba.excel.util.StringUtils;

public class FileUtil {

	/**
	 * 读取某个文件夹下的所有文件
	 */
	public static boolean readFile(String filepath) throws FileNotFoundException, IOException {
		File file = new File(filepath);
		if (file.isDirectory()) {
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				File readfile = new File(filepath + "\\" + filelist[i]);
				if (!readfile.isDirectory()) {
					if ( readfile.getPath().indexOf(".java") < 0 ) {
						readfile.delete();
						continue;
					}
					writeFile(readfile);
				} else if (readfile.isDirectory()) {
					readFile(filepath + "\\" + filelist[i]);
				}
			}
		}
		return true;
	}

	public static StringBuilder readFile(File file) throws IOException {
		String line = null;
		StringBuilder sb = new StringBuilder();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		fileReader.close();
		br.close();
		return sb;
	}

	public static void writeFile(File file) throws IOException {
		String str = readFile(file).toString();
		if ( !StringUtils.isEmpty(str) ) {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			String filePath = file.getParent();
			str = "package " + filePath.substring(filePath.indexOf("designmode"), filePath.length()).replaceAll("\\\\", ".") + ";\n"
					+ str.substring(str.indexOf("public"), str.length());
			System.out.println("aa......" + str);
			bw.write(str);
			bw.close();
			fileWriter.close();
		}
	}
}
