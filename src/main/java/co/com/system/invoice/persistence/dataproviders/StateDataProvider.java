package co.com.system.invoice.persistence.dataproviders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.domain.StateDTO;
import co.com.system.invoice.persistence.repository.StateReporsitory;

@Repository
public class StateDataProvider {

    @Autowired private StateReporsitory stateReporsitory;

    public List<StateDTO> findAll() {
        return stateReporsitory.findAllState();
    }

}
