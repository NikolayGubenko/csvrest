package com.example.csvrest.service;

import com.example.csvrest.model.MsiMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MsiMasterService {

    void upload(MultipartFile uploadedFile);

    List<MsiMaster> findAll();

    List<MsiMaster> sortByName();

    Page<MsiMaster> getPage(Pageable pageable);
}
