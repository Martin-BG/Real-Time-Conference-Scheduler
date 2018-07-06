package com.codexio.rtcs.services;

import com.codexio.rtcs.entities.Role;
import com.codexio.rtcs.models.binding.RoleRegistrationBindingDto;
import com.codexio.rtcs.models.view.RoleViewDto;
import com.codexio.rtcs.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    private RoleViewDto getRoleViewDto(final Role role) {
        if (role != null) {
            return this.modelMapper.map(role, RoleViewDto.class);
        }

        return null;
    }

    @Override
    public RoleViewDto create(final RoleRegistrationBindingDto roleRegistrationBindingDto) {
        Role role = modelMapper.map(roleRegistrationBindingDto, Role.class);
        Role savedRole = roleRepository.save(role);

        return getRoleViewDto(savedRole);
    }

    @Override
    public RoleViewDto getById(final Long id) {
        Role role = this.roleRepository.findById(id)
                .orElse(null);
        return getRoleViewDto(role);
    }
}
