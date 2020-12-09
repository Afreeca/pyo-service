package com.interview.itv.pyoservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "break_campaign")
public class Pyo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Unique key that identifies the pyo")
    private Long Id;

    @ApiModelProperty(notes = "Unique key that identifies the break")
    @NotNull
    @Column(name="break_id")
    private Long breakId;

    @ApiModelProperty(notes = "Unique key that identifies the break")
    @NotNull
    @Column(name="campaign_id")
    private Long campaignId;

    @ApiModelProperty(notes = "Unique Id that identifies the Advertiser")
    @NotBlank
    @Column(name="Advertiser_id")
    private String AdvertiserId;
}
