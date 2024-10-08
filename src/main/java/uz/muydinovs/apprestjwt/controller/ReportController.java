package uz.muydinovs.apprestjwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @GetMapping
    public ResponseEntity<String> getReport() {
        return ResponseEntity.ok("This is your report.");
    }
}
