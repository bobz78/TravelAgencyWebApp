package datas;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataManager {
	
	private static HashMap<String, FlightsList> flightsMap;
	private static ArrayList<String> sheetNames;
	
	
	private DataManager() {}
	
	
	
	public static void setup() {
        try (InputStream file = DataManager.class.getResourceAsStream("Travel_Options_Detailed.xlsx")) {
            if (file == null) {
                throw new IOException("File not found in package: datas");
            }
            

            flightsMap = new HashMap<>();
            sheetNames = new ArrayList<>();
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            
            for(int i = 0; i < workbook.getNumberOfSheets(); ++i) {
            	flightsMap.put(workbook.getSheetName(i), new FlightsList(workbook.getSheetAt(i)));
            	sheetNames.add(workbook.getSheetName(i));
            }
		
            workbook.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
	}
	
	public static FlightsList getFlightsList(String listName) {
		return flightsMap.get(listName);
	}
	
	public static ArrayList<String> getSheetNames() {
		return sheetNames;
	}

}