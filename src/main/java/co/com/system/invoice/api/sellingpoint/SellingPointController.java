package co.com.system.invoice.api.sellingpoint;



import co.com.system.invoice.model.SellingPoint;
import co.com.system.invoice.service.sellingpoint.GetSellingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/selling/point")
public class SellingPointController implements  ISellingPointController{

    @Autowired private GetSellingPointService getSellingPointService;


    @Override
    public List<SellingPoint> getAll() {
        return getSellingPointService.getAll();
    }
}