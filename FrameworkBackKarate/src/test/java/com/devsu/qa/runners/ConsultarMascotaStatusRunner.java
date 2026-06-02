package com.devsu.qa.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class ConsultarMascotaStatusRunner {

    @Test
    public void testConsultarMascotaStatus() {
        Results results = Runner.path("classpath:features/pet/consultar-mascota-status.feature")
                .tags("@consultar-mascota-status")
                .outputCucumberJson(true)
                .reportDir("target/karate-reports")
                .parallel(1);

        System.out.println("Consultar Mascota por Status - Fallidos: " + results.getFailCount() + " de 1");
    }
}
