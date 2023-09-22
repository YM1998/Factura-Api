package co.com.system.invoice.persistence.user;


import co.com.system.invoice.persistence.person.PersonEntity;
import co.com.system.invoice.persistence.roles.user.RolesUserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column private Long id;

    @ManyToOne
    @JoinColumn(name="person_id")
    private PersonEntity person;

    @Column private String userAccount;
    @Column private String password;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<RolesUserEntity> rolesUser;

}
