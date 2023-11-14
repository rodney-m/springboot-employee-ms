package zw.rodney.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import zw.rodney.springrestapi.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByNameAndLocation(String name, String location);

    //SELECT * FROM table WHERE name LIKE "%ram%"
    List <Employee> findByNameContaining(String keyword);
//    List <Employee> findByNameLike(String "%"+ keyword+ "%");

    @Query("From Employee WHERE name = :name OR location = :location")
    List <Employee> getEmployeesByNameAndLocation(String name, String location);
}
