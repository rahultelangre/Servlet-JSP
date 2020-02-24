package com.nt.beans;

import java.util.Random;

public class Rotator {
  

	private String links[]= {"https://alljobalert.ooo",
			                 "https://alljobalert.ooo ",
			                 "https://alljobalert.ooo ",
			                 "https://alljobalert.ooo ",
			                 "https://alljobalert.ooo "
			                 };
	private String images[]= {"a.jpg","b.jpg","c.jpg","d.jpg","e.jpg"};
	
	public String[] getLinks() {
		return links;
	}
	public void setLinks(String[] links) {
		this.links = links;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	
	int counter=0;
	public void nextAdvertisement() {
		Random rad=new Random();
		counter=rad.nextInt(5);
		
	}
	public String getImage() {
		return images[counter];
	}
	public String getLink() {
		return links[counter];
	}
}
