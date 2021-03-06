package com.interview.itv.pyoservice.model;

import com.interview.itv.pyoservice.utils.Types.Profile;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Unique key that identifies the break")
    @Column(name="id")
    private Long campaignId;

    @ApiModelProperty(notes = "Unique Id that identifies the Advertiser")
    @NotBlank
    @Column(name="Advertiser_id")
    private String AdvertiserId;

    @ApiModelProperty(notes = "the length of the advertisement in seconds")
    @NotBlank
    @Column(name="spot_length")
    private int spotLength;

    @ApiModelProperty(notes = "The target demographic profile for this campaign")
    @NotBlank
    private Profile demographic;

    @ApiModelProperty(notes = "The target number of TV ratings for this campaign")
    @NotNull
    @Column(name="target_tvr")
    private int targetTVR;

    @ApiModelProperty(notes = "The percentage of target ratings that can be delivered with PYO")
    @NotNull
    @Column(name="pyo_percentage")
    private int pyoPercentage;
}
