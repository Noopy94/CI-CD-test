package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.dto.Exercise;
import com.ssafy.ssafit.dto.Linktable;
import com.ssafy.ssafit.service.ExerciseService;
import com.ssafy.ssafit.service.LinktableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "운동 컨트롤러")
@RequestMapping("/api-exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;

	//해당 맴버 운동 리스트 가져오기 
	@ApiOperation(value="운동 목록")
	@GetMapping("/exercise")
	public ResponseEntity<?> list(int userid) {
		List<Exercise> list = exerciseService.getExerciseList(userid);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Exercise>>(list, HttpStatus.OK);
	}
	
	//리스트에 운동 추가하기 
	@ApiOperation(value="운동 등록")
	@PostMapping("/exercise")
	public ResponseEntity<Exercise> regist(Exercise exercise){
		exerciseService.registExercise(exercise);
		return new ResponseEntity<Exercise>(exercise, HttpStatus.CREATED);
	}
	
	//리스트에서 운동 삭제하기 
	@ApiOperation(value="운동 삭제")
	@DeleteMapping("/exercise/{exerciseid}")
	public ResponseEntity<Void> delete(@PathVariable int exerciseid){
		exerciseService.deleteExercise(exerciseid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//운동 수정하기 
	@ApiOperation(value="운동 수정")
	@PutMapping("/exercise")
	public ResponseEntity<Void> update(Exercise exercise){
		exerciseService.modifyExercise(exercise);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
