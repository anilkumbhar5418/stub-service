package com.ak.stub.handler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VersionCreateRequest
{
    @JsonProperty(value = "component_id")
    private String componentId;

    @JsonProperty(value = "component_type")
    private String componentType;

    @JsonProperty(value = "commit_message")
    private String commitMessage;

    private String data;
}