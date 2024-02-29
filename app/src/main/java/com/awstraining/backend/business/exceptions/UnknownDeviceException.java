package com.awstraining.backend.business.exceptions;

import static java.lang.System.currentTimeMillis;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.ResponseEntity.status;

import javax.servlet.http.HttpServletRequest;

import com.awstraining.backend.api.rest.v1.model.ApiBusinessErrorResponse;
import org.springframework.http.ResponseEntity;

public class UnknownDeviceException extends Exception {
    public ResponseEntity<ApiBusinessErrorResponse> toResponse(final HttpServletRequest request) {
        final int status = UNPROCESSABLE_ENTITY.value();
        final ApiBusinessErrorResponse apiClientErrorResponse = new ApiBusinessErrorResponse() //
                .statusCode(status) //
                .logMessage("Device with given id could not be found.") //
                .requestUrl(request.getRequestURL().toString()) //
                .requestTimestamp(currentTimeMillis());
        return status(status).body(apiClientErrorResponse);
    }
}
