package services;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CucumberTest {

    @Test
    public void emptyCarRepositoryIsImplementedTest() {
        assertNotNull(new CarServiceTest());
    }
}
