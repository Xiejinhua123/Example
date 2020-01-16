package file;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

public class CopyFileToDir {
	static File getTime = new File("E:\\Administrator\\desktop\\price_center\\a\\getTime.ktr");
	static File kjb = new File("E:\\Administrator\\desktop\\price_center\\a\\A910.kjb");
	
	public static void main(String[] args) {
		
		String dicStr = "E:\\Administrator\\desktop\\price_center\\mysql";
		
		File file = new File(dicStr);
		
		file(file);
		
	}
	
	static void file( File file ) {
		if ( file.isDirectory() ) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				file(file2);
			}
		}else {
			if (file.getName().indexOf(".ktr") > 0) {
				try {
					Files.copy(getTime, new File(file.getParent() + "\\getTime.ktr"));
					Files.copy(kjb, new File(file.getParent() + "\\" + file.getName().substring(0, file.getName().indexOf(".")) + ".kjb"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
