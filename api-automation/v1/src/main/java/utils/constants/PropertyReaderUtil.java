/*-----------------------------------------------------------------------------------------------*/
/* Class           : PropertyReaderUtil.java                                         		 	 	 	 */
/*																								 */
/*																								 */
/*-----------------------------------------------------------------------------------------------*/
/* Sr. no. 	        *  Date          *         Author       *	  Description                    */
/*-----------------------------------------------------------------------------------------------*/
/*  [1] 			*  01-03-2011  	 *   Ramanan T D		*    For PFMT batch 			 	 */
/*        			*            	 *  					*  				                     */
/*        			*            	 *  					*  				                     */
/*        			*            	 *  					*  				                     */
/*        			*            	 *  					*  				                     */
/*-----------------------------------------------------------------------------------------------*/

package utils.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * @author Pranathi
 *
 *         Util Class For Property File Reading
 */
public class PropertyReaderUtil {

	public static String config_file_path = "./src/main/resources/config.properties";
	protected static Properties prop;
	/** Class Level Varaible - log */
	//Logger log = Logger.getLogger(PropertyReaderUtil.class);
	static Logger infolog = Logger.getLogger("infolog");
	static Logger errorlog = Logger.getLogger("errorlog");

	public PropertyReaderUtil() {
	}

	public void loadProperties() {
		prop = new Properties();
		try {

			prop.load(new FileInputStream(new File(config_file_path)));
			infolog.info("Property file "+config_file_path+" is loaded");

		} catch (FileNotFoundException e) {

			errorlog.error("FileNotFoundException in reading config.properties file :"
							+ e);

		} catch (IOException e) {
			errorlog.error("IOException in reading config.properties file :"
							+ e);
		}
	}
	
	public void unloadProperties() {
		prop = null;
	}

	
public String getPropertyValue(String key) throws Exception
	
	{
		
		String val = prop.getProperty(key);
		
		if(null == val)
		{
			errorlog.error("Either the property "+key+" is not Set in Config Property File or An Invalid property .");
			throw new Exception("Either the property "+key+" is not Set In Config Property File or An Invalid property ");
		}
		return prop.getProperty(key);
	}
}
