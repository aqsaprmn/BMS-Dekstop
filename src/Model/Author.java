/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aqsha.permana
 */
public class Author {
    int AuthorNum;
    String AuthorLast, AuthorFirst;

    public Author(int AuthorNum, String AuthorLast, String AuthorFirst) {
        this.AuthorNum = AuthorNum;
        this.AuthorLast = AuthorLast;
        this.AuthorFirst = AuthorFirst;
    }

    public int getAuthorNum() {
        return AuthorNum;
    }

    public void setAuthorNum(int AuthorNum) {
        this.AuthorNum = AuthorNum;
    }

    public String getAuthorLast() {
        return AuthorLast;
    }

    public void setAuthorLast(String AuthorLast) {
        this.AuthorLast = AuthorLast;
    }

    public String getAuthorFirst() {
        return AuthorFirst;
    }

    public void setAuthorFirst(String AuthorFirst) {
        this.AuthorFirst = AuthorFirst;
    }
    
    
}
