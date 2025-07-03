package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
//@RequestMapping("/telstra-starter-repo")

public class ActivationController {

    private final RestTemplate restTemplate;

    @Autowired
    public ActivationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @PostMapping("/activate")   
    public ResponseEntity<String> activate(@RequestBody ActivationRequest request){
        String targetUrl = "http://localhost:8444/actuate";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ActivationRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ActivationResponse> response = restTemplate.postForEntity(targetUrl, entity, ActivationResponse.class);
        boolean successful = response.getBody().succeeded();
        System.out.println("Actuator update: Success? = " + successful);
        
        return ResponseEntity.ok("Forwarded with status: " + successful);
    }
}