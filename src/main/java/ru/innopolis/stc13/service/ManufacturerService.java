package ru.innopolis.stc13.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc13.pojo.Manufacturer;
import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.repository.manufacturer.ManufacturerDao;

import java.util.List;

@Service
public class ManufacturerService {
    private ManufacturerDao manufacturerDao;

    @Autowired
    public void setManufacturerDao(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    public ManufacturerService(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    public Manufacturer get(int manId) {
        return manufacturerDao.getById(manId);
    }
}
