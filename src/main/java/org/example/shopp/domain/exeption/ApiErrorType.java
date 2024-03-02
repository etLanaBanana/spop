package org.example.shopp.domain.exeption;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ApiErrorType {

    @JsonProperty("validation")
    VALIDATION,
    @JsonProperty("business")
    BUSINESS,
    @JsonProperty("system")
    SYSTEM;
    private ApiErrorType() {
    }
}
