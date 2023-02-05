/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aqsha.permana
 */
public class Branch {
    int BranchNum , NumEmployess;
    String BranchName , BranchLocation;

    public Branch(int BranchNum, int NumEmployess, String BranchName, String BranchLocation) {
        this.BranchNum = BranchNum;
        this.NumEmployess = NumEmployess;
        this.BranchName = BranchName;
        this.BranchLocation = BranchLocation;
    }

    public int getBranchNum() {
        return BranchNum;
    }

    public void setBranchNum(int BranchNum) {
        this.BranchNum = BranchNum;
    }

    public int getNumEmployess() {
        return NumEmployess;
    }

    public void setNumEmployess(int NumEmployess) {
        this.NumEmployess = NumEmployess;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String BranchName) {
        this.BranchName = BranchName;
    }

    public String getBranchLocation() {
        return BranchLocation;
    }

    public void setBranchLocation(String BranchLocation) {
        this.BranchLocation = BranchLocation;
    }
    
    
}
