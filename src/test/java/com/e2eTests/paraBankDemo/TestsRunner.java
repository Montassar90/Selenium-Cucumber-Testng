package com.e2eTests.paraBankDemo;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(features = { "src/spec/features" },
tags = (""), 
monochrome = true, 
snippets = SnippetType.CAMELCASE)

public class TestsRunner extends AbstractTestNGCucumberTests {

}
