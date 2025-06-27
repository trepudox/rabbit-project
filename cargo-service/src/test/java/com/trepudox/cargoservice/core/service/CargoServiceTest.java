package com.trepudox.cargoservice.core.service;

import com.trepudox.cargoservice.core.dto.CargoDTO;
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

    private CargoDTO cargoDTO;

    @BeforeEach
    void setUp() {
        cargoDTO = new CargoDTO(1L, "Desenvolvedor", "Desenvolvedor de Software");
    }

    @Nested
    class CreateTests {

        @Test
        @DisplayName("Deve criar um cargo com sucesso")
        void testCreate_Success() {
            when(databaseOutputPort.save(any(CargoDTO.class))).thenReturn(cargoDTO);

            CargoDTO result = cargoService.create(cargoDTO);

            assertNotNull(result);
            assertEquals(cargoDTO.getId(), result.getId());
            assertEquals(cargoDTO.getFuncao(), result.getFuncao());
            assertEquals(cargoDTO.getDescricao(), result.getDescricao());
            verify(databaseOutputPort, times(1)).save(cargoDTO);
        }

    }

    @Nested
    class GetAllTests {

        @Test
        @DisplayName("Deve retornar todos os cargos")
        void testGetAll_Success() {
            List<CargoDTO> cargoList = List.of(cargoDTO);
            when(databaseOutputPort.getAll()).thenReturn(cargoList);

            List<CargoDTO> result = cargoService.getAll();

            assertNotNull(result);
            assertFalse(result.isEmpty());
            assertEquals(1, result.size());
            verify(databaseOutputPort, times(1)).getAll();
        }

        @Test
        @DisplayName("Deve retornar uma lista vazia quando não houver cargos")
        void testGetAll_EmptyList() {
            when(databaseOutputPort.getAll()).thenReturn(Collections.emptyList());

            List<CargoDTO> result = cargoService.getAll();

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
            when(databaseOutputPort.getById(1L)).thenReturn(Optional.of(cargoDTO));

            CargoDTO result = cargoService.getById(1L);

            assertNotNull(result);
            assertEquals(cargoDTO.getId(), result.getId());
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
            CargoDTO updatedCargo = new CargoDTO(1L, "Desenvolvedor Sênior", "Desenvolvedor de Software Sênior");
            when(databaseOutputPort.getById(1L)).thenReturn(Optional.of(cargoDTO));
            when(databaseOutputPort.save(updatedCargo)).thenReturn(updatedCargo);

            CargoDTO result = cargoService.update(updatedCargo);

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
            CargoDTO nonExistentCargo = new CargoDTO(id, "Cargo Inexistente", "Descrição");
            when(databaseOutputPort.getById(id)).thenReturn(Optional.empty());

            EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> cargoService.update(nonExistentCargo));

            assertEquals("Pessoa com id %d não encontrado".formatted(id), exception.getMessage());
            verify(databaseOutputPort, times(1)).getById(id);
            verify(databaseOutputPort, never()).save(any(CargoDTO.class));
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
