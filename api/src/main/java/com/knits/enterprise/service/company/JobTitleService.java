package com.knits.enterprise.service.company;

import com.knits.enterprise.dto.company.JobTitleDto;
import com.knits.enterprise.dto.search.JobTitleSearchDto;
import com.knits.enterprise.exceptions.UserException;
import com.knits.enterprise.mapper.company.JobTitleMapper;
import com.knits.enterprise.model.company.JobTitle;
import com.knits.enterprise.repository.company.JobTitleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class JobTitleService {


    private final JobTitleRepository repository;

    private final JobTitleMapper mapper;

    public JobTitleDto createJobTitle(JobTitleDto jobTitleDto) {

        log.debug("Request to save JobTitle : {}", jobTitleDto);

        final JobTitle jobTitle = mapper.toEntity(jobTitleDto);
        repository.save(jobTitle);
        return mapper.toDto(jobTitle);
    }

    public void deleteJobTitle(Long id) {

        log.debug("Delete JobTitle by id : {}", id);
        repository.deleteById(id);
    }

    @Transactional
    public JobTitleDto partialUpdate(JobTitleDto jobTitleDto) {

        log.debug("Request to update BusinessUnit : {}", jobTitleDto);

        JobTitle jobTitle = repository.findById(jobTitleDto.getId()).orElseThrow(()
                -> new UserException("JobTitle#" + jobTitleDto.getId() + " not found"));

        mapper.partialUpdate(jobTitle, jobTitleDto);
        repository.save(jobTitle);
        return mapper.toDto(jobTitle);
    }

    public Page<JobTitleDto> getActive(JobTitleSearchDto jobTitleSearchDto) {

        Page<JobTitle> businessUnitPage = repository.findAllJobTitles(jobTitleSearchDto.getSpecification(), jobTitleSearchDto.getPageable());
        List<JobTitleDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, jobTitleSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }

    public Page<JobTitleDto> getAll(JobTitleSearchDto jobTitleSearchDto) {

        Page<JobTitle> businessUnitPage = repository.findAll(jobTitleSearchDto.getSpecification(), jobTitleSearchDto.getPageable());
        List<JobTitleDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, jobTitleSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }
}
