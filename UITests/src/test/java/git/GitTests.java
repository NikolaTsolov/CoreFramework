package git;

import automation.structure.TestHandler;
import org.junit.Test;
import pages.GitWelcomePage;

public class GitTests extends TestHandler {
    @Test
    public void testGitSearch() {
        final GitWelcomePage gitWelcomePage = getGitWelcomePage();
        gitWelcomePage.searchForParticularUser("ntsolov");
    }
}
