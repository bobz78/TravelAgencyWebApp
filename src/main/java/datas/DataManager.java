package datas;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import datas.FlightsSheets.FlightsList;
import datas.HotelsSheets.HotelsList;



public class DataManager {
	
	public static void main(String[] args) {
		
        try (InputStream file = DataManager.class.getResourceAsStream("/datas/Travel_Options_Detailed.xlsx")) {
            if (file == null) {
                throw new IOException("File not found in package: datas");
            }
            
            
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            HotelsSheets hotelsSheet = new HotelsSheets(workbook);
            FlightsSheets flightsSheet = new FlightsSheets(workbook);
            
            HotelsList hotelList = hotelsSheet.new HotelsList(hotelsSheet.getHotelsSheets().get(0));
            FlightsList flightsList = flightsSheet.new FlightsList(flightsSheet.getFlightsSheets().get(0));
            
            
            System.out.println(hotelList.jsonify());
            System.out.println(flightsList.jsonify());

		
            workbook.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
		
	}
	
	private static HashMap<String, FlightsList> flightsMap;
	private static HashMap<String, HotelsList> hotelsMap;
	private static ArrayList<String> existingHotelsNames;
	private static ArrayList<String> existingFlightsNames;
	
	
	private DataManager() {}
	
	
	public static void setup() {setup("/datas/Travel_Options_Detailed.xlsx");}
	public static void setup(String dataPath) {
		

        flightsMap = new HashMap<>();
        existingFlightsNames = new ArrayList<>();
        hotelsMap = new HashMap<>();
        existingHotelsNames = new ArrayList<>();
		
        try (InputStream file = DataManager.class.getResourceAsStream(dataPath)) {
            if (file == null) {
                throw new IOException("File not found in package: datas");
            }
            
            
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            HotelsSheets hotelsSheets = new HotelsSheets(workbook);
            FlightsSheets flightSheets = new FlightsSheets(workbook);

            
            
            for(int i = 0; i < flightSheets.getFlightsSheets().size(); ++i) {
            	existingFlightsNames.add(flightSheets.getFlightsSheets().get(i).getSheetName());
            	flightsMap.put(flightSheets.getFlightsSheets().get(i).getSheetName(), flightSheets.new FlightsList(flightSheets.getFlightsSheets().get(i)));
            }
            for(int i = 0; i < hotelsSheets.getHotelsSheets().size(); ++i) {
            	existingHotelsNames.add(hotelsSheets.getHotelsSheets().get(i).getSheetName());
            	hotelsMap.put(hotelsSheets.getHotelsSheets().get(i).getSheetName(), hotelsSheets.new HotelsList(hotelsSheets.getHotelsSheets().get(i)));
            }
            

		
            workbook.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
	}
	
	public static FlightsList getFlightsList(String listName) {
		return flightsMap.get(listName);
	}
	
	
	public static HotelsList getHotelsList(String listName) {
		return hotelsMap.get(listName);
	}


	public static ArrayList<String> getExistingHotelsNames() {
		return existingHotelsNames;
	}


	public static ArrayList<String> getExistingFlightsNames() {
		return existingFlightsNames;
	}
}