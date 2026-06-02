package com.devsu.qa.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class ActualizarMascotaRunner {

    @Test
    public void testActualizarMascota() {
        Results results = Runner.path("classpath:features/pet/actualizar-mascota.feature")
                .tags("@actualizar-mascota")
                .outputCucumberJson(true)
                .reportDir("target/karate-reports")
                .parallel(1);

        System.out.println("Actualizar Mascota - Fallidos: " + results.getFailCount() + " de 1");
    }
}
