package com.example.demo;

import com.example.demo.bin.SillyInputBin;
import com.example.demo.entity.Silly;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SillyMapper {

    @Mapping(target = "numSupersilly", ignore = true)
    @Mapping(target = "numSilly", ignore = true)
    void updateSillyEntity(@MappingTarget Silly sillyToUpdate, Silly validSilly);

    SillyInputBin mapEntityToBin(Silly silly);

    Silly mapBinToEntity(SillyInputBin bin);
}
