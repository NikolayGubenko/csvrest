package com.example.csvrest.service.Impl;

import com.example.csvrest.model.MsiMaster;
import com.example.csvrest.repository.MsiMasterRepository;
import com.example.csvrest.service.MsiMasterService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class MsiMasterServiceImpl implements MsiMasterService {

    private final MsiMasterRepository msiMasterRepository;

    public MsiMasterServiceImpl(MsiMasterRepository msiMasterRepository) {
        this.msiMasterRepository = msiMasterRepository;
    }

    private List<MsiMaster> convertCsvToEntity(MultipartFile uploadedFile) {
        try {
            return new CsvToBeanBuilder<MsiMaster>(new InputStreamReader(uploadedFile.getInputStream()))
                    .withSeparator(';')
                    .withType(MsiMaster.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new RuntimeException("File convert error:" + e.getMessage());
        }
    }

    @Override
    public void upload(MultipartFile uploadedFile) {
        this.msiMasterRepository.saveAll(this.convertCsvToEntity(uploadedFile));
    }

    @Override
    public List<MsiMaster> findAll() {
        return this.msiMasterRepository.findAll();
    }

    @Override
    public List<MsiMaster> sortByName() {
        return this.msiMasterRepository.findAll(Sort.by("name"));
    }

    @Override
    public Page<MsiMaster> getPage(Pageable pageable) {
        return this.msiMasterRepository.findAll(pageable);
    }
}
