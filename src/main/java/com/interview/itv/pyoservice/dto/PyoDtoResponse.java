package com.interview.itv.pyoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interview.itv.pyoservice.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Setter
public class PyoDtoResponse {

    @ApiModelProperty(notes = "Unique Id that identifies the Advertiser")
    private String AdvertiserId;

    @ApiModelProperty(notes = "the length of the advertisement in seconds")
    private int spotLength;

    @ApiModelProperty(notes = "Broadcast date")
    @JsonFormat(pattern = Constants.DB_DATE_FORMAT)
    private LocalDate date;

    @ApiModelProperty(notes = "The start time for the break")
    private int time;

    @ApiModelProperty(notes = "The duration of the break in seconds")
    private int duration;
}
