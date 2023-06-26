package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker {
    @Test
    public void name() {
        Faker faker = new Faker();

        System.out.println(faker.name().firstName());

        System.out.println(faker.name().lastName());

        System.out.println(faker.name().fullName());

        System.out.println(faker.phoneNumber().cellPhone());

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.number().digits(15));
    }




}
