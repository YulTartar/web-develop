package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.GroupDto;
import com.example.springdatabasicdemo.dtos.AvailabilityDto;
import com.example.springdatabasicdemo.models.Group;
import com.example.springdatabasicdemo.models.Availability;
import com.example.springdatabasicdemo.models.SubGroup;
import com.example.springdatabasicdemo.repositories.GroupRepository;
import com.example.springdatabasicdemo.repositories.SubGroupRepository;
import com.example.springdatabasicdemo.repositories.AvailabilityRepository;
import com.example.springdatabasicdemo.services.AvailabilityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvailabilityServiceImpl implements AvailabilityService<Integer> {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private SubGroupRepository SubGroupRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AvailabilityDto register(AvailabilityDto avalability) {
        Availability s = modelMapper.map(avalability, Availability.class);
        if (avalability.getGroup().getId() != 0) {
            Group g = groupRepository.findById(avalability.getGroup().getId()).get();
            s.setGroup(g);
        }
        if (avalability.getSubgroup().getId() != 0) {
            SubGroup g = SubGroupRepository.findById(avalability.getSubgroup().getId()).get();
            s.setSubgroup(g);
        }
        return modelMapper.map(availabilityRepository.save(s), AvailabilityDto.class);
    }

    @Override
    public void expel(AvailabilityDto avalability) {
        availabilityRepository.deleteById(avalability.getId());
    }

    @Override
    public void expel(Integer id) {
        availabilityRepository.deleteById(id);
    }

    @Override
    public void transfer(AvailabilityDto avalability, GroupDto group) {
        Availability s = availabilityRepository.findById(avalability.getId()).get();
        Group g = groupRepository.findById(group.getId()).get();
        s.setGroup(g);
        availabilityRepository.save(s);
    }

    @Override
    public Optional<AvailabilityDto> findAvalability(Integer id) {
        return Optional.ofNullable(modelMapper.map(availabilityRepository.findById(id), AvailabilityDto.class));
    }

    @Override
    public List<AvailabilityDto> getAll() {
        return availabilityRepository.findAll().stream().map((s) -> modelMapper.map(s, AvailabilityDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AvailabilityDto> findAvalabilitysByGroup(String group) {
        return availabilityRepository.findAllByGroupName(group).stream().map((s) -> modelMapper.map(s, AvailabilityDto.class)).collect(Collectors.toList());
    }
}