package de.heikomaass.performance.controller;


import de.heikomaass.performance.core.service.AngebotService;
import de.heikomaass.performance.controller.dto.AngebotDto;
import de.heikomaass.performance.controller.mapper.AngebotMapper;
import de.heikomaass.performance.core.model.Angebot;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class AngebotController {

    private final AngebotService angebotService;

    private final AngebotMapper angebotMapper;

    @GetMapping(path = "/angebote")
    public List<AngebotDto> getAngebote() {
        List<Angebot> angebote = angebotService.getAngebote();
        return angebotMapper.toAngebotDtoList(angebote);
    }
}
