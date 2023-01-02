package stepdef;

import java.io.IOException;

import AmazonBaseConfigfile.Setup_configfilecode_basefile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice.Enter;
import seleniumelements.credentials_setup;

public class Login_step {

	@Given("^Open Applications & Enter URL$")
	public static void step1() throws IOException {

		Setup_configfilecode_basefile.read_browser();

	}

	@When("^User Enter the Valid Username$")
	public static void step2() throws IOException, InterruptedException {

		credentials_setup.credentials_username_set();
    }
   
	@And("^User Enter the Valid Password$")
	public static void step3() throws IOException {

		credentials_setup.credentials_password_set();

	}

	@And("^And: user clicked on Login button$")
	public static void step4() throws IOException, InterruptedException {

		credentials_setup.click_login();

	}

	@Then("^User in LOgged into Application Successfully$")
	public static void step5() throws IOException, InterruptedException {

		credentials_setup.validate_username();

	}
}
