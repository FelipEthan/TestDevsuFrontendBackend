package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;

public class CartSteps {
    private CartPage cartPage;

    private CartPage cartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(Hooks.driver);
        }
        return cartPage;
    }

    @And("^El usuario agrega dos productos al carrito$")
    public void addProduct() {
        this.cartPage().product1();
        this.cartPage().product2();
    }
    @And("^Visualiza los productos a comprar$")
    public void cart() {
        this.cartPage().cart();
        this.cartPage().checkout();
    }
    @And("^Diligencia el formulario de compra$")
    public void formCart() {
        this.cartPage().sendName("Andres");
        this.cartPage().sendLastName("Quimbayo");
        this.cartPage().sendZip("123123");
        this.cartPage().nextCart();
        this.cartPage().completCart();
    }
    @Then("^El sistema debe mostrar el mensaje de compra exitosa")
    public void messagevalidation3() {
        Assert.assertTrue(cartPage().textValidate2());
    }
}
