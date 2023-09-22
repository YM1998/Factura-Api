package co.com.system.invoice.persistence.user;

import co.com.system.invoice.model.User;
import co.com.system.invoice.persistence.person.PersonMapper;
import co.com.system.invoice.persistence.roles.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {


    @Autowired  private PersonMapper personMapper;
    @Autowired  private RolesMapper rolesMapper;


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
