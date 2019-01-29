package me.anichakra.poc.ruleservice.rules;

import me.anichakra.poc.ruleservice.entites.Student;
import me.anichakra.poc.ruleservice.vo.Book;
import me.anichakra.poc.ruleservice.vo.StudentSub;

public interface GradeRule {

	String greadGenerator(int score);
	Book getBookDetails1(StudentSub s,Book b);
	String getScholarShip(int gdpa);
}
