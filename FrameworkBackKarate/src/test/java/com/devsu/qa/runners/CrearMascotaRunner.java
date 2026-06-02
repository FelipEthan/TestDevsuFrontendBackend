package com.devsu.qa.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class CrearMascotaRunner {

    @Test
    public void testCrearMascota() {
        Results results = Runner.path("classpath:features/pet/crear-mascota.feature")
                .tags("@crear-mascota")
                .outputCucumberJson(true)
                .reportDir("target/karate-reports")
                .parallel(1);

        System.out.println("Crear Mascota - Fallidos: " + results.getFailCount() + " de 1");
    }
}
