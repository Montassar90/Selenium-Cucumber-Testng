package com.e2eTests.paraBankDemo;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(features = { "src/spec/features" },
plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
tags = (""), 
monochrome = true, 
snippets = SnippetType.CAMELCASE)

public class TestsRunner extends AbstractTestNGCucumberTests {

}
