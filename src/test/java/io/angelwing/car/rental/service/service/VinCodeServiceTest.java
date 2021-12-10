package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.VinCode;
import io.angelwing.car.rental.service.repository.VinCodeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;

import static io.angelwing.car.rental.service.generator.VinCodeGenerator.generateRandomVinCode;
import static io.angelwing.car.rental.service.generator.VinCodeGenerator.generateRandomVinCodes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class VinCodeServiceTest {

    private final VinCodeRepository vinCodeRepository = mock(VinCodeRepository.class);

    private final VinCodeService vinCodeService = new VinCodeServiceImpl(vinCodeRepository);

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(vinCodeRepository);
    }

    @Test
    void addVinCode() {
        final VinCode expectedVinCode = generateRandomVinCode();
        String vinCodeId = expectedVinCode.getId();

        when(vinCodeRepository.save(expectedVinCode)).thenReturn(expectedVinCode);
        when(vinCodeRepository.findById(vinCodeId)).thenReturn(Optional.of(expectedVinCode));

        vinCodeService.save(expectedVinCode);

        Optional<VinCode> actualVinCode = vinCodeService.findById(vinCodeId);
        verify(vinCodeRepository).save(expectedVinCode);
        verify(vinCodeRepository).findById(vinCodeId);

        assertThat(actualVinCode).contains(expectedVinCode);
    }

    @Test
    void findAllVinCode() {
        final Collection<VinCode> expectedVinCode = generateRandomVinCodes(5);
        when(vinCodeRepository.findAll()).thenReturn(expectedVinCode);

        Collection<VinCode> actualVinCode = vinCodeService.findAll();
        verify(vinCodeRepository).findAll();

        assertThat(actualVinCode).containsExactlyElementsOf(expectedVinCode);
    }

}