package bittrex;

import java.io.StringReader;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class JSONParser {

	public JSONParser() {
		// TODO Auto-generated constructor stub
	}

	public static String getStringValue(JsonObject j, String attributeName) {
		String att = j.getString(attributeName);
		return att;

	}

	public static int getIntValue(JsonObject j, String attributeName) {
		int att = j.getInt(attributeName);
		return att;
	}

	public static double getDoubleValue(JsonObject j, String attributeName) {
		double att = j.getJsonNumber(attributeName).doubleValue();
		return att;
	}

	public static boolean getBooleanValue(JsonObject j, String attributeName) {
		boolean att = j.getBoolean(attributeName);
		return att;
	}

	public static JsonObject getDomObject(String jsonData, String root) {
		JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
		JsonObject obj = jsonReader.readObject();
		JsonObject j = obj.getJsonObject(root);
		return j;
	}

	public static JsonObject getObject(String jsonData) {
		JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
		JsonObject obj = jsonReader.readObject();
		return obj;
	}

	public static List<JsonValue> getDomArray(JsonObject obj, String attributeName) {
		return obj.getJsonArray(attributeName);
	}

}
