package model.User.Request.Builder;

import model.User.Request.UserRequest;

public abstract class UserRequestBuilder {
    protected UserRequest user;

    public UserRequest getUser (){
        return user;
    }

    public abstract  void Buildgender();
    public abstract  void Buildname();
    public abstract  void Buildemail();
    public abstract  void Buildstatus();


}
