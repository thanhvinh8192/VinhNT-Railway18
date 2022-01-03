package com.ntv.repositorys;

import com.ntv.entities.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

    @Modifying
    @Query("SELECT d FROM Department d WHERE d.departmentName = :nameParameter")
    List<Department> findDepartmentByName(@Param("nameParameter") Department.DepartmentNameEnum departmentName);


}
