/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aqsha.permana
 */
public class Books {
    String BookCode,Title,PublisherCode,Type,Paperback;
    int Price;

    public Books(String BookCode, String Title, String PublisherCode, String Type ,String Paperback , int Price ) {
        this.BookCode = BookCode;
        this.Title = Title;
        this.PublisherCode = PublisherCode;
        this.Type = Type;
        this.Paperback = Paperback;
        this.Price = Price;
    }

    public String getBookCode() {
        return BookCode;
    }

    public String getTitle() {
        return Title;
    }

    public String getPublisherCode() {
        return PublisherCode;
    }

    public String getType() {
        return Type;
    }

    public String getPaperback() {
        return Paperback;
    }

    public int getPrice() {
        return Price;
    }

    public void setBookCode(String BookCode) {
        this.BookCode = BookCode;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setPublisherCode(String PublisherCode) {
        this.PublisherCode = PublisherCode;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setPaperback(String Paperback) {
        this.Paperback = Paperback;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    
    
    
}
