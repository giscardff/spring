package org.aioba.test;

import java.util.List;

public interface BusinessRepository {

    public void insert(Business business);
    public void update(Business business);
    public void delete(Business business);
    public List<Business> list();
    public List<Business> listAll();

}
