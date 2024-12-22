package com.igrus.ootw.user.service;

import com.igrus.ootw.user.domain.User;
import com.igrus.ootw.user.domain.enums.Gender;
import com.igrus.ootw.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // 생성자를 통한 의존성 주입
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입 메서드
    public User registerUser(String nickname, String email, String password, Gender gender) {
        // 이메일 중복 체크
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // 사용자 객체 생성
        User user = User.builder()
                .nickname(nickname)
                .email(email)
                .password(password) // 암호화 적용 X
                .gender(gender)
                .build();

        // 저장 및 반환
        return userRepository.save(user);
    }

    // 로그인 메서드
    public User loginUser(String email, String password) {
        // 이메일로 사용자 조회
        Optional<User> userOpt = userRepository.findByEmail(email);

        // 사용자 존재 여부 및 비밀번호 확인
        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 잘못되었습니다.");
        }

        // 성공 시 사용자 반환
        return userOpt.get();
    }
}
