package com.example.HealthDiary.domain.controller;

import com.example.HealthDiary.domain.dto.UserDto;
import com.example.HealthDiary.domain.entity.User;
import com.example.HealthDiary.domain.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminAController {
    private final AdminService adminService;

    @PutMapping("users")
    public ResponseEntity<Void> deleteUser(
            @RequestBody UserDto dto)  {
        adminService.deleteUser(dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(adminService.getUsers());
    }
}
