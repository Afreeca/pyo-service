package com.interview.itv.pyoservice.model;

import com.interview.itv.pyoservice.dto.PyoDtoRequest;
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

    @ApiModelProperty(notes = "Unique key that identifies the break")
    @Column(name="campaign_id")
    private Long campaignId;

    public static Pyo convert(PyoDtoRequest pyoDtoRequest){
    Pyo test = new Pyo();
        test.setBreakId(pyoDtoRequest.getBreakId());
        test.setCampaignId(pyoDtoRequest.getCampaignId());
        return test;
    }
}
