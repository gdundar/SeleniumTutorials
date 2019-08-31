package API_Murodil.cucumberApi.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/default-cucumber-reports"
        },
        tags = {"@ApiPost"},
        features = {"/Users/yasinbekar/IdeaProjects/SeleniumTutorials/src/test/java/API_Murodil/cucumberApi/features" //to specify where are the features
        },
        //feature contains scenarios
        //every scenario is like a test
        //where is the implementation for features
        glue = {"/Users/yasinbekar/IdeaProjects/SeleniumTutorials/src/test/java/API_Murodil/cucumberApi/stepDefinitions"},
        //dry run - to generate step definitions automatically
        //you will see them in the console output
        dryRun = false


)

public class CukesRunner {
}
