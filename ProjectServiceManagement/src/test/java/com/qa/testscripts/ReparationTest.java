package com.qa.testscripts;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ReparationPage;
import com.qa.servicemanagementproject.Base;

public class ReparationTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ReparationPage rPage;
	
	public void addReparation() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		rPage=new ReparationPage(driver);
	}

}
