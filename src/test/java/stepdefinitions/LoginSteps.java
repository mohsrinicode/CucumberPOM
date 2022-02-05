package stepdefinitions;

import com.factory.DriverFactory;
import com.pages.Loginpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginSteps {
	private Loginpage lp = new Loginpage(DriverFactory.getDriver());
	 private static String PageTitle;
	 private static String homeTitle;
@Given("user is on login page")
public void user_is_on_login_page() {

  DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
  
}

@When("user gets the title of the page")
public void user_gets_the_title_of_the_page() {
	 PageTitle=lp.getLoginPageTitle();
	  System.out.println("Login Page---->"+PageTitle);
}

@Then("page title should be {string}")
public void page_title_should_be(String expectedTitle) {
	Assert.assertTrue(PageTitle.contains(expectedTitle));

  
}


@Then("forgot you password link should be displayed")
public void forgot_you_password_link_should_be_displayed() {
	Assert.assertTrue(lp.isforgotpwdLinkExsist());
}

@When("user enters username {string}")
public void user_enters_username(String username) {
   lp.enterusername(username);
}
@When("user enters password {string}")
public void user_enters_password(String pwd) {
   lp.enterpassword(pwd);
}

@When("user clicks on login button")
public void user_clicks_on_login_button() {
	lp.clickOnlogin();
}


@Then("Home page title should be {string}")
public void home_page_title_should_be(String Expectedhometitle) {
	
	 homeTitle =lp.getLoginPageTitle();
	System.out.println("Home Page Title"+homeTitle);
	Assert.assertTrue(homeTitle.contains(Expectedhometitle));

}

}
