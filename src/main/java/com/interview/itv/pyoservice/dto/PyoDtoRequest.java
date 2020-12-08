package com.interview.itv.pyoservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PyoDtoRequest implements Serializable {

    @ApiModelProperty(notes = "Unique key that identifies the break")
    @NotNull(message = "breakId cannot be null")
    private Long breakId;

    @ApiModelProperty(notes = "Unique key that identifies the break")
    @NotNull(message = "campaignId cannot be null")
    private Long campaignId;
}
