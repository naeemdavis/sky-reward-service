package com.sky.rewards.model;

import java.io.Serializable;

import com.sky.rewards.type.ChannelType;

public class Portfolio implements Serializable {

private static final long serialVersionUID = 9024455757311860269L;

    protected ChannelType channelType;

    /**
     * @return the channelType
     */
    public ChannelType getChannelType() {
        return channelType;
    }

    /**
     * @param channelType the channelType to set
     */
    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

}
