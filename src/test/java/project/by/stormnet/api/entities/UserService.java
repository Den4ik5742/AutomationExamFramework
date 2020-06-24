package project.by.stormnet.api.entities;

import by.stormnet.core.FrameworkHttpClient;
import by.stormnet.core.Response;

public class UserService extends AbstractService {
    private FrameworkHttpClient client = new FrameworkHttpClient();
    private String createUserUrl = secondBaseUrl + "/api/users/";
    private String getUserUrl = secondBaseUrl + "/api/users/2";
    private String updateUserUrl = secondBaseUrl + "/api/users/2";
    private String deleteUserUrl = secondBaseUrl + "/api/users/2";

    public Response getUser(){
        System.out.println("User created");
        return client.doGet(getUserUrl);
    }
    public Response postUser(String bodyForNewUser){
        System.out.println("User created");
        return client.doPost(createUserUrl, bodyForNewUser);
    }

    public Response putUser(String bodyForUpdateUser){
        System.out.println("User updated");
        return client.doPut(updateUserUrl, bodyForUpdateUser);
    }

    public Response deleteUser(){
        System.out.println("User deleted");
        return client.doDelete(deleteUserUrl);
    }
}
