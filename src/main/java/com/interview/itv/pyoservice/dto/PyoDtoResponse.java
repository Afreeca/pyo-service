package com.interview.itv.pyoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interview.itv.pyoservice.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
public class PyoDtoResponse implements Serializable {

    public static final String ADVERTISER_ID = "advertiser_id";
    public static final String BREAK_ID = "break_id";
    public static final String SPOT_LENGTH = "spot_length";
    public static final String BROADCAST_DATE = "broadcast_date";
    public static final String START_TIME = "start_time";
    public static final String DURATION = "duration";

    @ApiModelProperty(notes = "Unique Id that identifies the Advertiser")
    private String AdvertiserId;

    @ApiModelProperty(notes = "Unique key that identifies the break")
    private Long breakId;

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
