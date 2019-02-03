import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.lang.ClassLoader;

//CREATED BY PIETRO SPERI
//src/main/resources/script/shell.sh

public class ShellExec {
	public static void main(String[] args) {
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("script/shell.sh").getFile());

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		Process p;
		  try {
		   String[] cmd = { "sh", file}; //adding the script name taking it from the resource folder
		   p = Runtime.getRuntime().exec(cmd); 
		   p.waitFor(); 
		   BufferedReader reader=new BufferedReader(new InputStreamReader(
			p.getInputStream())); 
		   String line; 
		   while((line = reader.readLine()) != null) { 
			System.out.println(line);
		   } 
		  } catch (IOException e) {
		   e.printStackTrace();
		  } catch (InterruptedException e) {
		   e.printStackTrace();
		  }
	}
}



