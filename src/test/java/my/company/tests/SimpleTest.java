package my.company.tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.Tag;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 24.11.13
 */
public class SimpleTest {

    @Test
    @Tag("XRAY:XT")
    @Description("Simple test 2=2")
    public void simpleTest() throws Exception {
        assertThat(2, is(2));
    }

    @Step
    public void checkThat2is2() {
        assertThat(2, is(2));
    }

    @Test
    @XrayId("XT-2")
    @Description("Simple test with steps.")
    public void simpleTestWithSteps() throws Exception {
        checkThat2is2();
    }

    @Attachment
    public String makeAttach() {
        return "yeah, 2 is 2";
    }

    @Test
    @JiraIssue({"EP-1"})
    @XrayId("XT-1")
    public void simpleTestWithAttachments() throws Exception {
        assertThat(2, is(2));
        makeAttach();
    }

    @Tag("XRAY:XT")
    @Description("Test shows CSV attachment")
    @Test
    public void csvAttachmentTest() throws Exception {
        saveCsvAttachment();
    }

    @Test
    @XrayId("XT-3")
    public void instCheck() {
        final Object object = null;

        if (object instanceof Long) {
            System.out.println(object);
        }
    }

    @Test
    public void extracktProjectKey() {
        String ik = "ASD-BG-13";
        String pk = extractProjectKey(ik);
        System.out.println(pk);
    }

    private static String extractProjectKey(final String issueKey) {
        if (issueKey == null || "".equals(issueKey)) {
            return "";
        }
        return issueKey.substring(0, issueKey.lastIndexOf("-"));
    }

    @Attachment(value = "Sample csv attachment", type = "text/csv")
    public byte[] saveCsvAttachment() throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource("sample.csv");
        if (resource == null) {
            fail("Couldn't find resource 'sample.csv'");
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }
}
