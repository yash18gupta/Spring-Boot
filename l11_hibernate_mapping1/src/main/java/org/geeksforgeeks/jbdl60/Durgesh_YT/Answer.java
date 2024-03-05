package org.geeksforgeeks.jbdl60.Durgesh_YT;

import jakarta.persistence.*;

@Entity
@Table(name = "answer_table")
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int id;

    private String answer;

    @ManyToOne
    private Question question;

    public Answer(int id, String answer, Question question) {
        super();
        this.id = id;
        this.answer = answer;
        this.question = question;
    }

    public Answer() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
