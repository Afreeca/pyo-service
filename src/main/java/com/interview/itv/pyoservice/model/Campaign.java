package com.interview.itv.pyoservice.model;

import com.interview.itv.pyoservice.utils.Types.Profile;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Unique key that identifies the break")
    private Long campaignId;

    @ApiModelProperty(notes = "Unique Id that identifies the Advertiser")
    @NotBlank
    private String AdvertiserId;

    @ApiModelProperty(notes = "the length of the advertisement in seconds")
    @NotBlank
    private int SpotLength;

    @ApiModelProperty(notes = "The target demographic profile for this campaign")
    @NotBlank
    private Profile demographic;

    @ApiModelProperty(notes = "The percentage of target ratings that can be delivered with PYO")
    @NotBlank
    private double targetTVR;

    private int PYOPercentage;
}
