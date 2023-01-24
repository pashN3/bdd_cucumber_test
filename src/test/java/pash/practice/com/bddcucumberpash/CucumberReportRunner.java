package pash.practice.com.bddcucumberpash;

import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.File;
import net.masterthought.cucumber.Configuration;
import java.util.ArrayList;
import java.util.List;

public class CucumberReportRunner extends Cucumber {

    private static final String PROJECT_NAME = "Cucumber and Spring boot example";
    private static final String BUILD_NUMBER = "0.0.1";
    private static final String BRANCH_NAME = "Master";

    public CucumberReportRunner(Class clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier){
        super.run(notifier);
        generateReport();
    }

    public static void generateReport() {
        File reportOutputDirectory = new File("target/classes/static");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-report.json");

        Configuration configuration = new Configuration(reportOutputDirectory, PROJECT_NAME);
        configuration.setBuildNumber(BUILD_NUMBER);
        configuration.addClassifications("Build Number", configuration.getBuildNumber());
        configuration.addClassifications("Branch Name", BRANCH_NAME);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
