@consultar-mascota-id
Feature: Consultar Mascota por ID

  Background:
    * url baseUrl
    * def petData = read('classpath:data/pet-data.json')
    * def petSchema = read('classpath:schemas/pet-schema.json')

  Scenario: CP02 - Consultar la mascota ingresada previamente por ID
    # Crear mascota primero
    * def randomId = Math.floor(Math.random() * 1000000) + 1
    * set petData.newPet.id = randomId

    Given path endpoints.pet
    And request petData.newPet
    When method POST
    Then status 200

    * def petId = response.id

    # Consultar la mascota por ID
    Given path endpoints.pet, petId
    When method GET
    Then status 200
    And match response contains petSchema
    And match response.id == petId
    And match response.name == 'Firulais QA Test'
    And match response.status == 'available'
