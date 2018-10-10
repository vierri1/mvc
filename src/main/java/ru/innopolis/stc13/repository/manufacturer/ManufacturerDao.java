package ru.innopolis.stc13.repository.manufacturer;


import ru.innopolis.stc13.pojo.Manufacturer;

import java.util.List;

public interface ManufacturerDao {

    boolean add(Manufacturer manufacture);

    Manufacturer getById(Integer id);

    boolean update(Manufacturer mobile);

    boolean deleteById(Integer id);

    List<Manufacturer> getAll();
}
