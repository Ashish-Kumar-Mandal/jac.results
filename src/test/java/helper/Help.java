package helper;

public class Help {

	public static String capitalizeWord(String str){  
	    String words[]=str.split("\\s");  
	    String capitalizeWord="";  
	    for(String w:words){  
	        String first=w.substring(0,1);  
	        String afterfirst=w.substring(1);  
	        capitalizeWord+=first.toUpperCase()+afterfirst.toLowerCase()+" ";  
	    }  
	    return capitalizeWord.trim();  
	}
	
	public static String getPercentage(String marks) { 
		return Double.parseDouble(marks.trim())/5+"%";
	}
}
