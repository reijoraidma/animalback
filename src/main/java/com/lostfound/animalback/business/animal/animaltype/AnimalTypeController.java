package com.lostfound.animalback.business.animal.animaltype;

import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfo;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfoSave;
import com.lostfound.animalback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnimalTypeController
{
    private AnimalTypeService animalTypeService;


    @GetMapping("/animal/animaltypes")
    @Operation(summary = "Get animal type", description = "returns all ACTIVE(approved) animal types in body")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<AnimalTypeInfo> getAnimalTypes() {
       return animalTypeService.getAnimalTypes();
    }

    @PostMapping("/animal/animaltype")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add new animal type", description = "imageData and name are mandatory, name is formatted to uppercase and whitespace is removed," +
            " all new added animal types are DISABLED and not visible until further check. Returns added animal type in body on success ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "403", description = "Animal type already exists", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public AnimalTypeInfo addAnimalType(@RequestBody AnimalTypeInfoSave animalTypeInfoSave) {
        return animalTypeService.addAnimalType(animalTypeInfoSave);
    }

}
