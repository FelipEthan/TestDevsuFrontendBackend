function fn() {
    // Leer la variable de entorno (default: 'dev')
    var env = karate.env || 'dev';
    karate.log('Entorno seleccionado:', env);

    // Configuración base
    var config = {
        baseUrl: 'https://petstore.swagger.io/v2',
        timeout: 10000,
        retryEnabled: true,
        retryCount: 2
    };

    // Configuraciones específicas por ambiente
    if (env === 'dev') {
        config.baseUrl = 'https://petstore.swagger.io/v2';
    } else if (env === 'qa') {
        config.baseUrl = 'https://petstore.swagger.io/v2';
    } else if (env === 'prod') {
        config.baseUrl = 'https://petstore.swagger.io/v2';
    }

    // Headers comunes
    config.headers = {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    };

    // Endpoints
    config.endpoints = {
        pet: '/pet',
        petFindByStatus: '/pet/findByStatus'
    };

    // Datos de prueba
    config.testData = {
        validPetId: null,  // Se generará dinámicamente
        invalidPetId: 999999999,
        statusSold: 'sold',
        statusAvailable: 'available',
        statusPending: 'pending'
    };

    // Configurar lectura de schemas
    karate.configure('connectTimeout', config.timeout);
    karate.configure('readTimeout', config.timeout);

    return config;
}
