package ex07;

import static java.util.stream.Collectors.*;

import java.sql.Struct;

import static java.util.Comparator.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;


// groupingBy()

class Student3{
	String name;
	boolean isMale; // 성별
	int hak; // 학년
	int ban; // 반
	int score;
	
	Student3(String name, boolean isMale, int hak, int ban, int score){
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	 String getName() {return name;}
	 boolean isMale() {return isMale;}
	 int getHak() {return hak;}
	 int getBan() {return ban;}
	 int getScore() {return score;}

	@Override
	public String toString() {
		return String.format("[%s, %s, %d학년 %d반, %3d점]", 
				name, isMale ? "남": "여", hak, ban, score);
	}
	
	enum Level{
		High, Mid, Low
	} 

}


public class StreamEx10 {
	public static void main(String[] args) {
		
		Student3[] stuArr = {
				new Student3("이자바", true, 1, 1, 300),
				new Student3("김스트", false, 1 ,1 ,250),
				new Student3("안자바", true, 1, 1, 200),
				new Student3("박스트", false, 1, 2, 150),
				new Student3("소자바", true, 1, 2, 100),
				new Student3("나자바", false, 1, 2, 50),
				new Student3("감스트", false, 1, 3, 180),
				new Student3("이스트", false, 1, 3, 200),
				new Student3("황자바", true, 1, 3, 180),
				
				new Student3("이자바", true, 2, 1, 300),
				new Student3("김스트", false, 2 ,1 ,250),
				new Student3("안자바", true, 2, 1, 200),
				new Student3("박스트", false, 2, 2, 150),
				new Student3("소자바", true, 2, 2, 100),
				new Student3("나자바", false, 2, 2, 50),
				new Student3("감스트", false, 2, 3, 180),
				new Student3("이스트", false, 2, 3, 200),
				new Student3("황자바", true, 2, 3, 180),
		};
		
		System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
		Map<Integer, List<Student3>> stuByBan = Stream.of(stuArr)
					.collect(groupingBy(Student3::getBan));
		
		for(List<Student3> ban : stuByBan.values()) {
			for(Student3 s : ban) {
				System.out.println(s);
			}
		}
		
		System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
		Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr)
					.collect(groupingBy(s -> {
						if(s.getScore() >= 200) return Student3.Level.High;
				   else if(s.getScore() >= 100) return Student3.Level.Mid;
				   else							return Student3.Level.Low;
				}));
		
		TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());
		
		for(Student3.Level key : keySet) {
			System.out.println("["+key+"]");
			
			for(Student3 s : stuByLevel.get(key))
				System.out.println(s);
			System.out.println();
		}
		
		System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
		Map<Student3.Level, Long> stuCntByLevel = Stream.of(stuArr)
					.collect(groupingBy(s -> {
						if(s.getScore() >= 200) return Student3.Level.High;
				   else if(s.getScore() >= 100) return Student3.Level.Mid;
				   else							return Student3.Level.Low;
					}, counting()));
		for(Student3.Level key : stuCntByLevel.keySet())
			System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
		System.out.println();
		
		
		System.out.printf("%n4. 다중그룹화(학년별, 반별)");
		Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan = 
				Stream.of(stuArr)
					.collect(groupingBy(Student3::getHak,
							groupingBy(Student3::getBan)
							));
		
		for(Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
			for(List<Student3> ban : hak.values()) {
				System.out.println();
				for(Student3 s : ban)
					System.out.println(s);
			}
		}
		
		System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별1등)%n");
		Map<Integer, Map<Integer, Student3>> topStuByHakAndBan =
				Stream.of(stuArr)
					.collect(groupingBy(Student3::getHak,
							 groupingBy(Student3::getBan,
									 collectingAndThen(
											 maxBy(comparingInt(Student3::getScore))
											 , Optional::get
											 )
									 )
							));
		
		for(Map<Integer, Student3> ban : topStuByHakAndBan.values())
			for(Student3 s : ban.values())
				System.out.println(s);
		
		System.out.println("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
		Map<String, Set<Student3.Level>> stuByScoreGroup = Stream.of(stuArr)
					.collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
							mapping(s -> {
								if(s.getScore() >= 200) return Student3.Level.High;
					       else if(s.getScore() >= 100) return Student3.Level.Mid;
					       else						    return Student3.Level.Low;
							}, toSet())
						));
		
		Set<String> keySet2 = stuByScoreGroup.keySet();
		
		for(String key : keySet2) {
			System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
		}
	}

}
