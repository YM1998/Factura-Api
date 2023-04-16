package co.com.system.invoice.persistence.seller;


import co.com.system.invoice.persistence.person.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="seller")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column private Long id;

    @ManyToOne
    @JoinColumn(name="person_id")
    private PersonEntity person;

    @Column private String userAccount;
    @Column private String password;

}
