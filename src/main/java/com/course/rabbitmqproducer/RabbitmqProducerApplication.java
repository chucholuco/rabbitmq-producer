package com.course.rabbitmqproducer;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.entity.Furniture;
import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
@AllArgsConstructor
public class RabbitmqProducerApplication implements CommandLineRunner {


//    private HelloRabbitProducer producer;
    //private FixedRateProducer producer;
    //private EmployeeJsonProducer producer;
//    private HumanResourceProducer producer;
//    private final PictureProducer producer;
      //private final PictureProducerTwo producer;
//    private FurnitureProducer producer;
//    private MyPictureProducer producer;
//    private RetryPictureProducer producer;
//    private RetryEmployeeProducer producer;
//    private SpringPictureProducer producer;
    private SpringEmployeeProducer producer;

    //valid sources
    private final List<String> SOURCES = List.of("mobile", "web");
    //valid types
    private final List<String> TYPES = List.of("jpg", "png", "svg");

    private final List<String> COLORS = List.of("white", "red", "green");
    private final List<String> MATERIALS = List.of("wood", "plastic", "steel");

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            var employee = new Employee("emp-" + i, null, LocalDate.of(1990, 12, i + 1));
            producer.sendMessage(employee);
        }
    }

//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 1; i++) {
//            var picture = Picture.builder()
//                    .name("Retry picture " + i)
//                    .type(TYPES.get(i % TYPES.size()))
//                    .source(SOURCES.get(i % SOURCES.size()))
//                    .size(ThreadLocalRandom.current().nextLong(9001, 10001))
//                    .build();
//
//            producer.sendMessage(picture);
//        }
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            var furniture = Furniture.builder()
//                    .name("Furniture " + 1)
//                    .color(COLORS.get(i % COLORS.size()))
//                    .material(MATERIALS.get(i % MATERIALS.size()))
//                    .price(new BigDecimal(i))
//                    .build();
//
//            producer.sendMessage(furniture);
//        }
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            var picture = Picture.builder()
//                    .name("Picture " + i)
//                    .type(TYPES.get(i % TYPES.size()))
//                    .source(SOURCES.get(i % SOURCES.size()))
//                    .size(ThreadLocalRandom.current().nextLong(1, 1000))
//                    .build();
//
//            producer.sendMessage(picture);
//        }
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        producer.sendHello("Jesus Tapia " + Math.random());
//        for (int i = 0; i < 5; i++) {
//            var employee = new Employee("emp" + i, "Employee" + i, LocalDate.now());
//            producer.sendMessage(employee);
//        }
//    }
}
