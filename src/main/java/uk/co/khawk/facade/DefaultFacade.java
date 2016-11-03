package uk.co.khawk.facade;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class DefaultFacade implements GCMFacade {
	private static String API_KEY;

	public DefaultFacade(String apiKey) {
		API_KEY = apiKey;
	}

	@Override
	public JSONObject SendMessage(JSONObject msg, String destination) {
		try {
			// Prepare JSON containing the GCM message content. What to send and
			// where to send.
			JSONObject jGcmData = new JSONObject();
			JSONObject jData = new JSONObject();
			jData.put("message", msg);
			// Where to send GCM message.
			if (!destination.isEmpty()) {
				jGcmData.put("to", destination);
			} else {
				jGcmData.put("to", "/topics/global");
			}
			// What to send in GCM message.
			jGcmData.put("data", jData);

			// Create connection to send GCM Message request.
			URL url = new URL("https://fcm.googleapis.com/fcm/send");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "key=" + API_KEY);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// Send GCM message content.
			OutputStream outputStream = conn.getOutputStream();
			outputStream.write(jGcmData.toString().getBytes());
			JSONObject resp = new JSONObject();
			resp.put("response", conn.getResponseMessage());
			return resp;

		} catch (IOException e) {
			JSONObject resp = new JSONObject();
			resp.put("response", e.getMessage());
			return resp;
		}
		// TODO Auto-generated method stub
	}

}
