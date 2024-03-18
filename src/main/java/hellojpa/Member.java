package hellojpa;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Member {

	@Id
	private Long id;
	@Column(name = "name", nullable = false, length = 10)
	private String username;
	private Integer age;
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	@Lob
	private String description;

	public Member() {

	}
}

