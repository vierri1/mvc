package ru.innopolis.stc13.repository.mobile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.stc13.ConnectionManager.ConnectionManager;
import ru.innopolis.stc13.ConnectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13.pojo.Manufacturer;
import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.repository.manufacturer.ManufacturerDao;
import ru.innopolis.stc13.repository.manufacturer.ManufacturerDaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MobileDaoImpl implements MobileDao {

    private ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    private ManufacturerDao manufacturerDao;

    @Autowired
    public void setManufacturerDao(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    @Override
    public boolean add(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO mobile VALUES (DEFAULT, ?, ?, ?)")) {
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Mobile getById(Integer id) {
        Mobile mobile = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM mobile WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer manufacturer_id = resultSet.getInt("manufacturer_id");
                Manufacturer manufacturer = manufacturerDao.getById(manufacturer_id);
                mobile = new Mobile(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getFloat("price"),
                        manufacturer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobile;
    }

    @Override
    public boolean update(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE mobile SET model=?, price=?, manufacturer_id=? WHERE id=?")) {
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer().getId());
            preparedStatement.setInt(4, mobile.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM mobile WHERE id=?"
             )) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Mobile> getAll() {
        List<Mobile> mobiles = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM mobile")) {
            mobiles = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String model = resultSet.getString("model");
                Float price = resultSet.getFloat("price");
                Integer manufacturer_id = resultSet.getInt("manufacturer_id");
                mobiles.add(new Mobile(id, model, price, manufacturerDao.getById(manufacturer_id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobiles;
    }

    @Override
    public List<Mobile> getAllWithManufacturers(Integer manufacturerId) {
        List<Mobile> mobiles = null;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile", "postgres", "root");
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM mobile WHERE manufacturer_id=?")) {
            mobiles = new ArrayList<>();
            preparedStatement.setInt(1, manufacturerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String model = resultSet.getString("model");
                Float price = resultSet.getFloat("price");
                Integer manufacturer_id = resultSet.getInt("manufacturer_id");
                mobiles.add(new Mobile(id, model, price, manufacturerDao.getById(manufacturer_id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobiles;
    }
}
