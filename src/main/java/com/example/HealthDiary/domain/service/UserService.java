package com.example.HealthDiary.domain.service;

import com.example.HealthDiary.domain.dto.DiaryDto;
import com.example.HealthDiary.domain.dto.SignUpDto;
import com.example.HealthDiary.domain.dto.SignInDto;
import com.example.HealthDiary.domain.entity.Diary;
import com.example.HealthDiary.domain.entity.User;
import com.example.HealthDiary.domain.repository.DiaryRepository;
import com.example.HealthDiary.domain.repository.UserRepository;
import com.example.HealthDiary.global.error.exception.ErrorCode;
import com.example.HealthDiary.global.error.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.HealthDiary.global.constant.SessionConstant.SESSION_ID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;

    @Transactional
    public void signIn(SignInDto dto, HttpServletRequest request, HttpServletResponse response) {

        Optional<User> existUser = userRepository.findById(dto.getId());
        if (existUser.isPresent()) {
            String password = existUser.get().getPassword();
            if ((password.equals(dto.getPassword()))) {
                //비밀번호 일치
                User user = existUser.get();
                System.out.println("user = " + user);
                //세션 유지
//                HttpSession session = request.getSession();
//                session.setAttribute(SESSION_ID, user.getId());
//                System.out.println("session = " + session.getAttribute(SESSION_ID));
                //                session.
//                CookieGenerator cookie = new CookieGenerator();
//                cookie.setCookieName(SESSION_ID);
//                cookie.addCookie(response, session.getAttribute(SESSION_ID).toString());
//                cookie.setCookieDomain("54.180.217.214");
//                System.out.println("cookie = " + cookie);
//                cookie.setCookieHttpOnly(false);
//                cookie.setCookiePath("/");
//                String id = session.getAttribute(SESSION_ID).toString();
//                Cookie cookie = new Cookie(SESSION_ID, session.getAttribute(SESSION_ID).toString());
//                cookie.setPath("/");
//                cookie.setDomain("54.180.217.214");
//                cookie.setHttpOnly(false);

//                ResponseCookie cookie1 = ResponseCookie.from(SESSION_ID, id).path("/")
//                        .sameSite("None")
//                        .httpOnly(false)
//                        .secure(true)
//                        .build();
//
//                response.addHeader("Set-Cookie",cookie1.toString());

            } else {
                throw new UserException("패스워드가 잘못되었습니다.", ErrorCode.INVALID_USER_PASSWORD);
            }
        } else {
            throw new UserException("아이디가 잘못되었습니다.", ErrorCode.INVALID_USER_ID);
        }


    }

    @Transactional
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

    @Transactional
    public void note(DiaryDto dto, HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
//        if (session.getAttribute(SESSION_ID) == null) {
//            throw new UserException("세션 정보가 없습니다.", ErrorCode.NONE_SESSION_INFORMATION);
//        }
//        String id = (String) session.getAttribute(SESSION_ID);
        String id = dto.getUserId();

        String dateFormat = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 09:00:00"));
//        System.out.println("dateFormat = " + dateFormat);
        java.sql.Timestamp compareTime = Timestamp.valueOf(dateFormat);
//        System.out.println("compareTime = " + compareTime);
//        compareTime.
//        System.out.println("id = " + id);
        String diaryId = id + "#" + dateFormat;
        diaryRepository.save(
                Diary.builder().diaryId(diaryId)
                        .userId(id)
                        .appendixMemo(dto.getAppendixMemo())
                        .conditions(dto.getConditions())
//                        .appendixMemo(dateFormat)
                        .waistPain(dto.getWaistPain())
                        .headache(dto.getHeadache())
                        .date(compareTime)
                        .build()
        );

    }

    @Transactional
    public List<Diary> getDiaryList(String id) {

        List<Diary> byUserId = diaryRepository.findByUserId(id);
        System.out.println("byUserId.get(0).getDate() = " + byUserId.get(0).getDate());

        return byUserId;
    }
}
