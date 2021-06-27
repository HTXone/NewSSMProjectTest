package com.TestSys.Service;

import com.TestSys.entity.Classes;

import java.util.List;

public interface ClassesService {
    int NewClass(String ClassName,String ClassTime,int TeacherID,String ClassRoom,String ClassType,int ClassWeek,int CollegeID);
    int NewClass(Classes classes);
    int NewClassID();
    int UpdateClass(int ClassID,String ClassName,String ClassTime,String ClassRoom,String ClassType,int ClassWeek,int Score);
    int UpdateClassInfo(Classes classes);
    int DeleteClass(int ClassID);
    boolean UsedClass(int ClassID);

    List<Classes> SelectAllClasses();
    Classes SelectClassesByID(int classesID);
    List<Classes> SelectClassesByTeacher(int TeacherID);
    List<Classes> SelectClassesByName(String className);


}
