package org.program.preciousstonemanager.database;

import org.apache.log4j.Logger;
import org.program.preciousstonemanager.models.PreciousStone;
import org.program.preciousstonemanager.models.SemiPreciousStone;
import org.program.preciousstonemanager.models.Stone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseWorker {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String databaseName = "jdbc:mysql://localhost:3306/PreciousStoneController";
    private static final String user = "admin";
    private static final String password = "password";

    public static void writeIntoDatabase(Stone stone, Boolean addIntoNecklace) {
        logger.info("Запис каменя у базу даних");
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(databaseName, user, password);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Stones VALUES('" + stone.getName() + "'," +
                    "                                '" + stone.getClass().getSimpleName() + "'," +
                    "                                '" + stone.getColor() + "'," +
                    "                                " + stone.getWeight() + "," +
                    "                                " + stone.getValue() + "," +
                    "                                " + stone.getTransparency() + "," +
                    "                                " + addIntoNecklace + ")";
            statement.executeUpdate(query);
            logger.info("Запис каменя у базу даних відбувся успішно");
        } catch (Exception e) {
            logger.info("Помилка запису каменя у базу даних:" + e);
        }
    }

    public static List<Stone> readFromDatabase(Boolean isNecklace) {
        logger.info("Зчитування каменів з бази даних");
        List<Stone> storage = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(databaseName, user, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Stones";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String type = resultSet.getString("Type");
                String color = resultSet.getString("Color");
                int weight = resultSet.getInt("Weight");
                int value = resultSet.getInt("Value");
                int transparency = resultSet.getInt("Transparency");
                boolean isInNecklace = resultSet.getBoolean("IsInNecklace");

                if (isNecklace && isInNecklace) {
                    if (type.equals(PreciousStone.class.getSimpleName())) {
                        storage.add(new PreciousStone(name, color, weight, value, transparency, isInNecklace));
                    } else if (type.equals(SemiPreciousStone.class.getSimpleName())) {
                        storage.add(new SemiPreciousStone(name, color, weight, value, transparency, isInNecklace));
                    }
                } else if (!isNecklace && !isInNecklace) {
                    if (type.equals(PreciousStone.class.getSimpleName())) {
                        storage.add(new PreciousStone(name, color, weight, value, transparency, isInNecklace));
                    } else if (type.equals(SemiPreciousStone.class.getSimpleName())) {
                        storage.add(new SemiPreciousStone(name, color, weight, value, transparency, isInNecklace));
                    }
                }
            }
            logger.info("Зчитування каменів з бази даних відбулося успішно");
        } catch (Exception e) {
            logger.info("Помилка зчитування каменів з бази даних:" + e);
        }
        return storage;
    }

    public static void changeStone(Stone oldStone, Stone newStone) {
        logger.info("Зміна каменя в базі даних");
        try {
            Class.forName(driverName);
            try (Connection connection = DriverManager.getConnection(databaseName, user, password)) {
                Statement statement = connection.createStatement();

                String deleteQuery = "DELETE FROM Stones WHERE Name = '" + oldStone.getName() + "' AND " +
                        "Type = '" + oldStone.getClass().getSimpleName() + "' AND " +
                        "Color = '" + oldStone.getColor() + "' AND " +
                        "Weight = " + oldStone.getWeight() + " AND " +
                        "Value = " + oldStone.getValue() + " AND " +
                        "Transparency = " + oldStone.getTransparency() + ";";
                statement.executeUpdate(deleteQuery);
                logger.info("Видалення старого каменя з бази даних відбулося успішно");

                String insertQuery = "INSERT INTO Stones (Name, Type, Color, Weight, Value, Transparency) VALUES (" +
                        "'" + newStone.getName() + "', " +
                        "'" + newStone.getClass().getSimpleName() + "', " +
                        "'" + newStone.getColor() + "', " +
                        newStone.getWeight() + ", " +
                        newStone.getValue() + ", " +
                        newStone.getTransparency() + ");";
                statement.executeUpdate(insertQuery);
                logger.info("Додавання зміненого каменя до бази даних відбулося успішно");
            }
        } catch (Exception e) {
            logger.info("Помилка зміни каменя в базі даних: " + e);
        }
    }

    public static void changeStoneStorage(Stone stone) {
        logger.info("Перенесення каменя в інше сховище в базі даних");
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(databaseName, user, password);
            Statement statement = connection.createStatement();
            String query = "UPDATE Stones" +
                    "       SET IsInNecklace = IF(IsInNecklace = 1, 0, 1)" +
                    "       WHERE Name = '" + stone.getName() + "' AND " +
                    "       Type = '" + stone.getClass().getSimpleName() + "' AND " +
                    "       Color = '" + stone.getColor() + "' AND " +
                    "       Weight = " + stone.getWeight() + " AND " +
                    "       Value = " + stone.getValue() + " AND " +
                    "       Transparency = " + stone.getTransparency() + ";";
            statement.executeUpdate(query);
            logger.info("Перенесення каменя в інше сховище в базі даних відбулося успішно");
        } catch (Exception e) {
            logger.info("Помилка перенесення каменя в інше сховище в базі даних:" + e.toString());
        }
    }

    public static void deleteStone(Stone stone) {
        logger.info("Видалення каменя з бази даних");
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(databaseName, user, password);
            Statement statement = connection.createStatement();
            String query = "DELETE FROM Stones WHERE Name = '" + stone.getName() + "' AND" +
                    "                                   Type = '" + stone.getClass().getSimpleName() + "' AND" +
                    "                                   Color = '" + stone.getColor() + "' AND" +
                    "                                   Weight = " + stone.getValue() + " AND" +
                    "                                   Value = " + stone.getValue() + " AND" +
                    "                                   Transparency = " + stone.getTransparency() + ";";
            statement.executeUpdate(query);
            logger.info("Видалення каменя з бази даних відбулося успішно");
        } catch (Exception e) {
            logger.info("Помилка видалення каменя з бази даних:" + e);
        }
    }
}
