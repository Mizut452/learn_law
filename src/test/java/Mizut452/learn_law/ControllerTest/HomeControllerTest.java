package Mizut452.learn_law.ControllerTest;

import Mizut452.learn_law.LoginSecurity.LoginUserDetailsService;
import Mizut452.learn_law.LoginSecurity.SecurityConfig;
import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.ModelTest.TestWithAdmin;
import Mizut452.learn_law.ModelTest.TestWithAnonymous;
import Mizut452.learn_law.ModelTest.TestWithGeneral;
import Mizut452.learn_law.Service.CreateAccountService;
import org.junit.jupiter.api.Nested;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTestはSpring SecurityやMockMvcを自動構成する。
@WebMvcTest(includeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {LoginUserDetailsService.class, LoginUserMapper.class, SecurityConfig.class}
))
@AutoConfigureMybatis
public class HomeControllerTest {

    @Autowired
    //MockMvcではサーバーを立てずにテストできる
    private MockMvc mockMvc;

    @MockBean
    UserQuizHistoryMapper userQuizHistoryMapper;

    @MockBean
    CreateAccountService createAccountService;

    @Nested
    public class ホーム画面へのアクセス {
        final MockHttpServletRequestBuilder request = get("/")
                .accept(MediaType.TEXT_HTML);


        @TestWithAnonymous
        public void ゲストユーザーでもアクセス可能() throws Exception {
            mockMvc.perform(request)
                    .andExpect(status().isOk());
        }

        @TestWithGeneral
        public void 一般ユーザーでアクセスできる() throws Exception {
            mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(view().name("login"));
        }
        @TestWithAdmin
        public void 管理者でアクセスできる() throws Exception {
            mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(view().name("login"));
        }
    }
}
