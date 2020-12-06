package com.interview.itv.pyoservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "break_campaign")
public class Pyo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Unique key that identifies the pyo")
    private Long Id;

    @ApiModelProperty(notes = "Unique key that identifies the break")
    @Column(name="break_id")
    private Long breakId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Unique key that identifies the break")
    @Column(name="campaign_id")
    private Long campaignId;
}
