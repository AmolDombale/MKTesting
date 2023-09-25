package StepDefinations;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DataTableLect {
	@Given("enter username and password")
	public void enter_username_and_password(DataTable dataTable) {
		List<String> data = dataTable.values();
		System.out.println(data.get(0));
		System.out.println(data.get(1));	
		
	}
	@Given("enter multiple username and password")
	public void enter_multiple_username_and_password(DataTable dataTable) {
		List<List<String>> credentials = dataTable.asLists();
		System.out.println(credentials.get(0).get(0));
		System.out.println(credentials.get(0).get(1));
		System.out.println(credentials.get(1).get(0));
		System.out.println(credentials.get(1).get(1));
	}
	
	@When("enter multiple with list username and password")
	public void enter_multiple_with_list_username_and_password(List<List<String>> credentials) {
		System.out.println(credentials.get(0).get(0));
		System.out.println(credentials.get(0).get(1));
		System.out.println(credentials.get(1).get(0));
		System.out.println(credentials.get(1).get(1)); 
	}
}
