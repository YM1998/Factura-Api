package co.com.system.invoice.persistence.user;

import co.com.system.invoice.model.User;
import co.com.system.invoice.persistence.person.PersonMapper;
import co.com.system.invoice.persistence.roles.RolesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserMapper {


    private final PersonMapper personMapper;
    private final RolesMapper rolesMapper;


    public User toData(UserEntity user) {
        return User.builder()
                     .id(user.getId())
                     .userAccount(user.getUserAccount())
                     .password(user.getPassword())
                     .person(personMapper.toData(user.getPerson()))
                     .roles(user.getRolesUser()
                             .stream()
                             .map(rolUser -> rolesMapper.toData(rolUser.getRol()))
                             .collect(Collectors.toList()))
                     .build();
    }

}
