import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:build/cucumber-reports", "json:build/cucumber.json"},
    features = {"src/test/resources/features"}, glue = {"com.viplav.utils.spring.codegenerator.stepdef"}, monochrome = true
)
public class RunCucumberTest {
}