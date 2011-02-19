package com.codebrane.spring.beans;

public class DummyBean {
	private String dummyInjectedProperty = null;
	private String dummyInternalProperty = null;
	
	public void init() {
		dummyInternalProperty = dummyInjectedProperty + " test!";
	}
	
	public void setDummyInjectedProperty(String dummyInjectedProperty) {
		this.dummyInjectedProperty = dummyInjectedProperty;
	}
	
	public String getDummyInjectedProperty() {
		return dummyInjectedProperty;
	}
	
	public String getDummyInternalProperty() {
		return dummyInternalProperty;
	}
}