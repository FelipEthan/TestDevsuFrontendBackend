package pages;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {


    String element1 = "//button[@id='add-to-cart-sauce-labs-backpack']";
    String element2 = "//button[@id='add-to-cart-sauce-labs-bike-light']";
    String element3 = "//a[@class='shopping_cart_link']";
    String element4 = "//button[@id='checkout']";
    String element5 = "//input[@data-test='firstName']";
    String element6 = "//input[@data-test='lastName']";
    String element7 = "//input[@data-test='postalCode']";
    String element8 = "//input[@id='continue']";
    String element9 = "//button[@data-test='finish']";
    String element10 = "//*[@data-test='complete-header']";

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void product1(){
        this.clickElement(element1);
    }
    public void product2(){
        this.clickElement(element2);
    }
    public void cart(){
        this.clickElement(element3);
    }
    public void checkout(){
        this.clickElement(element4);
    }
    public void sendName(String value) {
        this.write(element5, value);
    }
    public void sendLastName(String value) {
        this.write(element6, value);
    }
    public void sendZip(String value) {
        this.write(element7, value);
    }
    public void nextCart() {
        this.clickElement(element8);
    }
    public void completCart() {
        this.clickElement(element9);
    }
    public boolean textValidate2(){
        return this.textValidate(element10);
    }
}
