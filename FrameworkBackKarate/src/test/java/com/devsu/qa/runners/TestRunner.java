package com.devsu.qa.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestRunner {

    @Test
    public void testAll() {
        Results results = Runner.path("classpath:features/pet")
                .outputCucumberJson(true)
                .outputJunitXml(true)
                .reportDir("target/karate-reports")
                .parallel(1);

        System.out.println("========================================");
        System.out.println("RESUMEN DE EJECUCION - PETSTORE API");
        System.out.println("========================================");
        System.out.println("Total Escenarios: " + results.getScenariosTotal());
        System.out.println("Fallidos: " + results.getFailCount());
        System.out.println("========================================");
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
