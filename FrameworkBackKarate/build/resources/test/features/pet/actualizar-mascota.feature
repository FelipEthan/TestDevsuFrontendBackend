@actualizar-mascota
Feature: Actualizar Mascota

  Background:
    * url baseUrl
    * def petData = read('classpath:data/pet-data.json')
    * def petSchema = read('classpath:schemas/pet-schema.json')

  Scenario: CP03 - Actualizar el nombre de la mascota y el estatus a vendido
    # Crear mascota primero
    * def randomId = Math.floor(Math.random() * 1000000) + 1
    * set petData.newPet.id = randomId

    Given path endpoints.pet
    And request petData.newPet
    When method POST
    Then status 200

    * def petId = response.id

    # Actualizar la mascota - cambiar nombre y status a 'sold'
    * set petData.updatePet.id = petId

    Given path endpoints.pet
    And request petData.updatePet
    When method PUT
    Then status 200
    And match response contains petSchema
    And match response.id == petId
    And match response.name == 'Firulais Actualizado'
    And match response.status == 'sold'
