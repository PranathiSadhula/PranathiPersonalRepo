package utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utils.constants.PropertyReaderUtil;

public class DataInputProvider extends PropertyReaderUtil {
	static Logger infolog = Logger.getLogger("infolog");
	static Logger errorlog = Logger.getLogger("errorlog");

	public static String[][] getAllSheetData(String sheetName) {

		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(new File(sheetName));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			// loop through the rows
			for (int i = 1; i < rowCount + 1; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					for (int j = 0; j < columnCount; j++) { // loop through the
															// columns
						try {
							String cellValue = "";
							try {
								if (row.getCell(j).getCellType() == 1)
									cellValue = row.getCell(j)
											.getStringCellValue();
								else if (row.getCell(j).getCellType() == 0)
									cellValue = ""
											+ row.getCell(j)
													.getNumericCellValue();

							} catch (NullPointerException e) {

							}

							data[i - 1][j] = cellValue; // add to the data array
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}

	public static String[][] gettestCaseData(String sheetName) {

		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(new File(sheetName));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1);

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			// loop through the rows
			for (int i = 1; i < rowCount + 1; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					for (int j = 0; j < columnCount; j++) { // loop through the
															// columns
						try {
							String cellValue = "";
							try {
								if (row.getCell(j).getCellType() == 1)
									cellValue = row.getCell(j)
											.getStringCellValue();
								else if (row.getCell(j).getCellType() == 0)
									cellValue = ""
											+ row.getCell(j)
													.getNumericCellValue();

							} catch (NullPointerException e) {

							}

							data[i - 1][j] = cellValue; // add to the data array
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}
	public static HashMap<String, String> getTestApiUrl(String sheetName) {

		HashMap<String, String> data = null;

		try {
			FileInputStream fis = new FileInputStream(new File(sheetName));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
		//	int columnCount = sheet.getRow(0).getLastCellNum();
			data = new HashMap<String, String>();

			// loop through the rows
			for (int i = 1; i < rowCount + 1; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					data.put(row.getCell(0).getStringCellValue().toLowerCase(), row.getCell(1).getStringCellValue());
					
					}

				 catch (Exception e) {
					e.printStackTrace();
				}
			}
			// fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}
	
	public static HashMap<String, String> getTestApiUrl(String sheetName, HashMap<String, String> appIdAdTypeMap, HashSet<String> inputAdTypeSet) {

		HashMap<String, String> data = null;

		try {
			FileInputStream fis = new FileInputStream(new File(sheetName));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
		//	int columnCount = sheet.getRow(0).getLastCellNum();
			data = new HashMap<String, String>();

			// loop through the rows
			for (int i = 1; i < rowCount + 1; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					String adType = row.getCell(0).getStringCellValue().toLowerCase();
					String apiUrl =  prop.getProperty("stagingDomain")+row.getCell(1).getStringCellValue();
					String randomImei = UUID.randomUUID().toString().replace("-", "");
					String appId = "";
					if(adType.toLowerCase().contains("web"))
					{
						appId = appIdAdTypeMap.get("MWeb");
					}
					else
					{
						appId = appIdAdTypeMap.get("Android");
					}
					if(apiUrl.contains("debug"))
					{
						apiUrl = apiUrl.replace("&debug=1", "");
					}
					apiUrl = apiUrl.replace("Replace_imei", randomImei).replace("Replace_appId", appId);
					data.put(adType, apiUrl);
					
					}

				 catch (Exception e) {
					e.printStackTrace();
				}
			}
			// fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}
	public static HashMap<String, String> getAppIdForAdType(Connection conn)
	{
		Statement stmt = null;
		ResultSet result = null;
		String APPID_QUERY = "select distinct a.appid,(case when a.platform_type in(3) then 'MWeb'when a.platform_type in(1) then 'Android'end ) platform "
				+ "	from"
				+ " applications a, app_adtype_status b "
				+ "where"
				+ "	a.platform_type in (1,2,3)"
				+ "	and a.appid=b.appid"
				+ " and a.appstatus = b.status"
				+ "	and a.appstatus = 'APP_RUNNING'"
				+ "		and b.adtype in (1,3,4,5,6,14,24,73,80,90,91,92,93,94)"
				+ "	and a.appid>1000  and a.is_verified = 1 and a.uid = 4 group by 2 order by 2";
		HashMap<String,String> appidAdTypeMap = new HashMap<String, String>();
		try{
			stmt = conn.createStatement();
			result =  stmt.executeQuery(APPID_QUERY);
			while(result.next())
			{
				appidAdTypeMap.put(result.getString("platform"), result.getString("appid"));
			}
		}
		catch(SQLException e)
		{
			errorlog.error("sqlException in executing APPID_QUERY "+APPID_QUERY);
			errorlog.error("\n "+e);
		}
		return appidAdTypeMap;
	}
	
	public static HashMap<String, String> getAppIdForAdType()
	{
		
		String APPID_QUERY = "select distinct a.appid,(case when a.platform_type in(3) then 'MWeb'when a.platform_type in(1) then 'Android'end ) platform "
				+ "	from"
				+ " applications a, app_adtype_status b "
				+ "where"
				+ "	a.platform_type in (1,2,3)"
				+ "	and a.appid=b.appid"
				+ " and a.appstatus = b.status"
				+ "	and a.appstatus = 'APP_RUNNING'"
				+ "		and b.adtype in (1,3,4,5,6,14,24,73,80,90,91,92,93,94)"
				+ "	and a.appid>1000  and a.is_verified = 1 and a.uid = 4 group by 2 order by 2";
		HashMap<String,String> appidAdTypeMap = new HashMap<String, String>();
		String apiUrlAndQueryToGetAppid = prop.getProperty("verticaApiUrl")+APPID_QUERY;
		HttpGet request = new HttpGet(apiUrlAndQueryToGetAppid);
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response ;
		try{
			response = client.execute(request);
			System.out.println(response.getEntity().getContent());
		}
		catch(Exception e)
		{
			errorlog.error("Api Exception in executing APPID_QUERY "+APPID_QUERY);
			errorlog.error("\n "+e);
		}
		return appidAdTypeMap;
	}
	
	public static HashSet<String> getTestAdType(String sheetName) {

		HashSet<String> data = null;

		try {
			FileInputStream fis = new FileInputStream(new File(sheetName));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("AdType");

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			//int columnCount = sheet.getRow(0).getLastCellNum();
			data = new HashSet<String>();

			// loop through the rows
			for (int i = 1; i < rowCount + 1; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					data.add(row.getCell(0).getStringCellValue());
					
					}

				 catch (Exception e) {
					e.printStackTrace();
				}
			}
			// fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}

}
