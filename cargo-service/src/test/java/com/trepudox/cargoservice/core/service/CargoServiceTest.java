package com.trepudox.cargoservice.core.service;

import com.trepudox.cargoservice.core.view.CargoView;
import com.trepudox.cargoservice.core.exception.EntityNotFoundException;
import com.trepudox.cargoservice.core.port.out.DatabaseOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CargoServiceTest {

    @Mock
    private DatabaseOutputPort databaseOutputPort;

    @InjectMocks
    private CargoService cargoService;

    private CargoView cargoView;

    @BeforeEach
    void setUp() {
        cargoView = new CargoView(1L, "Desenvolvedor", "Desenvolvedor de Software");
    }

    @Nested
    class CreateTests {

        @Test
        @DisplayName("Deve criar um cargo com sucesso")
        void testCreate_Success() {
            when(databaseOutputPort.save(any(CargoView.class))).thenReturn(cargoView);

            CargoView result = cargoService.create(cargoView);

            assertNotNull(result);
            assertEquals(cargoView.getId(), result.getId());
            assertEquals(cargoView.getFuncao(), result.getFuncao());
            assertEquals(cargoView.getDescricao(), result.getDescricao());
            verify(databaseOutputPort, times(1)).save(cargoView);
        }

    }

    @Nested
    class GetAllTests {

        @Test
        @DisplayName("Deve retornar todos os cargos")
        void testGetAll_Success() {
            List<CargoView> cargoList = List.of(cargoView);
            when(databaseOutputPort.getAll()).thenReturn(cargoList);

            List<CargoView> result = cargoService.getAll();

            assertNotNull(result);
            assertFalse(result.isEmpty());
            assertEquals(1, result.size());
            verify(databaseOutputPort, times(1)).getAll();
        }

        @Test
        @DisplayName("Deve retornar uma lista vazia quando não houver cargos")
        void testGetAll_EmptyList() {
            when(databaseOutputPort.getAll()).thenReturn(Collections.emptyList());

            List<CargoView> result = cargoService.getAll();

            assertNotNull(result);
            assertTrue(result.isEmpty());
            verify(databaseOutputPort, times(1)).getAll();
        }
    }

    @Nested
    class GetByIdTests {

        @Test
        @DisplayName("Deve retornar um cargo pelo ID com sucesso")
        void testGetById_Success() {
            when(databaseOutputPort.getById(1L)).thenReturn(Optional.of(cargoView));

            CargoView result = cargoService.getById(1L);

            assertNotNull(result);
            assertEquals(cargoView.getId(), result.getId());
            verify(databaseOutputPort, times(1)).getById(1L);
        }

        @Test
        @DisplayName("Deve lançar EntityNotFoundException quando o cargo não for encontrado pelo ID")
        void testGetById_NotFound() {
            long id = 9999L;
            when(databaseOutputPort.getById(id)).thenReturn(Optional.empty());

            EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> cargoService.getById(id));

            assertEquals("Cargo com id %d não encontrado".formatted(id), exception.getMessage());
            verify(databaseOutputPort, times(1)).getById(id);
        }
    }

    @Nested
    class UpdateTests {

        @Test
        @DisplayName("Deve atualizar um cargo com sucesso")
        void testUpdate_Success() {
            CargoView updatedCargo = new CargoView(1L, "Desenvolvedor Sênior", "Desenvolvedor de Software Sênior");
            when(databaseOutputPort.getById(1L)).thenReturn(Optional.of(cargoView));
            when(databaseOutputPort.save(updatedCargo)).thenReturn(updatedCargo);

            CargoView result = cargoService.update(updatedCargo);

            assertNotNull(result);
            assertEquals(updatedCargo.getFuncao(), result.getFuncao());
            assertEquals(updatedCargo.getDescricao(), result.getDescricao());
            verify(databaseOutputPort, times(1)).getById(1L);
            verify(databaseOutputPort, times(1)).save(updatedCargo);
        }

        @Test
        @DisplayName("Deve lançar EntityNotFoundException ao tentar atualizar um cargo inexistente")
        void testUpdate_NotFound() {
            long id = 2L;
            CargoView nonExistentCargo = new CargoView(id, "Cargo Inexistente", "Descrição");
            when(databaseOutputPort.getById(id)).thenReturn(Optional.empty());

            EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> cargoService.update(nonExistentCargo));

            assertEquals("Pessoa com id %d não encontrado".formatted(id), exception.getMessage());
            verify(databaseOutputPort, times(1)).getById(id);
            verify(databaseOutputPort, never()).save(any(CargoView.class));
        }
    }

    @Nested
    class DeleteTests {

        @Test
        @DisplayName("Deve deletar um cargo pelo ID com sucesso")
        void testDeleteById_Success() {
            long id = 1L;
            doNothing().when(databaseOutputPort).deleteById(id);

            assertDoesNotThrow(() -> cargoService.deleteById(id));

            verify(databaseOutputPort, times(1)).deleteById(id);
        }
    }

}
