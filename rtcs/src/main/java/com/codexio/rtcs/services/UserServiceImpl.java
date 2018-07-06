package com.codexio.rtcs.services;

import com.codexio.rtcs.entities.Role;
import com.codexio.rtcs.entities.User;
import com.codexio.rtcs.models.binding.UserLoginBindingDto;
import com.codexio.rtcs.models.binding.UserRegisterBindingDto;
import com.codexio.rtcs.models.view.UserViewDto;
import com.codexio.rtcs.repositories.RoleRepository;
import com.codexio.rtcs.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository,
                           final ModelMapper modelMapper,
                           final BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    private UserViewDto getUserViewDto(final User user) {
        if (user != null) {
            return this.modelMapper.map(user, UserViewDto.class);
        }

        return null;
    }

    @Override
    public UserViewDto create(final UserRegisterBindingDto userRegisterBindingDto) {
        User user = modelMapper.map(userRegisterBindingDto, User.class);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
   //      user.setRole(setRole(userRegisterBindingDto));
        User savedUser = userRepository.saveAndFlush(user);

        return getUserViewDto(savedUser);
    }

    @Override
    public UserViewDto getByEmail(final String email) {
        User user = this.userRepository.findByEmail(email);

        return getUserViewDto(user);
    }

    @Override
    public UserViewDto getById(final String id) {
        User user = this.userRepository.findById(id)
                .orElse(null);

        return getUserViewDto(user);
    }

    @Override
    public Boolean isPasswordValid(final UserLoginBindingDto userLoginBindingDto) {
        User user = this.userRepository.findByEmail(userLoginBindingDto.getEmail());

        if (user == null) {
            return false;
        }

        return user.getPassword().equals(userLoginBindingDto.getPassword());
    }

    @Override
    public Role setRole(final UserRegisterBindingDto userRegisterBindingDto) {
        Long numberOfUsers = userRepository.count();
        Role role = new Role();
        if (numberOfUsers == 0) {
            role.setRole("ADMIN");
        } else {
            role.setRole("USER");
        }

        return role;
    }
}
