package com.ssafy.ssafit.service;

import java.util.List;

import com.ssafy.ssafit.dto.Exercise;

public interface ExerciseService {
	
	//해당 맴버의 운동 리스트 가져오기 
	public List<Exercise> getExerciseList(int userid);
	//해당 맴버의 운동 리스트 추가하기 
	public int registExercise(Exercise exercise);
	//해당 맴버의 운동 리스트 제거하기 
	public void deleteExercise(int exerciseid);
	//해당 맴버의 운동 이름 변경 
	public void modifyExercise(Exercise exercise);

}
