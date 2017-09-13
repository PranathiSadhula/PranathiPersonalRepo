package utils;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class DataInputProvider
{
	 public static Object[][] getSheet(String dataSheetName) throws Exception
	 {
		 // This will load csv file 
		 CSVReader reader = new CSVReader(new FileReader("./data/"+dataSheetName+".csv"));
		 
		 // this will load content into list
		  List<String[]> li=reader.readAll();
		  System.out.println("Total rows which we have is "+li.size());
		            
		 // create Iterator reference
		  Iterator<String[]>i1= li.iterator();
		  
		  Object[][] data = new Object[li.size()][2];
		    
		 // Iterate all values
		 int i=0;
		 while(i1.hasNext())
		 {
			 Object[] value = new Object[2];
			 String[] str=i1.next();
			   
			 System.out.print(" Values are ");
			 
			 for(int j=0;j<str.length;j++)
			 {
				 value[j] = str[j];
				 System.out.print(" "+str[j]);
			 }
			 System.out.println("   ");
			 data[i] = value;
			 i++;
		 }
		 return data;
	 
	}
}