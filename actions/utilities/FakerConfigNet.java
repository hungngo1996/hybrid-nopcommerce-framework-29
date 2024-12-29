package utilities;
import net.datafaker.Faker;

public class FakerConfigNet {
    private Faker faker = new Faker();
    public static FakerConfigNet getFaker(){
        return new FakerConfigNet();
    }
    //Email
    public String getEmail(){
        return faker.internet().emailAddress();
    }
    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }
    public String getFullName(){
        return faker.name().fullName();
    }
    public String getCity(){
        return faker.address().city();
    }
    public String getAddress(){
        return faker.address().fullAddress();
    }
    public String getCompanyName(){
        return faker.company().name();
    }
    public String getZipCode(){
        return faker.address().zipCode();
    }
    public String getphoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }
    public String getPassword(){
        return faker.internet().password(10,20);
    }
}
