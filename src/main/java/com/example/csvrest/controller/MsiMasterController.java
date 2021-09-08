package com.example.csvrest.controller;

import com.example.csvrest.model.MsiMaster;
import com.example.csvrest.service.MsiMasterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/msimaster")
public class MsiMasterController {

    private final MsiMasterService msiMasterService;

    public MsiMasterController(MsiMasterService msiMasterService) {
        this.msiMasterService = msiMasterService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadFile(@RequestParam("uploadedFile") MultipartFile uploadedFile) {
        if (uploadedFile.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        this.msiMasterService.upload(uploadedFile);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<MsiMaster>> findAll() {
        return ResponseEntity.ok(this.msiMasterService.findAll());
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<MsiMaster>> sort() {
        return ResponseEntity.ok(this.msiMasterService.sortByName());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<MsiMaster>> getPage(@RequestParam(defaultValue = "0") int pageNumber,
                                                   @RequestParam(defaultValue = "5") int pageSize) {
        return ResponseEntity.ok(this.msiMasterService.getPage(PageRequest.of(pageNumber, pageSize)));
    }
}
