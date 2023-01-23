package Mizut452.learn_law.LoginSecurity;


import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Model.Entity.LoginUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginUserDetailsService implements UserDetailsService {

    private LoginUserMapper loginUserMapper;

    public LoginUserDetailsService(LoginUserMapper loginUserMapper) {
        this.loginUserMapper = loginUserMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginUserMapper.findByUsername(username);
    }
}