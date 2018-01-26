package demo.service.impl;

import demo.domain.SupplyLocation;
import demo.domain.SupplyLocationRepository;
import demo.service.SupplyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinkang on 1/25/18.
 */
@Service
public class SupplyLocationServiceImpl implements SupplyLocationService{
    private SupplyLocationRepository supplyLocationRepository;

    @Autowired
    public SupplyLocationServiceImpl(SupplyLocationRepository supplyLocationRepository) {
        this.supplyLocationRepository = supplyLocationRepository;
    }

    @Override
    public List<SupplyLocation> saveSupplyLocationsZipContains504(List<SupplyLocation> locations) {
        return (ArrayList<SupplyLocation>) this.supplyLocationRepository.save(this.filterList(locations,"504"));
    }

    private List<SupplyLocation> filterList(final List<SupplyLocation> listToFilter,final String keyword) {
        return new ArrayList<SupplyLocation>() {{
            for (SupplyLocation supplyLocation : listToFilter) {
                if (supplyLocation.getZip().contains(keyword)) {
                    add(supplyLocation);
                }
            }
        }};
    }
}
