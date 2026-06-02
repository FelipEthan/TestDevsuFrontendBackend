package com.devsu.qa.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class ConsultarMascotaIdRunner {

    @Test
    public void testConsultarMascotaId() {
        Results results = Runner.path("classpath:features/pet/consultar-mascota-id.feature")
                .tags("@consultar-mascota-id")
                .outputCucumberJson(true)
                .reportDir("target/karate-reports")
                .parallel(1);

        System.out.println("Consultar Mascota por ID - Fallidos: " + results.getFailCount() + " de 1");
    }
}
