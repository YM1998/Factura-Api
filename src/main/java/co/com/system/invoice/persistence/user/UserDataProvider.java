package co.com.system.invoice.persistence.user;

import co.com.system.invoice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserDataProvider {

     private final UserRepository userRepository;
     private final UserMapper userMapper;

    public Optional<User> findById(Long id) {
        Optional<UserEntity> sellerEntity = userRepository.findById(id);
        return sellerEntity.isPresent() ? Optional.of(userMapper.toData(sellerEntity.get())) :
               Optional.empty();
    }

    public Optional<User> findByUserAccount(String userAccount) {
        UserEntity userEntity = userRepository.findByUserAccount(userAccount);
        return userEntity!=null ? Optional.of(userMapper.toData(userEntity)): Optional.empty();
    }

}
