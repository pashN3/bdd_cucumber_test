package pash.practice.com.bddcucumberpash.stepdefs;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import pash.practice.com.bddcucumberpash.model.User;

import java.util.List;

public class UserSteps extends AbstractSteps implements En{

    public UserSteps(){
        Given("users creates an account with following details", (DataTable userDt)->{
            testContext().reset();
            List<User> createUser = userDt.asList(User.class);
            super.testContext()
                    .setPayload(createUser.get(0));
        });

        Then("user is created", () ->{
            String getUserUrl = "/users";
            // AbstractSteps class makes the POST call and stores response in TestContext
            executeGet(getUserUrl);
        });

    }
}
