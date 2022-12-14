package fr.univ_amu.iut;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;

/**
 * Test class to verify configuration of system output mock testing.
 */
class SampleTest extends BasicTest {
    @Test
    void assertSystemOutputCheckWorks() {
        System.out.println("Hello");
        verify(System.out).println("Hello");
    }
}
