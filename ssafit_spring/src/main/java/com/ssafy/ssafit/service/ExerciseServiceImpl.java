package com.ssafy.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.dao.ExerciseDao;
import com.ssafy.ssafit.dto.Exercise;

@Service
public class ExerciseServiceImpl implements ExerciseService {
	
	private ExerciseDao exerciseDao;
	
	@Autowired
	public void setExerciseDao(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}

	@Override
	public List<Exercise> getExerciseList(int userid) {
		return exerciseDao.selectAll(userid);
	}

	@Transactional
	@Override
	public int registExercise(Exercise exercise) {
		return exerciseDao.insertExercise(exercise);
	}

	@Transactional
	@Override
	public void deleteExercise(int exerciseid) {
		exerciseDao.deleteExercise(exerciseid);
	}

	@Transactional
	@Override
	public void modifyExercise(Exercise exercise) {
		exerciseDao.updateExercise(exercise);
	}

}
