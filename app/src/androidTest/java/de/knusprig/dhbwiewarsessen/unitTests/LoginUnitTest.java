package de.knusprig.dhbwiewarsessen.unitTests;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import de.knusprig.dhbwiewarsessen.controller.activities.MainActivity;
import de.knusprig.dhbwiewarsessen.steps.BasicSteps;
import de.knusprig.dhbwiewarsessen.steps.RegisterSteps;

public class LoginUnitTest {
    @Rule
    public ActivityTestRule activity = new ActivityTestRule<>(MainActivity.class);

    BasicSteps bs = new BasicSteps();
    RegisterSteps rs = new RegisterSteps();

    @Test
    public void correctLogIn() throws Throwable {
        final String username = "TvRXVII";
        final String password = "Thimo123";
        final String name = "Thimo von Rauchhaupt";

        bs.userNavigatesTo("LogIn");
        bs.userEntersIntoInputFieldWithId(username, "username");
        bs.userEntersIntoInputFieldWithId(password, "password");
        bs.userClicksOnButtonWithId("LogIn");
        rs.userShouldBeLoggedInAs(name);
    }

    @Test
    public void incorrectPassword() throws Throwable {
        final String username = "TvRXVII";
        final String password = "falsch";
        final String errorMessage = "Login Failed";

        bs.userNavigatesTo("LogIn");
        bs.userEntersIntoInputFieldWithId(username, "username");
        bs.userEntersIntoInputFieldWithId(password, "password");
        bs.userClicksOnButtonWithId("LogIn");
        bs.userShouldSeeError(errorMessage);
    }

    @Test
    public void incorrectLogIn() throws Throwable {
        final String username = "GeorgWenzel";
        final String password = "falsch";
        final String errorMessage = "Login Failed";

        bs.userNavigatesTo("LogIn");
        bs.userEntersIntoInputFieldWithId(username, "username");
        bs.userEntersIntoInputFieldWithId(password, "password");
        bs.userClicksOnButtonWithId("LogIn");
        bs.userShouldSeeError(errorMessage);
    }
}
