package model.User.Request.Builder;

import com.github.javafaker.Faker;
import model.User.Request.UserRequest;

public class BuildNewUserFake extends UserRequestBuilder{

    private static final Faker faker = new Faker();

    public BuildNewUserFake(){
        super.user=new UserRequest();
    }

    public void Buildemail() {
        user.setEmail(faker.internet().emailAddress());
    }

    public void Buildgender() {
        user.setGender("male");
    }

    public void Buildstatus() {
        user.setStatus("Active");
    }

    public void Buildname() {
        user.setName(faker.gameOfThrones().dragon());
    }
}
