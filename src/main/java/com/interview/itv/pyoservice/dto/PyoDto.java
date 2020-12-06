package com.interview.itv.pyoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interview.itv.pyoservice.utils.Constants;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class PyoDto {

    @ApiModelProperty(notes = "Unique Id that identifies the Advertiser")
    @Column(name="Advertiser_id")
    private String AdvertiserId;

    @ApiModelProperty(notes = "the length of the advertisement in seconds")
    @Column(name="spot_length")
    private int spotLength;

    @ApiModelProperty(notes = "Broadcast date")
    @Column(name="broadcast_date")
    @JsonFormat(pattern = Constants.DATE_FORMAT)
    private LocalDate date;

    @ApiModelProperty(notes = "The start time for the break")
    private int time;

    @ApiModelProperty(notes = "The duration of the break in seconds")
    @NotBlank
    private int duration;
}
