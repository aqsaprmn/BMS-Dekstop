/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aqsha.permana
 */
public class Publisher {
    String PublisherCode,PublisherName,City;

    public Publisher(String PublisherCode, String PublisherName, String City) {
        this.PublisherCode = PublisherCode;
        this.PublisherName = PublisherName;
        this.City = City;
    }

    public String getPublisherCode() {
        return PublisherCode;
    }

    public void setPublisherCode(String PublisherCode) {
        this.PublisherCode = PublisherCode;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String PublisherName) {
        this.PublisherName = PublisherName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
    
    
}
