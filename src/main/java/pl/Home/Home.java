/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.Home;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Arek
 */
@Entity
@Table(name = "home")
public class Home {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "jest")
    private int isAtHome;

    public Home() {
    }

    public Home(int id, int isAtHome) {
        this.id = id;
        this.isAtHome = isAtHome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsAtHome() {
        return isAtHome;
    }

    public void setIsAtHome(int isAtHome) {
        this.isAtHome = isAtHome;
    }
    
    
    
}
