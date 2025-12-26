package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // Настройки подключения - ИЗМЕНИТЕ ЭТИ ЧЕТЫРЕ ЗНАЧЕНИЯ НА СВОИ
    private static final String DB_URL = "jdbc:mysql://localhost:3306/kata_db"; // Замените имя_вашей_базы
    private static final String DB_USERNAME = "root"; // Обычно 'root', но может быть другой
    private static final String DB_PASSWORD = "SHI18FCKKK"; // Ваш пароль от MySQL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver"; // Драйвер для MySQL 8+

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Соединение с базой данных установлено!");
        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка: Не удалось загрузить драйвер базы данных!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Ошибка: Не удалось подключиться к базе данных!");
            System.err.println("Проверьте: 1) Запущен ли MySQL сервер 2) Правильность URL, имени и пароля");
            e.printStackTrace();
        }
        return connection;
    }
}

