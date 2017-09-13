package utils;

public class RequestUrlUtils {
	
	public static String returnReqParamValue(String strTobeSplitted, String key)
	{
		String finalValue = "";
		if(strTobeSplitted.toUpperCase().contains(key))
		{
			String[] splitWords = strTobeSplitted.toUpperCase().split("&");
			for (String wantedWord : splitWords) {
				if(wantedWord.contains(key))
				{
					finalValue = wantedWord.substring(wantedWord.indexOf(key)).split("=")[1].toUpperCase();
					return finalValue;
				}
			}
		}
		return finalValue;
	}


}
