package com.knits.enterprise.service.company;

import com.knits.enterprise.dto.company.GroupDto;
import com.knits.enterprise.mapper.company.GroupMapper;
import com.knits.enterprise.model.company.Group;
import com.knits.enterprise.repository.company.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GroupService {

    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;

    public GroupDto createGroup(GroupDto groupDto){
        log.debug("Request to save Group : {}", groupDto);

        Group group;
        if(groupRepository.existsByName(groupDto.getName())){
            group = groupRepository.findByName(groupDto.getName()).get();
        }else{
            group =  groupRepository.save(groupMapper.toEntity(groupDto));
        }
        return groupMapper.toDto(group);  
    }

}
