/**
 * @Author: Yannick Ruck
 * @Date: 17/01/2021
 */
package ch.bbw.yr.db.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
@NamedQuery(name="ApiRequest.findAll", query="SELECT a FROM ApiRequest a")
public class ApiRequest {
    @Id
    @GeneratedValue
    @Column( unique = true )
    private int id;

    private String request;

    @Column( length = 100000)
    private String answer;

    @CreationTimestamp
    private Timestamp dateCalled;

    public ApiRequest() {
    }

    public ApiRequest(String request, String answer ) {
        this.request = request;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Timestamp getDateCalled() {
        return dateCalled;
    }

    public void setDateCalled(Timestamp dateCalled) {
        this.dateCalled = dateCalled;
    }
}
