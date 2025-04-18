package demo.controller;

import demo.service.DocumentationQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentationQueryController {

    private final DocumentationQueryService documentationQueryService;

    public DocumentationQueryController(DocumentationQueryService documentationQueryService) {
        this.documentationQueryService = documentationQueryService;
    }

    @PostMapping("/ask")
    public ResponseEntity<String> ask() {
        try {

           String answer = documentationQueryService.ask();

            return ResponseEntity.ok(answer);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
