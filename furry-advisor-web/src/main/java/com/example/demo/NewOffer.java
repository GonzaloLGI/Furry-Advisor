package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class NewOffer {
	private boolean newOffer;
	
	public boolean isNewOffer() {
		return newOffer;
	}

	public void setNewOffer(boolean newOffer) {
		this.newOffer = newOffer;
	}
	
	public boolean getNewOffer(){
		return newOffer;
	}
	
	public NewOffer(){
		newOffer = false;
	}
}
