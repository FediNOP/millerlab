package org.example.millerlab.dto;


import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

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
    private String deadLine;
    private String status;
    private String result;
    private String resultStatus;


    public String getStatusColor() {
        if (StringUtils.isEmpty(status)) {
            return "background: none";
        }

        return switch (status.toLowerCase()) {
            case "на выполнении" -> "background: yellow";
            case "выполнено" -> "background: green";
            case "не выполнено" -> "background: red";
            default -> "background: none";
        };
    }

}
