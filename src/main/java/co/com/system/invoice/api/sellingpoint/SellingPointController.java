package co.com.system.invoice.api.sellingpoint;



import co.com.system.invoice.model.SellingPoint;
import co.com.system.invoice.service.sellingpoint.GetSellingPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/selling/point")
public class SellingPointController implements  ISellingPointController{

   private final GetSellingPointService getSellingPointService;


    @Override
    public List<SellingPoint> getAll() {
        return getSellingPointService.getAll();
    }

    @Override
    public Optional<SellingPoint> findById(@PathVariable("id") Integer id) {
        return getSellingPointService.findById(id);
    }
}
