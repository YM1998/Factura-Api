package co.com.system.invoice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService{



    @Override
    public UserDetails loadUserByUsername(String userName){
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(userName.equals("edwmurse")) {
           authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
           authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        if(userName.equals("edwmurse") || userName.equals("edwmurse2"))
            return new User(userName, "$2a$10$qLmCTAv2BHm2Vf1945QbcOZuOZAgu040SA1fYG6iksGrv6Yi7z9fW", true, true, true, true, authorities);

        throw new UsernameNotFoundException("Usuario Invalido");
    }





}
