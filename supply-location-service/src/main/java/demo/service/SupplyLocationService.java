package demo.service;

import demo.domain.SupplyLocation;

import java.util.List;

/**
 * Created by Xinkang on 1/25/18.
 */
public interface SupplyLocationService {
    List<SupplyLocation> saveSupplyLocationsZipContains504(List<SupplyLocation> locations);
}