package ru.innopolis.stc13.repository.mobile;

import ru.innopolis.stc13.pojo.Mobile;

import java.util.List;

public interface MobileDao {

    boolean add(Mobile mobile);

    Mobile getById(Integer id);

    boolean update(Mobile mobile);

    boolean deleteById(Integer id);

    List<Mobile> getAll();

    List<Mobile> getAllWithManufacturers(Integer manufacturerId);
}

