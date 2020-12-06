package com.interview.itv.pyoservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PyoDtoRequest {

    @ApiModelProperty(notes = "Unique key that identifies the break")
    private Long breakId;

    @ApiModelProperty(notes = "Unique key that identifies the break")
    private Long campaignId;
}
