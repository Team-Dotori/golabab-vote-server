package com.dotori.golababvoteserver.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "improve_message") @Getter @Setter
@NoArgsConstructor
public class ImproveMessage {
    @Id @GeneratedValue
    @Column(name = "idx")
    private Long idx;

    @NotBlank
    @Size(min = 0, max = 32)
    private String message;

    @Builder
    public ImproveMessage(String message){
        this.message = message;
    }
}
