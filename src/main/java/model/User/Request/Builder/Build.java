package model.User.Request.Builder;

import model.User.Request.UserRequest;

public class Build {
    public UserRequestBuilder userRequestBuilder;
    public void setUserRequestBuilder (UserRequestBuilder user){
        userRequestBuilder=user;
    }
    public UserRequest getUserRequest(){
        return userRequestBuilder.getUser();
    }

    public  void buildUserRequest(){
        userRequestBuilder.Buildemail();
        userRequestBuilder.Buildgender();
        userRequestBuilder.Buildname();
        userRequestBuilder.Buildstatus();
    }
}
