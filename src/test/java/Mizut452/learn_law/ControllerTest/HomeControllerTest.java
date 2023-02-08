package Mizut452.learn_law.ControllerTest;

import Mizut452.learn_law.LoginSecurity.LoginUserDetailsService;
import Mizut452.learn_law.LoginSecurity.SecurityConfig;
import Mizut452.learn_law.Mapper.LoginUserMapper;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@WebMvcTestはSpring SecurityやMockMvcを自動構成する。
@WebMvcTest(includeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {LoginUserDetailsService.class, LoginUserMapper.class, SecurityConfig.class}
))
@AutoConfigureMybatis
public class HomeControllerTest {

}
