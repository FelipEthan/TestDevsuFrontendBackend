Feature: Login

  @Test1
  Scenario: Prueba completa E2E exitoso
    Given El usuario está en la página de inicio de sesión
    When El usuario ingresa el nombre de usuario "standard_user"
    When El usuario ingresa la contraseña "secret_sauce"
    And El usuario hace clic en el botón de Login
    And El usuario agrega dos productos al carrito
    And Visualiza los productos a comprar
    And Diligencia el formulario de compra
    Then El sistema debe mostrar el mensaje de compra exitosa