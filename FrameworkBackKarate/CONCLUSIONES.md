# CONCLUSIONES Y HALLAZGOS

- La API de Petstore requirió ajustes en las validaciones (línea 35 de consultar-mascota-status.feature) debido a que devuelve múltiples mascotas con el mismo status, requiriendo usar `match each` en lugar de `contains only` para validar correctamente arrays de longitud
- La arquitectura del framework basada en  (features, data, schemas, runners) facilitó la adaptación rápida
- Los 4 escenarios de prueba end-to-end (POST, GET by ID, PUT, GET by status) validaron correctamente el ciclo de vida completo de una mascota en Petstore.
