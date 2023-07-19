package com.ssafy.ssafit.dao;

import java.util.List;

import com.ssafy.ssafit.dto.Exercise;

public interface ExerciseDao {
	
	public List<Exercise> selectAll(int userid);
	public int insertExercise(Exercise exercise);
	public Exercise selectOne(int exerciseid);
	public void deleteExercise(int exerciseid);
	public void updateExercise(Exercise exercise);

}
