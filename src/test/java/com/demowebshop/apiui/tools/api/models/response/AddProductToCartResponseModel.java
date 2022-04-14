package com.demowebshop.apiui.tools.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddProductToCartResponseModel {
    boolean success;

    String message;

    @JsonProperty("updatetopcartsectionhtml")
    String updateTopCartSectionHtml;
}
