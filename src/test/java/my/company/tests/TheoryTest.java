package my.company.tests;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Step;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 29.11.13
 */
@RunWith(Theories.class)
public class TheoryTest {

    @DataPoint
    public static String USERNAME1 = "optimus";
    @DataPoint
    public static String USERNAME2 = "optimus-prime";

    @Theory
    public void usernameNotContainsSlash(String username) {
        checkUserName(username);
    }

    @Step
    public void checkUserName(String username) {
        assertThat(username, not(containsString("/")));
    }
}
