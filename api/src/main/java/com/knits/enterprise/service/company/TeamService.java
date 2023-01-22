package com.knits.enterprise.service.company;

import com.knits.enterprise.dto.company.TeamDto;
import com.knits.enterprise.mapper.company.TeamMapper;
import com.knits.enterprise.model.company.Team;
import com.knits.enterprise.repository.company.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TeamService {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;

    public TeamDto createTeam(TeamDto teamDto){
        log.debug("Request to save Team : {}", teamDto);
        Team team;
        if(teamRepository.existsByName(teamDto.getName())){
            team = teamRepository.findByName(teamDto.getName()).get();
        }else{
            team = teamRepository.save(teamMapper.toEntity(teamDto));
        }
        return teamMapper.toDto(team);

    }

    public TeamDto addTeamToProject(Long teamId, Long projectId){
        Team team = teamRepository.findById(teamId).get();
        team.setId(projectId);
        teamRepository.save(team);
        return teamMapper.toDto(team);
    }
}

