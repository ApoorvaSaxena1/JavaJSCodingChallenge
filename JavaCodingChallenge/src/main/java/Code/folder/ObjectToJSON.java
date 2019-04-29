package folder;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJSON {

	public String entryToJSON(List<Entry> entries) {

        ObjectMapper mapper = new ObjectMapper();
        
        String jsonInString=new String();
        
        jsonInString="{\"list\":[";

        try {
            // Java objects to JSON string - pretty-print
        	for (Entry entry:entries) {
        		jsonInString = jsonInString + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entry)+",";
        	}
        
        jsonInString=jsonInString.substring(0,jsonInString.length()-1)+"]}";

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return jsonInString;

    }
	public String entryToJSONpaging(List<Entry> entries,int page) {

        ObjectMapper mapper = new ObjectMapper();
        
        String jsonInString=new String();
        int index=10*page;
        
        boolean check=true;
        int count=0;
        
        jsonInString="{\"list\":[";

        try {
            // Java objects to JSON string - pretty-print
//        	for (Entry entry:entries) {
//        		jsonInString = jsonInString + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entry)+",";
//        	}
        	while(index<entries.size()) {
        		jsonInString = jsonInString + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entries.get(index))+",";
        		index++;
        		count++;
        		if(count==10) {
        			break;
        		}
        	}
        
        jsonInString=jsonInString.substring(0,jsonInString.length()-1)+"]";
        if(index>=entries.size()) {
        	check=false;
        	jsonInString=jsonInString+",\"check\":\"F\"}";
        }
        else {
        	jsonInString=jsonInString+",\"check\":\"T\"}";
        }
        

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return jsonInString;

    }
	
}
