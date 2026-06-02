@crear-mascota
Feature: Crear Mascota en Petstore

  Background:
    * url baseUrl
    * def petData = read('classpath:data/pet-data.json')
    * def petSchema = read('classpath:schemas/pet-schema.json')

  Scenario: CP01 - Añadir una nueva mascota a la tienda exitosamente
    # Generar ID único para la mascota
    * def randomId = Math.floor(Math.random() * 1000000) + 1
    * set petData.newPet.id = randomId

    Given path endpoints.pet
    And request petData.newPet
    When method POST
    Then status 200
    And match response contains petSchema
    And match response.id == randomId
    And match response.name == 'Firulais QA Test'
    And match response.status == 'available'

    # Guardar el ID para usar en otros tests
    * def petId = response.id
    * karate.set('sharedPetId', petId)
