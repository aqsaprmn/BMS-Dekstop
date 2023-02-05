/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Wrote {
    String BookCode;
    int AuthorNum , Squence;

    public Wrote(String BookCode, int AuthorNum, int Squence) {
        this.BookCode = BookCode;
        this.AuthorNum = AuthorNum;
        this.Squence = Squence;
    }

    public int getSquence() {
        return Squence;
    }

    public void setSquence(int Squence) {
        this.Squence = Squence;
    }

    public String getBookCode() {
        return BookCode;
    }

    public int getAuthorNum() {
        return AuthorNum;
    }

    public void setBookCode(String BookCode) {
        this.BookCode = BookCode;
    }

    public void setAuthorNum(int AuthorNum) {
        this.AuthorNum = AuthorNum;
    }
    
    
}
