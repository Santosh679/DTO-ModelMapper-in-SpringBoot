package com.dtotaskwithspringboot.dtoproject.service;

import com.dtotaskwithspringboot.dtoproject.dto.UserLocationDto;
import com.dtotaskwithspringboot.dtoproject.model.User;
import com.dtotaskwithspringboot.dtoproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserLocationDto> getAllUsersLocation() {
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

//    private UserLocationDto convertEntityToDto(User user) {
//        UserLocationDto userLocationDto = new UserLocationDto();
//        userLocationDto.setUserId(user.getId());
//        userLocationDto.setEmail(user.getEmail());
//        userLocationDto.setPlace(user.getLocation().getPlace());
//        userLocationDto.setLongitude(user.getLocation().getLongitude());
//        userLocationDto.setLatitude(user.getLocation().getLatitude());
//        return userLocationDto;
//    }


    // By using ModelMapper
    private UserLocationDto convertEntityToDto(User user) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDto userLocationDto = new UserLocationDto();
        userLocationDto = modelMapper.map(user, UserLocationDto.class);
        return userLocationDto;
    }

    private User convertDtoToEntiry(UserLocationDto userLocationDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user = new User();
        user = modelMapper.map(userLocationDto, User.class);
        return user;
    }
}
