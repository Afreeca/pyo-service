package com.interview.itv.pyoservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class PyoDtoRequest implements Serializable {

    @ApiModelProperty(notes = "Unique key that identifies the break")
    @NotNull(message = "breakId cannot be null")
    private Long breakId;

    @ApiModelProperty(notes = "Unique key that identifies the break")
    @NotNull(message = "campaignId cannot be null")
    private Long campaignId;
}
