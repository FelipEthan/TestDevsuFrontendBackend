package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    private LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(Hooks.driver);
        }
        return loginPage;
    }

    @Given("^El usuario está en la página de inicio de sesión$")
    public void navigate() {
        this.getLoginPage().navigateToPage();
    }

    @When("El usuario ingresa la contraseña {string}")
    public void enterData(String contraseña) {
        this.getLoginPage().sendPass(contraseña);
    }

    @When("El usuario ingresa el nombre de usuario {string}")
    public void enterData2(String usuario) {
        this.getLoginPage().sendUser(usuario);
    }

    @And("^El usuario hace clic en el botón de Login")
    public void clickEntrar() {
        this.getLoginPage().clickSubmit();
    }


}
