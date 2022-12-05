package com.example.HealthDiary.domain.service;

import com.example.HealthDiary.domain.dto.UserDto;
import com.example.HealthDiary.domain.entity.User;
import com.example.HealthDiary.domain.repository.UserRepository;
import com.example.HealthDiary.global.error.exception.ErrorCode;
import com.example.HealthDiary.global.error.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    @Transactional
    public List<User> getUsers() {
        List<User> all = userRepository.findAll();
        return all;
    }
    @Transactional
    public void deleteUser(UserDto dto) {
        String userId = dto.getUserId();
        Optional<User> existUser = userRepository.findById(userId);
        if(existUser.isEmpty()){
            throw new UserException("유저가 존재하지 않습니다", ErrorCode.USER_IS_NOT);
        }
        userRepository.deleteById(userId);
    }
}
