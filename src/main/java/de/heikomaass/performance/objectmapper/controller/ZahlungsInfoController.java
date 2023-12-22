package de.heikomaass.performance.objectmapper.controller;


import de.heikomaass.performance.objectmapper.controller.dto.AngebotDto;
import de.heikomaass.performance.objectmapper.controller.mapper.AngebotMapper;
import de.heikomaass.performance.objectmapper.core.Angebot;
import de.heikomaass.performance.objectmapper.core.AngebotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class ZahlungsInfoController {

    private final AngebotService angebotService;

    private final AngebotMapper angebotMapper;

    @GetMapping(path = "/angebote")
    public List<AngebotDto> getAngebote() {
        List<Angebot> angebote = angebotService.getAngebote();
        return angebotMapper.toAngebotDtoList(angebote);
    }
}
