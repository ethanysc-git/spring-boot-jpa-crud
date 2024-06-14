package com.ethan.crud.backend.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ethan.crud.backend.dtos.GymRecordDto;
import com.ethan.crud.backend.entities.GymRecord;
import com.ethan.crud.backend.exceptions.AppException;
import com.ethan.crud.backend.mappers.GymRecordMapper;
import com.ethan.crud.backend.repositories.GymRecordsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecordsService {

    private final GymRecordsRepository gymRecordsRepository;
    private final GymRecordMapper gymRecordMapper;

    public List<GymRecordDto> allRecords() {
        return gymRecordMapper.toGymRecordDtos(gymRecordsRepository.findAll());
    }

    public GymRecordDto createGymRecords(GymRecordDto gymRecordDto) {
        GymRecord gymRecord = gymRecordMapper.toGymRecord(gymRecordDto);

        GymRecord savedGymRecord = gymRecordsRepository.save(gymRecord);

        return gymRecordMapper.toGymRecordDto(savedGymRecord);
    }

    public GymRecordDto updateGymRecord(Long id, GymRecordDto recordDto) {
        GymRecord record = gymRecordsRepository.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found", HttpStatus.NOT_FOUND));

        gymRecordMapper.updateGymRecord(record, gymRecordMapper.toGymRecord(recordDto));

        GymRecord savedGymRecord = gymRecordsRepository.save(record);

        return gymRecordMapper.toGymRecordDto(savedGymRecord);
    }

    public GymRecordDto patchGymRecord(Long id, GymRecordDto recordDto) {
        GymRecord record = gymRecordsRepository.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found", HttpStatus.NOT_FOUND));

        if (recordDto.getExercise() != null) {
            record.setExercise(recordDto.getExercise());
        }

        if (recordDto.getWeight() != null) {
            record.setWeight(recordDto.getWeight());
        }

        GymRecord savedRecord = gymRecordsRepository.save(record);

        return gymRecordMapper.toGymRecordDto(savedRecord);
    }

    public GymRecordDto deleteGymRecord(Long id) {
        GymRecord record = gymRecordsRepository.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found", HttpStatus.NOT_FOUND));
        GymRecordDto gymRecordDto = gymRecordMapper.toGymRecordDto(record);

        gymRecordsRepository.deleteById(id);

        return gymRecordDto;
    }

    public GymRecordDto getGymRecord(Long id) {
        GymRecord record = gymRecordsRepository.findById(id)
                .orElseThrow(() -> new AppException("Gym record not found", HttpStatus.NOT_FOUND));
        return gymRecordMapper.toGymRecordDto(record);
    }
}