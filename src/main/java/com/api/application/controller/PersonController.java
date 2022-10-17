package com.api.application.controller;

import com.api.application.core.commons.DomainReturnCode;
import com.api.application.core.domain.dto.person.PersonDTO;
import com.api.application.core.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.application.utils.core.responses.DataListResponse;
import com.api.application.utils.core.responses.DataResponse;
import com.api.application.utils.core.resquests.DataRequest;
import com.api.application.utils.exeption.ApplicationBusinessException;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/person")
public class PersonController {
    private static final String LOW = "Low";
    private static final String MODERATE = "Moderate";
    private static final String VERY_HIGH = "Very High";

    @Autowired
    PersonService personService;

    @Operation(
            summary = "List Persons",
            description = "List Persons"
    )
    @GetMapping(
            value = ""
    )
    public DataListResponse<PersonDTO> list(
            HttpServletResponse servletResponse
    ) {

        DataListResponse<PersonDTO> response = new DataListResponse<>();

        try {
            response = personService.list();
            response.setMessage(DomainReturnCode.SUCCESSFUL_OPERATION.getDesc());
            servletResponse.setStatus(HttpServletResponse.SC_OK);
            return response;

        } catch (ApplicationBusinessException error) {
            response.setResponse(error);
            response.setSeverity(MODERATE);
            servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return response;
    }

    @Operation(
            summary = "Get Person by Id",
            description = "Get Person by Id"
    )
    @GetMapping(
            value = "{id}"
    )
    public DataResponse<PersonDTO> get(
            @PathVariable(value = "id") Long id,
            HttpServletResponse servletResponse
    ) {

        DataResponse<PersonDTO> response = new DataResponse<>();

        try {
            response = personService.getById(id);
            response.setMessage(DomainReturnCode.SUCCESSFUL_OPERATION.getDesc());
            servletResponse.setStatus(HttpServletResponse.SC_OK);
            return response;

        } catch (ApplicationBusinessException error) {
            response.setResponse(error);
            response.setSeverity(LOW);
            servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return response;
    }

    @Operation(
            summary = "Create a new Person",
            description = "Create a new Person"
    )
    @PostMapping(
            value = "/create",
            consumes = "application/json",
            produces = "application/json"
    )
    public DataResponse<PersonDTO> create(
            @RequestBody PersonDTO bodyRequest,
            HttpServletResponse servletResponse
    ) {

        DataRequest<PersonDTO> request = new DataRequest<>(bodyRequest, "br");
        DataResponse<PersonDTO> response = new DataResponse<>();

        try {
            response = personService.create(request);
            response.setMessage(DomainReturnCode.SUCCESSFUL_OPERATION.getDesc());
            servletResponse.setStatus(HttpServletResponse.SC_OK);

            return response;

        } catch (ApplicationBusinessException error) {
            response.setResponse(error);
            response.setSeverity(VERY_HIGH);
            servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            return response;
        }
    }
}
