package co.com.system.invoice.persistence.client;


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
@Table(name="client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column private Long id;
    @ManyToOne
    @JoinColumn(name="person_id")
    private PersonEntity person;
}
