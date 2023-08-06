package runner;


import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
        },
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        dryRun = true,
        tags = "@wip"

)
public class Runner {


}