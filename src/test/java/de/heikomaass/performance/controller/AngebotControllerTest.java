package de.heikomaass.performance.controller;

import de.heikomaass.performance.controller.dto.AngebotDto;
import de.heikomaass.performance.controller.mapper.AngebotMapper;
import de.heikomaass.performance.core.model.Angebot;
import de.heikomaass.performance.core.service.AngebotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AngebotControllerTest {

    @Mock
    private AngebotService angebotService;

    @Mock
    private AngebotMapper angebotMapper;

    @InjectMocks
    private AngebotController angebotController;

    @Test
    void shouldInvokeServiceAndMapper() {
        List<Angebot> expectedAngebote = List.of(mock(Angebot.class));
        List<AngebotDto> expectedDtos = List.of(mock(AngebotDto.class));

        when(angebotService.getAngebote()).thenReturn(expectedAngebote);
        when(angebotMapper.toAngebotDtoList(expectedAngebote)).thenReturn(expectedDtos);

        List<AngebotDto> returnedDtos = angebotController.getAngebote();
        assertThat(returnedDtos).isEqualTo(expectedDtos);
    }
}