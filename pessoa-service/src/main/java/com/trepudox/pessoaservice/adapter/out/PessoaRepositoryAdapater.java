package com.trepudox.pessoaservice.adapter.out;

import com.trepudox.pessoaservice.core.dto.PessoaDTO;
import com.trepudox.pessoaservice.core.port.out.DatabaseOutputPort;

import com.trepudox.pessoaservice.infra.mapper.PessoaMapper;
import com.trepudox.pessoaservice.infra.persistence.model.PessoaModel;
import com.trepudox.pessoaservice.infra.persistence.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PessoaRepositoryAdapater implements DatabaseOutputPort {

    private final PessoaRepository pessoaRepository;

    @Override
    public PessoaDTO save(PessoaDTO pessoaDTO) {
        PessoaModel pessoaModel = PessoaMapper.INSTANCE.pessoaDTOToPessoaModel(pessoaDTO);
        pessoaModel = pessoaRepository.save(pessoaModel);

        return PessoaMapper.INSTANCE.pessoaModelToPessoaDTO(pessoaModel);
    }

    @Override
    public List<PessoaDTO> getAll() {
        return PessoaMapper.INSTANCE.pessoaModelListToPessoaDTOList(pessoaRepository.findAll());
    }

    @Override
    public Optional<PessoaDTO> getById(Long id) {
        Optional<PessoaModel> pessoaModelOptional = pessoaRepository.findById(id);

        if (pessoaModelOptional.isPresent()) {
            PessoaDTO pessoaDTO = PessoaMapper.INSTANCE.pessoaModelToPessoaDTO(pessoaModelOptional.get());
            return Optional.of(pessoaDTO);
        }

        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }
}
