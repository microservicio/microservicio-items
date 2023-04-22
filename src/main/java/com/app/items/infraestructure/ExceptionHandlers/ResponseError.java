package com.app.items.infraestructure.ExceptionHandlers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseError {
    private String id;
    private String message;
}
