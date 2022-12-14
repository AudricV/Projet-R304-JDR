package fr.univ_amu.iut;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.io.PrintStream;

import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Base test to test classes, which set up the system output mocking.
 *
 * <p>
 * Test classes which require system outputs should extend this class.
 * </p>
 */
class BasicTest {
    @Mock
    protected PrintStream systemOutput;

    @BeforeEach
    public void setUpApp() throws Exception {
        openMocks(this).close();
        System.setOut(systemOutput);
    }
}