package co.com.system.invoice.persistence.seller;

import co.com.system.invoice.model.Seller;
import co.com.system.invoice.persistence.person.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper {


    @Autowired  private PersonMapper personMapper;


    public Seller toData(SellerEntity seller) {
        return Seller.builder()
                     .id(seller.getId())
                     .userAccount(seller.getUserAccount())
                     .password(seller.getPassword())
                     .person(personMapper.toData(seller.getPerson()))
                     .build();
    }

}
