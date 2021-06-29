package com.TestSys.Service.impl;

import com.TestSys.Service.ScoreService;
import com.TestSys.entity.Score;
import com.TestSys.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public List<Score> SelectAllScore() {
        return scoreMapper.selectALL();
    }

    @Override
    public List<Score> SelectScoreByCourseID(int courseID) {
        return scoreMapper.selectByCourseID(courseID);
    }

    @Override
    public List<Score> SelectScoreByStudentID(int studentID) {
        return scoreMapper.selectByStudentID(studentID);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int MarkScore(int courseID, int studentID, int score) {
        Score score1 = new Score();
        score1.setCourseID(courseID);
        score1.setStudentID(studentID);
        score1.setMark(score);
        return scoreMapper.mark(score1);
    }

    @Override
    public int MarkScore(Score score) {
        return scoreMapper.mark(score);
    }


    @Override
    public int isSelectedCourse(int courseID, int studentID) {
        if(scoreMapper.isSelected(courseID,studentID)>0){
            return 0;
        }
        else {
            Score score = new Score();
            score.setStudentID(studentID);
            score.setCourseID(courseID);
            return scoreMapper.AddScore(score);
        }
    }

    @Override
    public int RemoveSelectedCourse(int courseID, int studentID) {
        Score score = scoreMapper.SelectScore(studentID,courseID);
        if(score == null){
            return 0;
        }
        if(score.getMark() != null){
            return 0;
        }
        return scoreMapper.delete(score);
    }

    @Override
    public int SelectedCourse(int courseID, int studentID) {
        if(scoreMapper.SelectScore(studentID,courseID)!=null){
            return 0;
        }
        else {
            Score score = new Score();
            score.setStudentID(studentID);
            score.setCourseID(courseID);
            return scoreMapper.AddScore(score);
        }
    }
}
