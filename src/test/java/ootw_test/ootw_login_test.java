package ootw_test;

import ootw.main;
import ootw.Entity.User;
import ootw.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = main.class) // Main 클래스 명시
public class ootw_login_test {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        userRepository.deleteAll(); // 테스트 전 데이터베이스 초기화
    }

    @Test
    void testRegisterUser() throws Exception {
        // 회원가입 성공 테스트
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com")
                        .param("password", "password123")
                        .param("username", "testuser"))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));
    }

    @Test
    void testDuplicateEmailRegistration() throws Exception {
        // 중복 이메일 회원가입 실패 테스트
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com")
                        .param("password", "password123")
                        .param("username", "testuser"))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com")
                        .param("password", "password123")
                        .param("username", "testuser2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Email already exists"));
    }

    @Test
    void testLoginSuccess() throws Exception {
        // 회원가입 후 로그인 성공 테스트
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com")
                        .param("password", "password123")
                        .param("username", "testuser"))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com")
                        .param("password", "password123"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome, testuser"));
    }

    @Test
    void testLoginInvalidPassword() throws Exception {
        // 잘못된 비밀번호로 로그인 실패 테스트
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com")
                        .param("password", "password123")
                        .param("username", "testuser"))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com")
                        .param("password", "wrongpassword"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid email or password"));
    }

    @Test
    void testLoginInvalidEmail() throws Exception {
        // 존재하지 않는 이메일로 로그인 실패 테스트
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "nonexistent@example.com")
                        .param("password", "password123"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid email or password"));
    }

    @Test
    void testUserRepository() {
        // UserRepository 직접 테스트
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setUsername("testuser");

        // 데이터 저장 테스트
        userRepository.save(user);
        assert userRepository.existsByEmail("test@example.com");

        // 데이터 조회 테스트
        User foundUser = userRepository.findByEmail("test@example.com").orElse(null);
        assert foundUser != null;
        assert foundUser.getUsername().equals("testuser");
    }
}
