package model.User.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {


    @JsonProperty("gender")
    private String gender;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private String status;

    public String getGender(){
        return gender;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getStatus(){
        return status;
    }
}
