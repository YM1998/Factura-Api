package co.com.system.invoice.service.user;

import co.com.system.invoice.api.user.request.UserLoginRequest;
import co.com.system.invoice.model.User;
import co.com.system.invoice.persistence.user.UserDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserService {

    @Autowired private UserDataProvider userDataProvider;

    public Optional<User> findById(Long id) {
        return userDataProvider.findById(id);
    }

    public Optional<User> findByUserName(String userName) {
        return userDataProvider.findByUserAccount(userName);
    }





}
