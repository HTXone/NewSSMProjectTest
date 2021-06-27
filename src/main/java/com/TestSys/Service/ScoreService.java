package com.TestSys.Service;


import com.TestSys.entity.Score;
import com.TestSys.entity.Teacher;

import java.util.List;

public interface ScoreService {

    List<Score> SelectAllScore();
    List<Score> SelectScoreByCourseID(int courseID);
    List<Score> SelectScoreByStudentID(int studentID);
    int MarkScore(int courseID,int studentID,int score);
    int MarkScore(Score score);

}
