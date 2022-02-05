package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountPages;
import com.pages.Loginpage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountPage {

	private Loginpage lp = new Loginpage(DriverFactory.getDriver());
	private AccountPages ap ;
	 private static String PageTitle;
	
			
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	   
	   List <Map<String,String>> credList= dataTable.asMaps();
	String username=credList.get(0).get("username");
	String password=credList.get(0).get("password");
	 DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	ap=lp.doLogin(username,password);
	}



	@When("user get the title of the page")
	public void user_get_the_title_of_the_page() {
		PageTitle=ap.getAccountsPageTitle();
		System.out.println("Account title============>checking"+PageTitle);
	   
	} 


	@Given("user is on Accounts page")
	public void user_is_on_Accounts_page() {
		String AccountPageTite=ap.getAccountsPageTitle();
		System.out.println("Account page title is "+AccountPageTite);
	 
	}
	


	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		
		
		List<String> accList=sectionTable.asList();
		
		
		List <String> sellist=ap.getAccountsSectionsList();
	   
		Assert.assertTrue(sellist.containsAll(accList));
	}

	@Then("accounts sections count should be {int}")
	public void accounts_sections_count_should_be(Integer expectedCount) {
		Assert.assertTrue(ap.getAccountsSectionCount()==expectedCount);
	  
	}
}
