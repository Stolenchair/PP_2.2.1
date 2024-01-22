package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Алёша", "Алексин", "pudge@mal.ru");
      Car car1 = new Car("Chevrolet Camaro", 1);
      car1.setUser(user1);
      userService.add(user1);
      userService.add(car1);

      User user2 = new User("Балбес", "Дебилов", "znatok@mail.ru");
      Car car2 = new Car("Москвич", 2);
      car2.setUser(user2);
      userService.add(user2);
      userService.add(car2);

      User user3 = new User("Барак", "Барабама", "biden@mal.ru");
      Car car3 = new Car("Бэтмобилка", 3);
      car3.setUser(user3);
      userService.add(user3);
      userService.add(car3);

      User user4 = new User("Месси", "Роналдов", "ankara@mal.ru");
      Car car4 = new Car("Airbus", 4);
      car4.setUser(user4);
      userService.add(user4);
      userService.add(car4);

      User ownerCar = userService.getUserByCar("Airbus",4);
      System.out.println(ownerCar.getFirstName());

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
