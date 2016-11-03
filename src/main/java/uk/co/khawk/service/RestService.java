package uk.co.khawk.service;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.khawk.facade.GCMFacade;

@RestController
@RequestMapping("/ws/v1")
public class RestService {

	@Autowired
	private GCMFacade gcmFacade;

	@RequestMapping(value = "/send", method = POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sendGCM(@RequestBody String msgStr, UriComponentsBuilder uriBuilder) {
		try {
			JSONObject msg = new JSONObject(msgStr);
			JSONObject resp = gcmFacade.SendMessage(msg.getJSONObject("data"), msg.get("destination").toString());
			return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
