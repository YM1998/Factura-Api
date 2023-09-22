package co.com.system.invoice.service.security;

import co.com.system.invoice.model.User;
import co.com.system.invoice.persistence.user.UserDataProvider;
import co.com.system.invoice.service.user.GetUserService;
import co.com.system.invoice.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginService implements UserDetailsService {


    @Autowired
    private GetUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userService.findByUserName(SecurityUtils.getUserName(userName));

        if(!user.isPresent()) {
           throw  new UsernameNotFoundException("Error en el login no existe usuario");
        }

        List<GrantedAuthority> authorities = user.get().getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(userName,
                user.get().getPassword(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, authorities );
    }
}
