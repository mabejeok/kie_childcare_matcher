package com.ccrecommend.model;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonService {
	// This class is used to retrieve JSON string from Google API
	private java.lang.String url;
	private java.lang.String apiKey;
	private java.lang.String origin;
	private java.lang.String destination;
	
	public JsonService(java.lang.String url,
			java.lang.String apiKey,
			java.lang.String origin,
			java.lang.String destination) throws URISyntaxException {
		this.apiKey = apiKey;
		this.origin = origin;
		this.destination = destination;
		this.url = url;
		this.url = this.url += "&" + this.origin;
		this.url = this.url += "&" + this.destination;
		this.url = this.url += "&" + this.apiKey;

		System.out.println(this.url);
	}
	
	@SuppressWarnings("finally")
	public java.lang.String getJson() throws IOException, ParseException, UnknownHostException {
		String distance = "-1km";

		URL url = new URL(this.url);
		//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//Set the request to GET or POST as per the requirements
		conn.setRequestMethod("GET");
		//Use the connect method to create the connection bridge
		conn.connect();
		//Get the response status of the Rest API
		int responsecode = conn.getResponseCode();
		
		//inline will store the JSON data streamed in string format
		String inline = "";
		
		//Iterating condition to if response code is not 200 then throw a runtime exception
		//else continue the actual process of getting the JSON data
		if(responsecode != 200)
			throw new RuntimeException("HttpResponseCode: " +responsecode);
		else
		{
			//Scanner functionality will read the JSON data from the stream
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext())
			{
				inline+=sc.nextLine();
			}
			//Close the stream when reading the data has been finished
			sc.close();
		}

		if(inline != null) {
			//JSONParser reads the data from string object and break each data into key value pairs
			JSONParser parse = new JSONParser();
			//Type caste the parsed json data in json object
			JSONObject jobj = (JSONObject)parse.parse(inline);
			List<JSONObject> elements = (List<JSONObject>) jobj.get("rows");
			
			for(int i=0;i<elements.size();i++) {
				List<JSONObject> elementList = (List<JSONObject>) elements.get(i).get("elements");
				for(JSONObject element: elementList) {
					if(element.containsKey("distance")){
						JSONObject distanceDict = (JSONObject) element.get("distance");
						distance = (String) distanceDict.get("text");
					}
				}
			}
		} 
		

		//Disconnect the HttpURLConnection stream
		conn.disconnect();
		
		return distance;
	}
}



