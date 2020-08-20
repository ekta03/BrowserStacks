package generalutils;

import java.util.HashMap;
import java.util.List;
//import com.jayway.restassured.*;
//import com.jayway.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DataReset {

	public static boolean call(String apiKey, List<String> paramValues) {
		HashMap<String, String> dataResetURI = new HashMap<String, String>();
		HashMap<String, String> apiCallMethod = new HashMap<String, String>();

		// dataResetURI Map contains all the API's available for data reset
		dataResetURI.put("meterreadURI", "https://i-api.eon.de/sales/csc/test/v1/meterread?serialNo={0}&anlage={1}");
		dataResetURI.put("getPasswordResetUrl", "https://i-api.eon.de/rex/resetpassword/v1?email={0}");
		dataResetURI.put("resetCommunicationPopup",
				"https://i-api.eon.de/sales/csc/test/v1/popups/COMMUNICATION_PREFERENCES?xid={0}&action={1}");
		dataResetURI.put("resetAdvertisingPopup", "https://i-api.eon.de/sales/csc/test/v1/advertismentPopup?xid={0}");
		dataResetURI.put("resetDoubledPricePeriods", "https://i-api.eon.de/sales/csc/test/v1/doubledpriceperiods");
		dataResetURI.put("resetAccountdata", "https://i-api.eon.de/sales/csc/test/v1/accountdata");
		dataResetURI.put("resetBillingplan", "https://i-api.eon.de/sales/csc/test/v1/billingplan?crsId={0}");
		dataResetURI.put("homemove", "https://i-api.eon.de/sales/csc/test/v1/homemove?crsId={0}");
		dataResetURI.put("balance", "https://i-api.eon.de/sales/csc/test/v1/balance?crsId={0}&amount={1}");
		dataResetURI.put("autoreg", "https://i-api.eon.de/sales/csc/test/v1/autoregaccount?identCode={0}");

		// Different Method types of API calls
		apiCallMethod.put("meterreadURI", "GET");
		apiCallMethod.put("getPasswordResetUrl", "GET");
		apiCallMethod.put("resetCommunicationPopup", "PUT");
		apiCallMethod.put("resetAdvertisingPopup", "PUT");
		apiCallMethod.put("resetDoubledPricePeriods", "GET");
		apiCallMethod.put("resetAccountdata", "GET");
		apiCallMethod.put("resetBillingplan", "GET");
		apiCallMethod.put("homemove", "GET");
		apiCallMethod.put("balance", "POST");
		apiCallMethod.put("autoreg", "PUT");

		String apiTobePrepared = dataResetURI.get(apiKey);

		// Below loop is for replacing the place holders like {0),{1} in the URI
		for (int i = 0; i < paramValues.size(); i++)
			apiTobePrepared = apiTobePrepared.replace("{" + i + "}", paramValues.get(i));

		System.out.println("CALLING API: " + apiTobePrepared);

		Response getResponse = null;
		if (apiCallMethod.get(apiKey).equalsIgnoreCase("GET")) {
			getResponse = RestAssured.given().auth().oauth2("Bearer a97899b8f1197a4b254ffbfe3f60c3")
					.get(apiTobePrepared);
		}
		if (apiCallMethod.get(apiKey).equalsIgnoreCase("PUT")) {
			getResponse = RestAssured.given().auth().oauth2("Bearer a97899b8f1197a4b254ffbfe3f60c3")
					.put(apiTobePrepared);
		}
		if (apiCallMethod.get(apiKey).equalsIgnoreCase("POST")) {
			getResponse = RestAssured.given().auth().oauth2("Bearer a97899b8f1197a4b254ffbfe3f60c3")
					.post(apiTobePrepared);
		}
		if (getResponse.getStatusCode() == 200) {
			return true;
		} else {
			return false;
		}
	}
}