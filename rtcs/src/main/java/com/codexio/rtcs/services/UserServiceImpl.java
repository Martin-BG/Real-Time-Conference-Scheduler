package com.codexio.rtcs.services;

import com.codexio.rtcs.entities.User;
import com.codexio.rtcs.models.binding.UserLoginBindingDto;
import com.codexio.rtcs.models.binding.UserRegisterBindingDto;
import com.codexio.rtcs.models.view.UserViewDto;
import com.codexio.rtcs.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository,
                           final ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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
}
