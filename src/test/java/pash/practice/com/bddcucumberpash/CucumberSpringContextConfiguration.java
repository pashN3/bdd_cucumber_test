package pash.practice.com.bddcucumberpash;

import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(CucumberSpringContextConfiguration.class);

    @Before
    public void setUp(){
        LOG.info("------------Initialised Spring Context for Test Execution-------------------");
    }
}
