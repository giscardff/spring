package org.aioba.test;

import java.util.List;
import java.util.UUID;

public interface BusinessService {

    void createBusiness(Business business);
    void updateBusiness(Business business);
    void deleteBusiness(Business business);
    List<Business> listBusiness();
    List<Business> listAllBusiness();

}
