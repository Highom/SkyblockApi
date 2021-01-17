/**
 * @Author: Yannick Ruck
 * @Date: 17/01/2021
 */
package ch.bbw.yr.db.entities;

import javax.persistence.*;

@Entity
@Table(name="user")
@NamedQuery(name="User.getByName", query="SELECT u FROM User u WHERE u.username like :username")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private int id;

    private String username;

    private boolean isCapital;

    public User() {
    }

    public User(String username, boolean isCapital) {
        this.username = username;
        this.isCapital = isCapital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }
}