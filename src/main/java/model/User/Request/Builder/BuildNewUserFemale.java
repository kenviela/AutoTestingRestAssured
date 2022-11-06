package model.User.Request.Builder;

import model.User.Request.UserRequest;

public class BuildNewUserFemale extends UserRequestBuilder{

    public BuildNewUserFemale(){
        super.user=new UserRequest();
    }

    public void Buildemail() {
        user.setEmail("alicia@gmail.com");
    }

    public void Buildgender() {
        user.setGender("female");
    }

    public void Buildstatus() {
        user.setStatus("Active");
    }

    public void Buildname() {
        user.setName("Alicia Duran");
    }
}
