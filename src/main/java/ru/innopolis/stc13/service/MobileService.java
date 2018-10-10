package ru.innopolis.stc13.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.repository.mobile.MobileDao;

import java.util.List;

@Service
public class MobileService {
    private MobileDao mobileDao;

    @Autowired
    public void setMobileDao(MobileDao mobileDao) {
        this.mobileDao = mobileDao;
    }

    public List<Mobile> getAllWithManufacturers(Integer manufacutrerId) {
        return mobileDao.getAllWithManufacturers(manufacutrerId);
    }

    public void add(Mobile mobile) {
        mobileDao.add(mobile);
    }

}
