package org.geeksforgeeks.jbdl60.Durgesh_YT;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question_table")
public class Question {

    @Id
    @Column(name = "question_id")
    private int id;

    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(int id, String question, List<Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public Question() {
        super();
    }
}
