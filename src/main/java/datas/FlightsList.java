package datas;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlightsList{
	
	private XSSFSheet flightsSheet;
	private List<List<String>> flightsList;
	private List<String> labels;
	
	
	FlightsList(XSSFSheet flightSheet){
		this.flightsSheet = flightSheet;
		this.flightsList = new ArrayList<>();
		
		for(int i = 0; i <= this.flightsSheet.getLastRowNum(); ++i) {
			this.flightsList.add(getRowData(i));
		}
		
	    labels = this.flightsList.get(0);
	    this.flightsList.remove(0);
	}
	
	
	private List<String> getRowData(int rowIndex) {
		
	    List<String> data = new ArrayList<>();

	    XSSFRow row = this.flightsSheet.getRow(rowIndex);
	    if (row != null) {
	    	for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
	    		XSSFCell cell = row.getCell(colIndex);
	            data.add(cell != null ? cell.toString() : "");
	            }
	    	}
	    
	    return data;
	}
	
	
	public List<List<String>> getFlightsList() {
		return flightsList;
	}
	
	public String jsonify() {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(flightsList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public String toString() {
		
		String output = labels+"\n";
		
		for(int i = 0; i < flightsList.size(); ++i)output += flightsList.get(i)+" \n";
		
		return output;
	}
}