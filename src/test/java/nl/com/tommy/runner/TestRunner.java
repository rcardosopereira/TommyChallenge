package nl.com.tommy.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "nl.com.tommy.steps",
        plugin = {"json:target/cucumber.json"}
)

public class TestRunner {
}