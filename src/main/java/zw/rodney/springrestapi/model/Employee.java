package zw.rodney.springrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonProperty("full_name")
    @NotNull(message = "Name should not be null")
    private String name;
//    @JsonIgnore
    private Long age = 0L;
    private String location;
    @Email(message = "Enter a valid email addressb")
    private String email;
    @NotNull(message = "Department should not be null")
    private String department;
    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updateAt;

}
