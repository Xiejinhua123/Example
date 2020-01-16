package file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class PrintOutDos {
	
	static String dos = "nohup /home/data-integration/pan.sh -level=Info -file=/tmp/mysql1/";
	public static void main(String[] args) {
		
		String file = "E:\\Administrator\\desktop\\price_center\\error.txt";
		try {
			extractErrorData(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		file(new File(file));
		
	}
	
	static void extractErrorData( String filePath ) throws Exception {
		File file = new File(filePath);
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String line = "";
		Set<String> bairk = new HashSet<String>();
		Set<String> ygroup = new HashSet<String>();
		while ( (line = br.readLine()) != null) {
			if (line.indexOf("BZIRK") > -1)
				bairk.add(line);
			if (line.indexOf("YGROUP") > -1)
				ygroup.add(line);
		}
		br.close();
		reader.close();
		System.out.println(JSON.toJSONString(bairk));
		System.out.println(JSON.toJSONString(ygroup));
	}
	
	static void file( File file ) {
		if ( file.isDirectory() ) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				file(file2);
			}
		}else {
			if (file.getName().indexOf(".ktr") > 0) {
				System.out.println(dos + file.getName() + " >> /tmp/.log & ");
			}
		}
	}

}
