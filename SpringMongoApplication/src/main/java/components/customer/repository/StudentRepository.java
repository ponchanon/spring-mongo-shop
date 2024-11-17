package components.customer.repository;

import components.customer.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
    List<Student> findAll();
    @Query("{'name' : ?0}")
    List<Student> findAllByName(String name);
    Student findByPhone(String phone);

    @Query("{'address.city' : ?0}")
    List<Student> findAllByCity(String city);


}

