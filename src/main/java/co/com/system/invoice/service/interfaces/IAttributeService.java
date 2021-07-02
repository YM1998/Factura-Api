package co.com.system.invoice.service.interfaces;

import java.util.List;

import co.com.system.invoice.domain.AttributeDTO;



/**
 * @author Yesid Murillo Segura
 * The Interface IAttributeService.
 */
public interface IAttributeService {

    /**
     * Find all.
     * @return the list
     */
    public List<AttributeDTO> findAll();

}
