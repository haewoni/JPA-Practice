package review;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor

@Getter
@Setter
@ToString
@Table(name = "DEPT")
//@SequenceGenerator(name = "dept1_seq", sequenceName = "dept1_seq_id", allocationSize = 10, initialValue = 1)
@Entity
public class Dept1 {

	@Id
	@NonNull
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept1_seq") 
	@Column(name = "DEPTNO")
	private Integer deptNo;

	@NonNull
	@Column(name = "DNAME")
	private String dName;

	@NonNull
	@Column(name = "LOC")
	private String loc;
	
	@OneToMany(mappedBy = "deptNo")
	private List<Emp1> emp1 = new ArrayList<>();
}

/*
 * create sequence hibernate_sequence start with 1 increment by 1 create table
 * Team1 ( team_id number(19,0) not null, team_name varchar2(20), primary key
 * (team_id) );
 * 수정
 */