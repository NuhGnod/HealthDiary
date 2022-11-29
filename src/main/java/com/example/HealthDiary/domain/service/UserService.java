package com.example.HealthDiary.domain.service;

import com.example.HealthDiary.domain.dto.DiaryDto;
import com.example.HealthDiary.domain.dto.SignUpDto;
import com.example.HealthDiary.domain.dto.SignInDto;
import com.example.HealthDiary.domain.entity.Diary;
import com.example.HealthDiary.domain.entity.User;
import com.example.HealthDiary.domain.repository.UserRepository;
import com.example.HealthDiary.global.error.exception.ErrorCode;
import com.example.HealthDiary.global.error.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.HealthDiary.global.constant.SessionConstant.SESSION_ID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void signIn(SignInDto dto, HttpServletRequest request) {

        Optional<User> existUser = userRepository.findById(dto.getId());
        if (existUser.isPresent()) {
            String password = existUser.get().getPassword();
            if ((password.equals(dto.getPassword()))) {
                //비밀번호 일치
                User user = existUser.get();

                HttpSession session = request.getSession();
                session.setAttribute(SESSION_ID, user.getId());

            }
            else {
                throw new UserException("패스워드가 잘못되었습니다.", ErrorCode.INVALID_USER_PASSWORD);
            }
        }else{
            throw new UserException("아이디가 잘못되었습니다.", ErrorCode.INVALID_USER_ID);
        }


    }

    public void signUp(SignUpDto dto, HttpServletRequest request) {
        System.out.println("UserService.signUp");
        Optional<User> existUser = userRepository.findById(dto.getId());
        if (existUser.isPresent()) {
            //중복 아이디
            throw new UserException("아이디가 중복 되었습니다.", ErrorCode.DUPLICATED_USER_ID);
        }
        userRepository.save(
                User.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .password(dto.getPassword())
                        .email(dto.getEmail()).build()
        );

    }

    public void note(DiaryDto dto, HttpServletRequest request) {

    }

    public List<Diary> getDiaryList(HttpServletRequest request) {
        return Collections.emptyList();
    }
}
