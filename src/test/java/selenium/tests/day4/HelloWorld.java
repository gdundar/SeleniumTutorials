package selenium.tests.day4;


import com.github.javafaker.Faker;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Faker faker = new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());

        System.out.println(faker.chuckNorris().fact());

    }
}
