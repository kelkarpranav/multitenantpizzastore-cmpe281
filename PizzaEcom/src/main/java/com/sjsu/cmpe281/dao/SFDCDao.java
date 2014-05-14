package com.sjsu.cmpe281.dao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.sjsu.cmpe281.util.PropertyLoader;

public class SFDCDao {
	
	private static final String queryPizzas = "select name, price__c from pizza_final__c";
	private static final String queryDrinks = "select name, price__c from drink_final__c";
	private static final String querySides = "select name, price__c from side_final__c";
	private PropertyLoader pl = PropertyLoader.createPropertyLoaderObj();
	public  Properties    prop = pl.createConfigFileHook();
			
	// The connection data
    private String clientId = null;
    private String clientSecret = null;
    private String tokenUrl = null;
    private String username = null;
    private String password = null;
    private String security_token = null;
    
    private String redirectUri = "https://localhost:8443/_callback";
    private String environment = null;
    
    private String accessToken = null;
    private String instanceUrl = null;
    
    private HttpClient httpclient = null;
    
    public SFDCDao(){}
    
    public void initStore(String storeid) throws Exception{
		
    	if (storeid.equalsIgnoreCase("dominos")){
			clientId = prop.getProperty("clientId1");
			clientSecret = prop.getProperty("clientSecret1");
			username = prop.getProperty("username1");
			password = prop.getProperty("password1");
			security_token = prop.getProperty("security_token1");
		}else if (storeid.equalsIgnoreCase("pizzahut")){
			clientId = prop.getProperty("clientId2");
			clientSecret = prop.getProperty("clientSecret2");
			username = prop.getProperty("username2");
			password = prop.getProperty("password2");
			security_token = prop.getProperty("security_token2");
		}else if (storeid.equalsIgnoreCase("pizzamyheart")){
			clientId = prop.getProperty("clientId3");
			clientSecret = prop.getProperty("clientSecret3");
			username = prop.getProperty("username3");
			password = prop.getProperty("password3");
			security_token = prop.getProperty("security_token3");
		}else if (storeid.equalsIgnoreCase("papajohnspizza")){
			clientId = prop.getProperty("clientId4");
			clientSecret = prop.getProperty("clientSecret4");
			username = prop.getProperty("username4");
			password = prop.getProperty("password4");
			security_token = prop.getProperty("security_token4");
		}else if (storeid.equalsIgnoreCase("roundtablepizza")){
			clientId = prop.getProperty("clientId5");
			clientSecret = prop.getProperty("clientSecret5");
			username = prop.getProperty("username5");
			password = prop.getProperty("password5");
			security_token = prop.getProperty("security_token5");
		}
    	
//    	// just for testing
//    	clientId = "3MVG9Km_cBLhsuPzTtcGHsZpj9JylyezngYKNi.dNkSQmA0fAdwMD9OzkQEPFDJv1UgVF5tcERKtuiP5Yiin3";
//		clientSecret = "6135262856068035680";
//		username = "ming@sjsu.edu";
//		password = "redred`1";
//		security_token="4jcGIdgZjgUyMsPmtbBTGXUZ";
    	System.out.println("_______________________________________________________________________________");
    	System.out.println(clientId);
    	System.out.println(clientSecret);
    	System.out.println(username + password + security_token);
		
		environment = prop.getProperty("environment");
		tokenUrl = environment + "/services/oauth2/token";
        
		httpclient = new HttpClient();
	}
	
    public JSONObject getItemList(String storeid) throws Exception
    {   
    	initStore(storeid);
    	
        // Step 1:  Connect to SalesForce.
//        System.out.println("Getting a token");
        
        PostMethod post = new PostMethod(tokenUrl);     
        post.addParameter("grant_type", "password");
        post.addParameter("client_id", clientId);
        post.addParameter("client_secret", clientSecret);
        post.addParameter("redirect_uri", redirectUri);
        post.addParameter("username", username);
        post.addParameter("password", password + security_token);

        try {
            httpclient.executeMethod(post);
            try {
                JSONObject authResponse = new JSONObject(new JSONTokener(new InputStreamReader(post.getResponseBodyAsStream())));
//                System.out.println("Auth response: " + authResponse.toString(2));

                accessToken = authResponse.getString("access_token");
                instanceUrl = authResponse.getString("instance_url");

//                System.out.println("Got access token: " + accessToken);
            } catch (JSONException e) {
                e.printStackTrace();                
            }
        } catch (HttpException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            post.releaseConnection();
        }       
        System.out.println("We have an access token: " + accessToken + "\n" + "Using instance " + instanceUrl + "\n\n");

        
        
        // Step 2: Query the objects from salesforce
        JSONObject catalogs = new JSONObject();
        try {
            JSONObject response1 = getQuery(queryPizzas);        
//			System.out.println("Query response: "+ response1.toString(2));
//			System.out.println(response1.getString("totalSize") + " record(s) returned\n\n");
	        JSONArray results1 = response1.getJSONArray("records");
	        catalogs.append("Pizza",(Object)results1);
	        
	        JSONObject response2 = getQuery(queryDrinks);        
//	        System.out.println("Query response: "+ response2.toString(2));//.substring(0, 500));                 
//	        System.out.println(response2.getString("totalSize") + " record(s) returned\n\n");
	        JSONArray results2 = response2.getJSONArray("records");     
	        catalogs.append("Drink",(Object)results2);
	        
	        JSONObject response3 = getQuery(querySides);        
//	        System.out.println("Query response: "+ response3.toString(2));//.substring(0, 500));                 
//	        System.out.println(response3.getString("totalSize") + " record(s) returned\n\n");
	        JSONArray results3 = response3.getJSONArray("records");    
	        catalogs.append("Side",(Object)results3);
	       
		
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                
         
        return catalogs;
        
    }
	

	private JSONObject getQuery(String querystring) {
		GetMethod get = new GetMethod(instanceUrl + "/services/data/v28.0/query");
		JSONObject response = null;
		
        // set the token in the header
        get.setRequestHeader("Authorization", "OAuth " + accessToken);

        // set the SOQL as a query param
        NameValuePair[] params = new NameValuePair[1];

        params[0] = new NameValuePair("q",querystring);
        get.setQueryString(params);     

        try {
            httpclient.executeMethod(get);
            if (get.getStatusCode() == HttpStatus.SC_OK) {
                // Now lets use the standard java json classes to work with the results
                response = new JSONObject( new JSONTokener( new InputStreamReader(get.getResponseBodyAsStream())));   
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            get.releaseConnection();
        }
        
        return response;
	}

}
