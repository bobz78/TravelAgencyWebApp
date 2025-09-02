package datas;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HotelsSheets {

	private List<XSSFSheet> hotelsSheets;
	
	
	
	public HotelsSheets(XSSFWorkbook workbook){
		hotelsSheets = new ArrayList<>();
		
        for(int i = 0; i < workbook.getNumberOfSheets(); ++i) {
        	if(workbook.getSheetName(i).contains("Hotels")) {
        		hotelsSheets.add(workbook.getSheetAt(i));
        	}
        }
	}
	
	
	public List<XSSFSheet> getHotelsSheets() {
		return hotelsSheets;
	}




	public class HotelsList{
		
		private List<Hotel> hotels;
		
		public HotelsList(XSSFSheet hotelsSheet){
			hotels = new ArrayList<>();
			for(int i = 1; i <= hotelsSheet.getLastRowNum(); ++i) {
				List<String> temp = getRowData(i, hotelsSheet);
				hotels.add(new Hotel(temp.get(0), temp.get(1), temp.get(2)));
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
		
		public Hotel getHotel(int index) {
			return hotels.get(index);
		}
		
		public String jsonify() {
			
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(hotels);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	}
	
}