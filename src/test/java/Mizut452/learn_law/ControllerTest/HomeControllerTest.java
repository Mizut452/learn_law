package Mizut452.learn_law.ControllerTest;

import Mizut452.learn_law.LoginSecurity.SecurityConfig;
import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.ModelTest.TestWithAnonymous;
import Mizut452.learn_law.Service.HomeService;
import org.junit.jupiter.api.Nested;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//@WebMvcTestはSpring SecurityやMockMvcを自動構成する。
@WebMvcTest(includeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {HomeService.class, LoginUserMapper.class, SecurityConfig.class}
))
@AutoConfigureMybatis
public class HomeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Nested
    public class トップ画面へのアクセス {
        final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .accept(MediaType.TEXT_HTML);

        @TestWithAnonymous
        public void ログインなしでアクセス可能() throws Exception {
            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk())
                    .andExpect(view().name("home"));
        }


    }
}
