package datas;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlightsSheets {
	
	private List<XSSFSheet> hotelsSheets;
	
	
	
	public FlightsSheets(XSSFWorkbook workbook){
		hotelsSheets = new ArrayList<>();
		
        for(int i = 0; i < workbook.getNumberOfSheets(); ++i) {
        	if(workbook.getSheetName(i).contains("Flights")) {
        		hotelsSheets.add(workbook.getSheetAt(i));
        	}
        }
	}
	
	
	
	public List<XSSFSheet> getFlightsSheets() {
		return hotelsSheets;
	}
	
	public class FlightsList{
		
		private List<Flight> flights;
		
		public FlightsList(XSSFSheet flightsSheet){
			flights = new ArrayList<>();
			for(int i = 1; i <= flightsSheet.getLastRowNum(); ++i) {
				List<String> temp = getRowData(i, flightsSheet);
				flights.add(new Flight(temp.get(0), temp.get(1), temp.get(2), temp.get(3), temp.get(4), temp.get(5), temp.get(6)));
			}
		}
		
		private static List<String> getRowData(int rowIndex, XSSFSheet sheet) {
			
		    List<String> data = new ArrayList<>();

		    XSSFRow row = sheet.getRow(rowIndex);
		    if (row != null) {
		    	for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
		    		XSSFCell cell = row.getCell(colIndex);
		            data.add(cell != null ? cell.toString() : "");
		            }
		    	}
		    
		    return data;
		}
		
		public Flight getFlight(int index) {
			return flights.get(index);
		}
		
		public String jsonify() {
			
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(flights);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	}

}
