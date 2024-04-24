package com.lostfound.animalback.business.animal.animalgender;

import com.lostfound.animalback.business.animal.animalgender.dto.AnimalGenderInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnimalGenderController {
    private final AnimalGenderService animalGenderService;


    @GetMapping("/animal/animalgenders")
    @Operation(summary = "Get animal type", description = "returns all animal genders in body")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<AnimalGenderInfo> getAnimalGenders() {
        return animalGenderService.getAnimalGenders();
    }
}
