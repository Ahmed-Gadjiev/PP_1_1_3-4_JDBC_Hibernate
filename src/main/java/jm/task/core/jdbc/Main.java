package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl() {
            @Override
            public void saveUser(String name, String lastName, byte age) {
                super.saveUser(name, lastName, age);
                System.out.println("User с именем " + name + " добавлен в базу данных");
            }
        };

        userService.createUsersTable();

        for (int i = 0; i < 4; i++) {
            userService.saveUser("name" + i, "lastName" + i, (byte) 0);
        }

        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
