package com.knits.enterprise.service.company;

import com.knits.enterprise.dto.company.EmployeeDto;
import com.knits.enterprise.dto.company.GroupDto;
import com.knits.enterprise.exceptions.GroupException;
import com.knits.enterprise.exceptions.UserException;
import com.knits.enterprise.mapper.company.GroupMapper;
import com.knits.enterprise.model.company.Employee;
import com.knits.enterprise.model.company.Group;
import com.knits.enterprise.repository.company.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GroupService {

    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;

    public GroupDto createGroup(GroupDto groupDto) {
        log.debug("Request to save Group : {}", groupDto);

        Group group;
        if (groupRepository.existsByName(groupDto.getName())) {
            group = groupRepository.findByName(groupDto.getName()).get();
        } else {
            group = groupRepository.save(groupMapper.toEntity(groupDto));
        }
        return groupMapper.toDto(group);
    }

    public GroupDto findById(Long id) {
        log.debug("Request to find Group with id : {}", id);
        return groupMapper.toDto(groupRepository.getById(id));
    }

    public GroupDto updateGroup(GroupDto groupDto) {
        log.debug("Request to update Group  : {}", groupDto);
        Group group = groupRepository.findById(groupDto.getId()).orElseThrow(() -> new GroupException("Group#" + groupDto.getId() + " not found"));
        groupMapper.partialUpdate(group, groupDto);
        groupRepository.save(group);
        return groupMapper.toDto(group);

    }

    @Transactional
    public GroupDto deleteGroup(Long id) {
        log.debug("Request to delete Group with id : {}", id);
        Group group = groupRepository.findById(id).get();
        groupRepository.delete(group);
        return groupMapper.toDto(group);
    }
}
