package com.interview.itv.pyoservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interview.itv.pyoservice.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
public class Break {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Unique key that identifies the break")
    private Long breakId;

    @ApiModelProperty(notes = "Broadcast date")
    @NotBlank
    @JsonFormat(pattern = Constants.DATE_FORMAT)
    private LocalDate date;

    @ApiModelProperty(notes = "The start time for the break")
    @NotBlank
    private Long time;

    @ApiModelProperty(notes = "The duration of the break in seconds")
    @NotBlank
    private int duration;
}
