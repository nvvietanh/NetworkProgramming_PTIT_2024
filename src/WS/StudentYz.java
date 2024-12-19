/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class StudentYz implements Serializable {
    
    private String studentId, name, subject;
    private float score;

    public StudentYz(String studentId, String name, String subject, float score) {
        this.studentId = studentId;
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentY {" + "studentId=" + studentId + ", name=" + name + ", subject=" + subject + ", score=" + score + '}';
    }
    
    
    
}
