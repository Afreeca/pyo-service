package com.interview.itv.pyoservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interview.itv.pyoservice.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "break")
public class Break {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Unique key that identifies the break")
    @Column(name="id")
    private Long breakId;

    @ApiModelProperty(notes = "Broadcast date")
    @NotNull
    @Column(name="broadcast_date")
    @JsonFormat(pattern = Constants.DB_DATE_FORMAT)
    private LocalDate date;

    @ApiModelProperty(notes = "The start time for the break")
    @NotNull
    @Column(name="start_time")
    private int time;

    @ApiModelProperty(notes = "The duration of the break in seconds")
    @NotNull
    private int duration;
}
