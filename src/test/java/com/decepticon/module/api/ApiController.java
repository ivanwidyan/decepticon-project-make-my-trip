package com.decepticon.module.api;

import com.decepticon.module.api.createuser.CreateUserRequest;
import com.decepticon.module.api.createuser.CreateUserResponse;
import com.decepticon.module.api.getuser.GetSingleUserResponse;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ApiController {
    public static GetSingleUserResponse getUser () {
        Response response =  given().
                    header("Accept", "application/json").
                when().
                    get("https://reqres.in/api/users/1");

        return response.getBody().as(GetSingleUserResponse.class);
    }

    public static CreateUserResponse createUser() {
        CreateUserRequest request = new CreateUserRequest();
        request.name = "name";
        request.job = "job";
        Response response =  given().
                    header("Content-Type", "application/json").
                    header("Accept", "application/json").
                    body(request).
                when().
                    post("https://reqres.in/api/users");
        return response.getBody().as(CreateUserResponse.class);
    }

}