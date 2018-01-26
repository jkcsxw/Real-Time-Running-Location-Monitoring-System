package demo.rest;

import demo.domain.SupplyLocation;
import demo.domain.SupplyLocationRepository;
import demo.service.SupplyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by Xinkang on 1/25/18.
 */
public class SupplyLocationRestController {
    private SupplyLocationService supplyLocationService;
    private SupplyLocationRepository supplyLocationRepository;

    @Autowired
    public SupplyLocationRestController(SupplyLocationRepository supplyLocationRepository, SupplyLocationService supplyLocationService) {
        this.supplyLocationService =supplyLocationService;
        this.supplyLocationRepository = supplyLocationRepository;
    }

    @RequestMapping(value = "/supplylocations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<SupplyLocation> locations) {
        this.supplyLocationRepository.save(locations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    public void purge() {
        this.supplyLocationRepository.deleteAll();
    }

    public List<SupplyLocation> uploadFilteredLocations(List<SupplyLocation> locations) {
        return this.supplyLocationService.saveSupplyLocationsZipContains504(locations);
    }
}
