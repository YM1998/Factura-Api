package co.com.system.invoice.persistence.dataproviders.interfaces;

import java.util.List;

import co.com.system.invoice.domain.StateDTO;

public interface IStateDataProvider {

    public List<StateDTO> findAll();
}
