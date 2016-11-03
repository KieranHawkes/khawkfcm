package uk.co.khawk.facade;

import org.json.JSONObject;

public interface GCMFacade {

	JSONObject SendMessage(JSONObject msg, String destination);
 
}
