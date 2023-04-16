package co.com.system.invoice.api.sellingpoint;

import co.com.system.invoice.model.SellingPoint;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ISellingPointController {

    @GetMapping(value = "/getAll")
    public  List<SellingPoint> getAll();


}
