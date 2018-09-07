import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;

public class DATReader {
	
	private static String[] iPolyF11;
	
	public static void fillIpolyArray(String filename) {
		try {
			iPolyF11 = Files.readAllLines(new File(filename).toPath()).toArray(new String[0]);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void printArray() throws Exception {
		FileWriter fileWriter = new FileWriter(new File("C:\\Users\\cnwachukwu\\Desktop\\ODW-EDW-Validation\\July 2018\\ODW\\Immediates_Converted_sorted\\IPOLYF11\\UTA_IPOLYF11_modified2.DAT"), true);
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		Pattern pattern = Pattern.compile("\\s{7}0000\\d+");
		for(int i = 0; i < iPolyF11.length; i++) {
			String val = iPolyF11[i];
			//System.out.println(val);
			Matcher matcher = pattern.matcher(val);
			if(matcher.find()) {
				String value = matcher.group(0).trim();

				String part1 = value.substring(0, 12);
				String part2 = value.substring(12, 17);
				String part3 = value.substring(17, 26);
				String part4 = value.substring(26, 37);
				String part5 = value.substring(37, 42);
				String part6 = value.substring(42, 44);
				String part7 = value.substring(44, 48);
				String part8 = value.substring(48, 56);
				String part9 = value.substring(56, 64);
				String part10 = value.substring(64, 65);
				String part11 = value.substring(65);
				
				String newValue = part1 + "  " + part2 + "  " + part3 + "  " + part4 + "  " + part5+ "  " + part6+ "  " 
						+ part7 + "  " + part8+ "  " + part9+ "  " + part10 + "  " + part11;
				//System.out.println(newValue);
				String returnVal = val.replaceFirst(value, newValue);
				buffer.write(returnVal);
				buffer.newLine();
			}
		}
		buffer.close();
	}
	
	public static void main(String[] args) throws Exception {
		fillIpolyArray("C:\\Users\\cnwachukwu\\Desktop\\ODW-EDW-Validation\\July 2018\\ODW\\Immediates_Converted_sorted\\IPOLYF11\\UTA_IPOLYF11.DAT");
		printArray();
		System.out.println("My job is done");
	}

}
