package ee.bcs.valiit.restcontrollers;

import ee.bcs.valiit.tasks.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    List<Employee> employeesList = new ArrayList<>();

    @GetMapping("employee/{a}/{b}")
    public Employee getEmployee(@PathVariable("a") String aVar, @PathVariable("b") String bVar) {
        Employee employee = new Employee();
        employee.setName(aVar);
        employee.setTitle(bVar);

        return employee;
    }

    @PostMapping("test")
    public void test2(@RequestBody Employee employee) {
        String sql = "INSERT INTO employee (name , title) VALUES (:nameParameter, :titleParameter)";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("nameParameter", employee.getName());
        paramMap.put("titleParameter", employee.getTitle());
        jdbcTemplate.update(sql, paramMap);

    }


    //http://localhost:8080/addEmployee?id=4 -> tagastab stringi Albert
    @GetMapping("addEmployee")
    public String addEmployee(int id) {
        String sql = "SELECT name FROM employee WHERE id = :idParam";
        Map<String, Object> paramMap = new Hashtable<>();
        paramMap.put("idParam", id);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);

    }

    //http://localhost:8080/getEmployees -> tagastab kõik read
    @GetMapping("getEmployees")
    public List<Employee> getEmployees() {
        String sql = "SELECT * FROM employee";
        List<Employee> result = jdbcTemplate.query(sql, new HashMap<>(), new EmployeeRowMapper());
        return result;
    }

    private class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setName(resultSet.getString("name"));
            employee.setTitle(resultSet.getString("title"));
            return employee;
        }
    }

    @GetMapping("employees/{a}")
    public Employee getById(@PathVariable("a") int index) {
        return employeesList.get(index);
    }

    @PutMapping("addById/{a}")
    public void addById(@PathVariable("a") int index, @RequestBody Employee employee) {
        employeesList.set(index, employee);
    }

    @DeleteMapping("delById/{a}")
    public void delById(@PathVariable("a") int index) {
        employeesList.remove(index);
    }


}
