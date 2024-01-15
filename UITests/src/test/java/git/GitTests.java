package git;

import automation.structure.TestHandler;
import org.junit.Assert;
import org.junit.Test;
import pages.GitWelcomePage;

public class GitTests extends TestHandler {
    @Test
    public void testGitFollowUserFlow() {
        final GitWelcomePage gitWelcomePage = getGitWelcomePage();
        gitWelcomePage.navigateToPage();
        gitWelcomePage.searchForParticularUser("NikolaTsolov");
        gitWelcomePage.clickFollowButton();
        Assert.assertEquals("https://github.com/NikolaTsolov", getCurrentURL());
    }
}
