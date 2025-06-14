package com.trepudox.pessoaservice.infra.mapper;

import com.trepudox.pessoaservice.core.dto.PessoaDTO;
import com.trepudox.pessoaservice.infra.persistence.model.PessoaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(imports = {LocalDateTime.class})
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaModel pessoaDTOToPessoaModel(PessoaDTO pessoaDTO);

    PessoaDTO pessoaModelToPessoaDTO(PessoaModel pessoaModel);

    List<PessoaDTO> pessoaModelListToPessoaDTOList(List<PessoaModel> pessoaModelList);
}
