package me.anichakra.poc.ruleservice.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.openl.rules.context.IRulesRuntimeContext;
import org.openl.rules.context.RulesRuntimeContextFactory;
import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.IEngineWrapper;
import org.openl.vm.IRuntimeEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import me.anichakra.poc.ruleservice.dao.StudentManagementDao;
import me.anichakra.poc.ruleservice.entites.Student;
import me.anichakra.poc.ruleservice.rules.GradeRule;
import me.anichakra.poc.ruleservice.rules.Simple;
import me.anichakra.poc.ruleservice.util.ResourceLoaderUtil;
import me.anichakra.poc.ruleservice.vo.Book;
import me.anichakra.poc.ruleservice.vo.BookStuInfo;
import me.anichakra.poc.ruleservice.vo.GradeInfo;
import me.anichakra.poc.ruleservice.vo.StudentSub;

@Service
public class StudentManagementService {

	@Autowired
	private StudentManagementDao studentManagementDao;

	@Autowired
	private ResourceLoaderUtil resourceLoaderUtil;

	public Student saveStudentInfo(Student student) {
		// TODO Auto-generated method stub
		return studentManagementDao.save(student);
	}

	public Optional<Student> getStudentById(Integer rollNumber) {
		// TODO Auto-generated method stub
		return studentManagementDao.findById(rollNumber);
	}

	public Iterable<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentManagementDao.findAll();
	}

	public String getRankerStudent(Integer rollNumber) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(new ClassPathResource("TemplateRules.xlsx").getFile().getPath());
		RulesEngineFactory<Simple> rulesFactory =

				new RulesEngineFactory<Simple>(new ClassPathResource("TemplateRules.xlsx").getFile().getPath(),

						Simple.class);

		Simple rules = (Simple) rulesFactory.newInstance();

		System.out.println("name" + rules.rankerStudentName(rollNumber));
		return rules.rankerStudentName(rollNumber);
	}

	public ArrayList<GradeInfo> getGrade() throws IOException {
		// TODO Auto-generated method stub

		/*
		 * RulesEngineFactory<GradeRule > rulesFactory =
		 * 
		 * new RulesEngineFactory<GradeRule>(new
		 * ClassPathResource("gradeCal.xlsx").getFile().getPath(),
		 * 
		 * GradeRule.class);
		 */

		GradeRule rules = (GradeRule) getRuleFactory().newInstance();
		ArrayList<GradeInfo> gradeInfos = new ArrayList<GradeInfo>();

		for (Student student : studentManagementDao.findAll()) {
			String grade = rules.greadGenerator(student.getScore());
			GradeInfo gradeInfo = new GradeInfo();
			gradeInfo.setName(student.getStudentName());
			gradeInfo.setRollNum(student.getRollNumber());
			gradeInfo.setScore(student.getScore());
			gradeInfo.setGrade(grade);
			gradeInfos.add(gradeInfo);
		}

		return gradeInfos;
	}

	public ArrayList<BookStuInfo> getBookSuggetion() throws IOException {
		// TODO Auto-generated method stub
		/*
		 * RulesEngineFactory<GradeRule > rulesFactory =new
		 * RulesEngineFactory<GradeRule>(new
		 * ClassPathResource("gradeCal.xlsx").getFile().getPath(),
		 * 
		 * GradeRule.class);
		 */

		/*
		 * RulesEngineFactory<GradeRule > rulesFactory =new
		 * RulesEngineFactory<GradeRule>(new
		 * ClassPathResource("gradeCal.xlsx").getFile().getPath(),
		 * 
		 * GradeRule.class);
		 */
		GradeRule rules = (GradeRule) getRuleFactory().newInstance();
		ArrayList<BookStuInfo> bookStuInfos = new ArrayList<BookStuInfo>();

		for (Student s : studentManagementDao.findAll()) {
			Book b = new Book();
			StudentSub s1 = new StudentSub();
			s1.setClassSpec(s.getClassSpec());
			s1.setFabSub(s.getFabSub());
			Book book = rules.getBookDetails1(s1, b);
			BookStuInfo bookStuInfo = new BookStuInfo();
			bookStuInfo.setName(book.getName());
			bookStuInfo.setCost(book.getCost());
			bookStuInfo.setStuName(s.getStudentName());
			bookStuInfo.setRollNum(s.getRollNumber());
			bookStuInfos.add(bookStuInfo);

		}
		return bookStuInfos;

	}

	public RulesEngineFactory<GradeRule> getRuleFactory() throws IOException {
		return new RulesEngineFactory<GradeRule>(
				resourceLoaderUtil.getResource("classpath:gradeCal.xlsx").getFile().getPath(),

				GradeRule.class);

	}

	public String getSholarshipDetails(String s,Integer gdpa) throws IOException {
		// TODO Auto-generated method stub
		
		GradeRule rules = (GradeRule) getRuleFactory().newInstance();
		
		IRuntimeEnv env = ((IEngineWrapper) rules).getRuntimeEnv();

		// Creating context (most probably in future, the code will be
		// different)

		IRulesRuntimeContext context = RulesRuntimeContextFactory.buildRulesRuntimeContext();
		env.setContext(context);

		context.setLob(s);
		String g=rules.getScholarShip(gdpa);
		return g;
	}

}
