package project.by.stormnet.api;

import by.stormnet.core.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.by.stormnet.api.entities.UserService;

public class UserTest {
    private UserService userService = new UserService();
    @Test
    public void getUserTest(){
        Response response = userService.getUser();
        int code = response.getCode();
        Assert.assertTrue(code == 200, "User not deleted");
    }

    @Test
    public void postUserTest(){
        String bodyForNewUser = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";
        Response response = userService.postUser(bodyForNewUser);
        int code = response.getCode();
        boolean containsUserName = response.getBody().contains("morpheus");
        Assert.assertTrue(code == 201 && containsUserName, "User not created!");
    }


    @Test
    public void putUserTest(){
        String bodyForUpdateUser = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"engineer\"\n" +
                "}";
        Response response = userService.putUser(bodyForUpdateUser);
        int code = response.getCode();
        boolean containsUserJob = response.getBody().contains("engineer");
        Assert.assertTrue(code == 200 && containsUserJob, "User not updated");
    }

    @Test
    public void deleteUserTest(){
        Response response = userService.deleteUser();
        int code = response.getCode();
        Assert.assertTrue(code == 204, "User not deleted");
    }
}
