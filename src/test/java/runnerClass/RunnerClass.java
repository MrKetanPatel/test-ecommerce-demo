package runnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {"pretty",
                "json:target/MyReports/report.json"}
        //publish = true
)
public class RunnerClass  {

}