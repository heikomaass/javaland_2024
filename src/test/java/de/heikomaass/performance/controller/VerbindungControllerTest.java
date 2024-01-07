package de.heikomaass.performance.controller;

import de.heikomaass.performance.adapter.VerbindungAdapter;
import de.heikomaass.performance.adapter.externalmodel.Verbindung;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class VerbindungControllerTest {

    @Mock
    private VerbindungAdapter verbindungAdapter;

    @InjectMocks
    private VerbindungController verbindungController;

    @Test
    void shouldInvokeAdapter() {
        List<Verbindung> expectedVerbindungList = List.of(mock(Verbindung.class));
        Mockito.when(verbindungAdapter.getVerbindungen()).thenReturn(expectedVerbindungList);
        List<Verbindung> returnedVerbindungList = verbindungController.getVerbindungen();
        assertThat(returnedVerbindungList).isEqualTo(expectedVerbindungList);
    }

}