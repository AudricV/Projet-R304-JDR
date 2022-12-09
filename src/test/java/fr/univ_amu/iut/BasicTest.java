package fr.univ_amu.iut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Basic test to test configuration
 */
class BasicTest {
    @Mock
    private PrintStream systemOutput;

    @BeforeEach
    public void setUpApp() throws Exception {
        openMocks(this).close();
        System.setOut(systemOutput);
    }

    @Test
    void assertSystemOutputCheckWorks() {
        System.out.println("Hello");
        verify(System.out).println("Hello");
    }
}