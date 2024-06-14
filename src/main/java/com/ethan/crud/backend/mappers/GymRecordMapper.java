package com.ethan.crud.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.ethan.crud.backend.dtos.GymRecordDto;
import com.ethan.crud.backend.entities.GymRecord;

@Mapper(componentModel = "spring")
public interface GymRecordMapper {


    GymRecord toGymRecord(GymRecordDto gymRecordDto);

    @Mapping(target = "date", source = "created")
    GymRecordDto toGymRecordDto(GymRecord gymRecord);

    List<GymRecordDto> toGymRecordDtos(List<GymRecord> gymRecords);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    void updateGymRecord(@MappingTarget GymRecord target, GymRecord source);
}