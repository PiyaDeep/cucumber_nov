package com.vtiger.stepdefination;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.vtiger.pages.APIpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIstepdefination extends  Basaestepdefination {
	  Response resp;
	  String Endpoint;
	  APIpage api;
	   String body;
	@Before
	public void before(Scenario scenario) {
		this.scenario=scenario;
	}
	@After
	public void after()
	{
		extent.flush();
		//driver.quit();
		
	}
	@Given("user should have endpoint url")
	public void user_should_have_endpoint_url() {
		init();
		logger=extent.createTest(scenario.getName());
		 TCName=scenario.getName();
			 api=new APIpage(logger);
	         Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");

	    
	}

@When("user send get request with Data")
public void user_send_get_request_with_data() {
     resp=RestAssured.get(Endpoint);

}

	@Then("user will get responce")
	public void user_will_get_responce() {
        api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());

	}
	

	@Then("responce contains status code,email,page value")
	public void responce_contains_status_code_email_page_value() {

		api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());

        String json=resp.body().asPrettyString();
        JsonPath jsonpath=new JsonPath(json);
        String page=jsonpath.getString("page");
        System.out.println(page);
         api.VarifyJsonResponce(TestData.get(TCName).get("page"), page);
         api.VarifyJsonResponce(TestData.get(TCName).get("email"), jsonpath.getString("data[0].email"));
          extent.flush();

	}
//single user
	@Given("user should have endpoint singleurl")
	public void user_should_have_endpoint_singleurl() {
		init();
		logger=extent.createTest(scenario.getName());
		 TCName=scenario.getName();
			 api=new APIpage(logger);
	         Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
	}
	

	
	@When("user send get request with single Data")
	public void user_send_get_request_with_single_data() {
		resp=RestAssured.get(Endpoint);

	 
	}
	@Then("user will get responce of single user")
	public void user_will_get_responce_of_single_user() {
        api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());

	}
	@Then("responce contains status code,id,email,first_name,last_name")
	public void responce_contains_status_code_id_email_first_name_last_name() {
		api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());

        String json=resp.body().asPrettyString();
        JsonPath jsonpath=new JsonPath(json);
        String id=jsonpath.getString("data.id");
        System.out.println(id+" id is here here");
         api.VarifyJsonResponce(TestData.get(TCName).get("id"), jsonpath.getString("data.id"));
         api.VarifyJsonResponce(TestData.get(TCName).get("email"), jsonpath.getString("data.email"));
         api.VarifyJsonResponce(TestData.get(TCName).get("first_name"), jsonpath.getString("data.first_name"));
         api.VarifyJsonResponce(TestData.get(TCName).get("last_name"), jsonpath.getString("data.last_name"));

         extent.flush();
	}
//create users
	@Given("user should have endpoint createuserurl")
	public void user_should_have_endpoint_createuserurl() {
		init();
		logger=extent.createTest(scenario.getName());
		 TCName=scenario.getName();
			 api=new APIpage(logger);
	        Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
	}



@When("user send get request with craeteuser")
public void user_send_get_request_with_craeteuser() {
	Map<String,Object> map=new HashMap<String,Object>();
    map.put("name", TestData.get(TCName).get("name"));
    map.put("job", TestData.get(TCName).get("job"));
    JSONObject json=new JSONObject(map);
    RequestSpecification rs=RestAssured.given();
   rs.header("Content-Type","application/json");
   rs.body(json.toString());
   logger.info("Request="+json.toString());
   
    resp=rs.post(Endpoint);
    logger.info("Post Url"+Endpoint);
     body=resp.getBody().asString();
}

@Then("user will get responce of craeteuser")
public void user_will_get_responce_of_craeteuser() {
    api.WriteRequestRsponceinReport(Endpoint, body);

}

@Then("responce contains status code,name,job")
public void responce_contains_status_code_name_job() {
	api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());
    String jsn=resp.body().asPrettyString();
    JsonPath jsonpath=new JsonPath(jsn);
   // String id=jsonpath.getString("id");
   // System.out.println(id+" id is here here");
   // api.VarifyJsonResponce(TestData.get(TCName).get("id"), jsonpath.getString("id"));
    api.VarifyJsonResponce(TestData.get(TCName).get("name"), jsonpath.getString("name"));
    api.VarifyJsonResponce(TestData.get(TCName).get("job"), jsonpath.getString("job"));
     extent.flush();
}

//update user
@Given("user should have endpoint Updateurl")
public void user_should_have_endpoint_updateurl() {
	init();
	logger=extent.createTest(scenario.getName());
	 TCName=scenario.getName();
		 api=new APIpage(logger);
      Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
}



@When("user send get request with updateuser")
public void user_send_get_request_with_updateuser() {
	 Map<String,Object> map=new HashMap<String,Object>();
     map.put("name", TestData.get(TCName).get("name"));
     map.put("job", TestData.get(TCName).get("job"));
     JSONObject json=new JSONObject(map);
     RequestSpecification rs=RestAssured.given();
    rs.header("Content-Type","application/json");
    rs.body(json.toString());
     logger.info("Request="+json.toString());
    
     resp=rs.put(Endpoint);
     logger.info("put Url"+Endpoint);
     body=resp.getBody().asString();

  }

@Then("user will get responce of updateuser")
public void user_will_get_responce_of_updateuser() {
	api.WriteRequestRsponceinReport(Endpoint, body);

   
}
@Then("responce contains to update  status code,name,job")
public void responce_contains_to_update_status_code_name_job() {
	  api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());
      String jsn=resp.body().asPrettyString();
      JsonPath jsonpath=new JsonPath(jsn);
    
      api.VarifyJsonResponce(TestData.get(TCName).get("name"), jsonpath.getString("name"));
      api.VarifyJsonResponce(TestData.get(TCName).get("job"), jsonpath.getString("job"));
       extent.flush();
}
//deleted user
@Given("user should have endpoint Deleteurl")
public void user_should_have_endpoint_deleteurl() {
	init();
	logger=extent.createTest(scenario.getName());
	 TCName=scenario.getName();
		 api=new APIpage(logger);
       Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
}
    


@When("user send get request with Deleteurl")
public void user_send_get_request_with_deleteurl() {
	 api=new APIpage(logger);
    String Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
     
     resp=RestAssured.delete(Endpoint);
}

@Then("user will get responce of Deleteurl")
public void user_will_get_responce_of_deleteurl() {
    api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());

}

@Then("responce contains to deleted User")
public void responce_contains_to_deleted_user() {
	
	api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());
    System.out.println(resp.getStatusLine());
    String json=resp.body().asPrettyString();
    System.out.println(json);
     extent.flush();
}
//SingleUserNotFound
@Given("user should have endpoint SingleuserNotfoundurl")
public void user_should_have_endpoint_singleuser_notfoundurl() {
	init();
	logger=extent.createTest(scenario.getName());
	 TCName=scenario.getName();
	  api=new APIpage(logger);
     Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
}

@When("user send get request with SingleuserNotfoun")
public void user_send_get_request_with_singleuser_notfoun() {
	api=new APIpage(logger);
      Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
      resp=RestAssured.delete(Endpoint);
}
   

@Then("user will get responce of SingleuserNotfoun")
public void user_will_get_responce_of_singleuser_notfoun() {
    api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());

}

@Then("responce contains to SingleuserNotfoun")
public void responce_contains_to_singleuser_notfoun() {
	api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());
    System.out.println(resp.getStatusLine());
    String json=resp.body().asPrettyString();
    System.out.println(json);
     extent.flush(); 
}
//List resources
/*@Given("user should have endpoint ListResourcesurl")
public void user_should_have_endpoint_list_resourcesurl() {
	init();
	logger=extent.createTest(scenario.getName());
	 TCName=scenario.getName();
	  api=new APIpage(logger);
    Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
}
*/
@Given("user should have endpoint ListResourcesurl")
public void user_should_have_endpoint_list_resourcesurl() {
	init();
	logger=extent.createTest(scenario.getName());
	 TCName=scenario.getName();
	  api=new APIpage(logger);
    Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
}

@When("user send get request with ListResources Data")
public void user_send_get_request_with_list_resources_data() {
    resp=RestAssured.get(Endpoint);

}

@Then("user will get responce of ListResources")
public void user_will_get_responce_of_list_resources() {
    api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());

}


@Then("responce contains page,name,id  ListResources")
public void responce_contains_page_name_id_list_resources() {
	api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());

    String json=resp.body().asPrettyString();
    JsonPath jsonpath=new JsonPath(json);
    //String id=jsonpath.getString("data.id");
    //System.out.println(id+" id is here here");
     //api.VarifyJsonResponce(TestData.get(TCName).get("id"), jsonpath.getString("data.id"));
     api.VarifyJsonResponce(TestData.get(TCName).get("name"), jsonpath.getString("data[0].name"));
     api.VarifyJsonResponce(TestData.get(TCName).get("page"), jsonpath.getString("page"));

     extent.flush();
}

//single resourses
@Given("user should have endpoint SingleRecorcesurl")
public void user_should_have_endpoint_single_recorcesurl() {
	logger=extent.createTest(scenario.getName());
	 TCName=scenario.getName();
	  api=new APIpage(logger);
   Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
}

@When("user send get request with SingleRecorces Data")
public void user_send_get_request_with_single_recorces_data() {
	resp=RestAssured.get(Endpoint);
}

@Then("user will get responce of SingleRecorces")
public void user_will_get_responce_of_single_recorces() {
    api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());

}

@Then("responce contains id,name,year")
public void responce_contains_id_name_year() {
	api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());

    String json=resp.body().asPrettyString();
    JsonPath jsonpath=new JsonPath(json);
    String id=jsonpath.getString("data.id");
    System.out.println(id+" id is here here");
     api.VarifyJsonResponce(TestData.get(TCName).get("id"), jsonpath.getString("data.id"));
     api.VarifyJsonResponce(TestData.get(TCName).get("name"), jsonpath.getString("data.name"));
     api.VarifyJsonResponce(TestData.get(TCName).get("year"), jsonpath.getString("data.year"));

     extent.flush();
}


}
