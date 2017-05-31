package org.aioba.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
@Scope("prototype")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessRepository repository;

    public BusinessServiceImpl(){};

    @Transactional
    public void createBusiness(Business business) {
        repository.insert(business);
    }

    @Transactional
    public void updateBusiness(Business business) {
        repository.update(business);
    }

    @Transactional
    public void deleteBusiness(Business business) {
        repository.delete(business);
    }

    @Transactional
    public List<Business> listBusiness() {
        return repository.list();
    }

    public List<Business> listAllBusiness() {
        return repository.listAll();
    }


}
