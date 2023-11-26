package co.com.system.invoice.service.user;

import co.com.system.invoice.model.User;
import co.com.system.invoice.persistence.user.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetUserService {

    private final UserDataProvider userDataProvider;

    public Optional<User> findById(Long id) {
        return userDataProvider.findById(id);
    }

    public Optional<User> findByUserName(String userName) {
        return userDataProvider.findByUserAccount(userName);
    }





}
