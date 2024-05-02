package org.example.millerlab.dto;


import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    private Long id;

    private String investor;
    private String project;
    private String mo;
    private String protocol;
    private String category;
    private String subject;
    private String responsible;
    private ZonedDateTime deadLine;
    private String status;
    private String result;
    private String resultStatus;

}
