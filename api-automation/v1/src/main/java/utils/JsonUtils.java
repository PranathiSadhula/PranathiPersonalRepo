package utils;


public class JsonUtils {
	
	
	public static String returnJsonValue(String strTobeSplitted, String key)
	{
		String finalValue = "";
		if(strTobeSplitted.toUpperCase().contains(key))
		{
			String[] splitWords = strTobeSplitted.toUpperCase().split(",");
			for (String wantedWord : splitWords) {
				if(wantedWord.contains("\""+key+"\""))
				{
					finalValue = wantedWord.substring(wantedWord.indexOf(key)).split(":")[1].toUpperCase().replaceAll("\"", "");
					return finalValue;
				}
			}
		}
		return finalValue;
	}

}
