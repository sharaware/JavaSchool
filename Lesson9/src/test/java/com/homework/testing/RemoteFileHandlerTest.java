package com.homework.testing;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RemoteFileHandler.class)
public class RemoteFileHandlerTest {

    @Mock private SettingsLoader settingsLoader;
    @Mock private ResponseRepository responseRepository;

    public RemoteFileHandlerTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void handleRequestTest() throws Exception {
        //when(settingsLoader.loadSettings()).thenReturn(null);
        //settingsLoader.loadSettings();
        when(settingsLoader.loadSettings()).thenReturn(null);
        RemoteFileHandler fileHandler = new RemoteFileHandler(settingsLoader, responseRepository);
        assertNotNull(fileHandler);
        fileHandler.handleRequest();
        verify(responseRepository, times(0)).writeResult(anyList());
        verify(responseRepository, times(0)).writeError(anyString());

        when(settingsLoader.loadSettings()).thenReturn(Collections.emptyMap());
        fileHandler.handleRequest();
        verify(responseRepository, times(0)).writeResult(anyList());
        verify(responseRepository, times(0)).writeError(anyString());

        RemoteFileReadWriter remoteFileHandler = mock(RemoteFileReadWriter.class);
        PowerMockito.whenNew(RemoteFileReadWriter.class).withNoArguments().thenReturn(remoteFileHandler);
        when(remoteFileHandler.readFileToList(anyMap())).thenReturn(List.of("test list"));

        when(settingsLoader.loadSettings()).thenReturn(Map.of("one", "two"));
        fileHandler.handleRequest();
        verify(responseRepository, times(1)).writeResult(List.of("test list"));
        verify(responseRepository, times(0)).writeError(anyString());

        when(remoteFileHandler.readFileToList(anyMap())).thenThrow(new IllegalArgumentException("test exception"));
        fileHandler.handleRequest();
        verify(responseRepository, times(1)).writeResult(anyList());
        verify(responseRepository, times(1)).writeError("test exception");

        verify(settingsLoader, times(4)).loadSettings();
    }

    @Test
    public void handleResponseTest() throws Exception {
        RemoteFileHandler fileHandler = PowerMockito.spy(new RemoteFileHandler(settingsLoader, responseRepository));
        PowerMockito.doReturn(true).when(fileHandler, "validate", ArgumentMatchers.anyList());
        when(responseRepository.writeResult(List.of("test list"))).thenReturn(false);
        fileHandler.handleResponse(List.of("test list"));
        PowerMockito.verifyPrivate(fileHandler).invoke("validate", List.of("test list"));

        when(responseRepository.writeResult(List.of("test list"))).thenReturn(true);
        RemoteFileReadWriter remoteFileHandler = mock(RemoteFileReadWriter.class);
        PowerMockito.whenNew(RemoteFileReadWriter.class).withNoArguments().thenReturn(remoteFileHandler);
        fileHandler.handleResponse(List.of("test list"));
        verify(remoteFileHandler ,times(1)).writeResponse();

        PowerMockito.doReturn(false).when(fileHandler, "validate", ArgumentMatchers.anyList());
        fileHandler.handleResponse(List.of("test list"));
        verify(responseRepository, times(1)).writeError("Ошибка валидации");
    }

    @Test
    public void handleErrorTest() {
        RemoteFileHandler fileHandler = new RemoteFileHandler(settingsLoader, responseRepository);
        assertNotNull(fileHandler);
        boolean res = fileHandler.handleError(null);
        assertFalse(res);
        res = fileHandler.handleError(Collections.emptyList());
        assertFalse(res);
        res = fileHandler.handleError(List.of("legal string"));
        assertTrue(res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleErrorTestThrow() {
        RemoteFileHandler fileHandler = new RemoteFileHandler(settingsLoader, responseRepository);
        assertNotNull(fileHandler);
        boolean res = fileHandler.handleError(List.of("error"));
    }
}