package org.hae.yl.controller.PublicAPI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DeepSeekController {

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody Map<String, String> body) {
        String prompt = body.get("prompt");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:11434/api/generate";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> request = new HashMap<>();
        request.put("model", "deepseek-r1:8b");
        request.put("prompt", prompt);
        request.put("stream", false);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
