package com.java.mailbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(
    name = "message"
)
public class Message {
    @Column(
        name = "ID"
    )
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    Long id;
    private String content;

    public Message() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
