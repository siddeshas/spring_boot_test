package com.mosip.print.notifier;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@Controller
@RequestMapping("/mosip")
public class PrintNotificationController {
	
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/print")
	public String calculateCurrencyConversion(@ModelAttribute("IFXPrintInfo") IFXPrintInfo printInfo) {
		
		

		// Create a new HttpHeaders object with the Content-Type header set to "application/json"
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create a JSON object containing the data to be sent to the server
		JSONObject requestJson = new JSONObject();
		requestJson.put("uin", printInfo.getUin());
		requestJson.put("name", printInfo.getName());
		requestJson.put("dob", printInfo.getDob());
		requestJson.put("gender", printInfo.getGender());
		requestJson.put("address", printInfo.getAddress());
		requestJson.put("photo", printInfo.getPhoto());
		requestJson.put("qrcode", printInfo.getQrcode());
		requestJson.put("printStatus", printInfo.getPrintStatus());
	
		// Create a new HttpEntity object with the JSON object and headers
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestJson.toString(), headers);

		// Make the HTTP POST request to the server
		String url = "http://localhost:9000/ifx/notifySave";
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

		// Get the response body from the ResponseEntity object
		String responseBody = responseEntity.getBody();

		return responseBody;
		
	}

}
