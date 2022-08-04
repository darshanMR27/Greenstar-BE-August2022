package com.outreach.greenstar.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.HolidayDTO;
import com.outreach.greenstar.entities.Holiday;
import com.outreach.greenstar.service.HolidayService;

@RestController
@RequestMapping("/api/v1/holiday")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;
    
    @GetMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HolidayDTO>> getAllHolidays() {
        List<HolidayDTO> holidayList = holidayService.getAllHolidays();
        return new ResponseEntity<>(holidayList, HttpStatus.OK);
    }
    
    @GetMapping(path="/{holidayId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HolidayDTO> getHolidayById(@PathVariable int holidayId) {
        HolidayDTO holiday = holidayService.getHolidayById(holidayId);
        return new ResponseEntity<>(holiday, HttpStatus.OK);
    }
    
    @PostMapping(path="/bulk", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Holiday>> createHolidays(@RequestBody List<HolidayDTO> listOfHolidays) {
        List<Holiday> successHolidays = holidayService.createHolidays(listOfHolidays);
        boolean isSuccess = listOfHolidays.size() == successHolidays.size();
        return new ResponseEntity<>(successHolidays, isSuccess ? HttpStatus.CREATED:HttpStatus.EXPECTATION_FAILED);
    }
    
    @PostMapping(path="/new", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HolidayDTO> createHoliday(@RequestBody HolidayDTO holiday) {
        HolidayDTO holDTO = holidayService.createHoliday(holiday);
        return new ResponseEntity<>(holDTO, HttpStatus.CREATED);
    }
    
    @PostMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HolidayDTO> updateHoliday(@RequestBody HolidayDTO holiday) {
        HolidayDTO holDTO = holidayService.updateHoliday(holiday);
        return new ResponseEntity<>(holDTO, HttpStatus.CREATED);
    }
    
    @DeleteMapping(value="/{holidayId}")
    public ResponseEntity<String> deleteHoliday(@PathVariable int holidayId) {
        holidayService.deleteHoliday(holidayId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
    
}
