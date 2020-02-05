import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonExample {
//https://www.tutorialspoint.com/json/json_java_example.htm
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, ParseException{
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      //System.out.println(jsonText);
	      JSONParser parser = new JSONParser();
	      JSONObject json = (JSONObject) parser.parse(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	  
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		 JSONObject json = readJsonFromUrl("https://opendata.arcgis.com/datasets/d1296bce96be459bb8543a9ecfaa0392_0.geojson");
		 //System.out.println(json.toString());
		 System.out.println(json.get("Facility_Name"));
	}

}
