@consultar-mascota-status
Feature: Consultar Mascota por Status

  Background:
    * url baseUrl
    * def petData = read('classpath:data/pet-data.json')
    * def petSchema = read('classpath:schemas/pet-schema.json')

  Scenario: CP04 - Consultar la mascota modificada por estatus (sold)
    # Crear mascota
    * def randomId = Math.floor(Math.random() * 1000000) + 1
    * set petData.newPet.id = randomId

    Given path endpoints.pet
    And request petData.newPet
    When method POST
    Then status 200

    * def petId = response.id

    # Actualizar la mascota a status 'sold'
    * set petData.updatePet.id = petId

    Given path endpoints.pet
    And request petData.updatePet
    When method PUT
    Then status 200

    # Consultar mascotas por status 'sold'
    Given path endpoints.petFindByStatus
    And param status = 'sold'
    When method GET
    Then status 200
    And match response == '#[]'
    And match each response contains { status: 'sold' }

    # Verificar que nuestra mascota está en la lista
    * def petFound = karate.jsonPath(response, "$[?(@.id==" + petId + ")]")
    * match petFound != []
    * match petFound[0].name == 'Firulais Actualizado'
    * match petFound[0].status == 'sold'
