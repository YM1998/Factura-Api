package co.com.system.invoice.persistence.roles;

import co.com.system.invoice.model.Roles;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolesMapper {


    public Roles toData(RolesEntity rolesEntity);
}
