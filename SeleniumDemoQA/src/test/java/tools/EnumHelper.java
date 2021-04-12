package tools;

public class EnumHelper {
	
	public enum Enum_State {
		NCR("NCR"),
		UTTAR_PRADESH("UTTAR PRADESH"),
		HARYANA("HARYANA"),
		RAJASTHAN("RAJASTHAN");
		
		String state;
		
		Enum_State(String s){
			state = s;
		}
	}
	
	public enum Enum_City {
		DELHI("Delhi"),
		GURGAON("Gurgaon"),
		NOIDA("Noida");
		
		String city;
		
		Enum_City(String c){
			city = c;
		}
	}
	
}
