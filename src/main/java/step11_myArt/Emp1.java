package step11_myArt;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "EMP")
//@SequenceGenerator(name = "emp1_seq", sequenceName = "emp1_seq_id", allocationSize = 10, initialValue = 1)
@Entity
public class Emp1 {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp1_seq") S
	@Column(name = "EMPNO")
	private int empNo;

	@NonNull
	@Column(name = "ENAME")
	private String eName;

	@NonNull
	@Column(name = "JOB")
	private String job;

	@Column(name = "MGR")
	private Integer mgr;

	@NonNull
	@Column(name = "HIREDATE")
	private LocalDateTime hiredate;

	@NonNull
	@Column(name = "SAL")
	private Double sal;

	@Column(name = "COMM")
	private Double comm;

	@NonNull
	@OneToOne
	@JoinColumn(name = "DEPTNO")
	private Dept1 deptNo;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp1 [empNo=");
		builder.append(empNo);
		builder.append(", eName=");
		builder.append(eName);
		builder.append(", job=");
		builder.append(job);
		builder.append(", mgr=");
		builder.append(mgr);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append(", sal=");
		builder.append(sal);
		builder.append(", comm=");
		builder.append(comm);
		builder.append(", deptNo=");
		builder.append(deptNo.getDeptNo());
		builder.append("]");
		return builder.toString();
	}
	

}
/*
 * create table Member1 ( member_id number(19,0) not null, name varchar2(20),
 * team_id number(19,0), primary key (member_id) );
 */
