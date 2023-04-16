package co.com.system.invoice.persistence.sellingpoint;


import co.com.system.invoice.model.SellingPoint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellingMapper {

    public SellingPoint toData(SellingPointEntity input);
}
