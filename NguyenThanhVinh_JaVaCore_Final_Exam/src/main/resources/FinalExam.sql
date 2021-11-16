DROP SCHEMA IF EXISTS final_exam;
CREATE SCHEMA IF NOT EXISTS final_exam;

USE final_exam;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	user_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `role` ENUM ('Manager', 'Employee')
);
-- Insert data to users
insert into users (user_id, fullname, email, password, role) 
	values 	(1, 'Alistair Leefe', 		'aleefe0@vti.com.vn', 		'5d09qpyJOjEu', 'Manager'), 
			(2, 'Dominica Hargreave', 	'dhargreave1@vti.com.vn', 	'iJDgmYXq1L', 	'Employee'), 
			(3, 'Rik Atheis', 			'ratheis2@vti.com.vn', 		'J3cqw8ZGi', 	'Employee'), 
			(4, 'Claudina Megany', 		'cmegany3@vti.com.vn', 		'Ptqm5wPmB', 	'Manager'), 
			(5, 'Washington Loyndon', 	'wloyndon4@vti.com.vn', 	'igokIu', 		'Employee'), 
			(6, 'Giraud Leaton', 		'gleaton5@vti.com.vn', 		'Q8kfBm', 		'Manager'), 
			(7, 'Bibi Andrivel', 		'bandrivel6@vti.com.vn', 	'qwkTOMNRlg3', 	'Employee'), 
			(8, 'Bartram Dovermann', 	'bdovermann7@vti.com.vn', 	'Q3f8TtyX', 	'Employee'), 
			(9, 'Ethelbert Gilliat', 	'egilliat8@vti.com.vn', 	'VpwZpLcqKg', 	'Employee'), 
			(10, 'Adrien Tootal', 		'atootal9@vti.com.vn', 		'DDldk8jM', 	'Manager');


DROP TABLE IF EXISTS manager;
CREATE TABLE manager(
    manager_id TINYINT UNSIGNED UNIQUE NOT NULL,
    exp_in_year TINYINT,
    FOREIGN KEY (manager_id) REFERENCES users(user_id)
);
-- Insert data to manager
insert into manager ( manager_id, exp_in_year) 
	values 	(1, 4), 
			(4, 2), 
            (6, 2), 
            (10, 2);


DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
    employee_id TINYINT UNSIGNED UNIQUE NOT NULL,
    pro_skill VARCHAR(50),
    FOREIGN KEY (employee_id) REFERENCES users(user_id)
);
-- Insert data to employee
insert into employee ( employee_id, pro_skill) 
	values 	(2, 'Java'), 
			(3, 'HTML'), 
            (5, 'MySQL'), 
            (7, 'CSS'), 
            (8, 'React'), 
            (9, 'Python');


DROP TABLE IF EXISTS project;
CREATE TABLE project(
	project_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    team_size TINYINT UNSIGNED,
    manager_id TINYINT UNSIGNED,
    FOREIGN KEY (manager_id) REFERENCES manager(manager_id)
);
-- Insert data to project
insert into project ( project_id, team_size, manager_id) 
	values 	(1, 4, 10), 
			(2, 5, 6), 
            (3, 2, 4), 
            (4, 3, 1);
            
            
DROP TABLE IF EXISTS project_employees;
CREATE TABLE project_employees(
	project_id TINYINT UNSIGNED,
    employee_id TINYINT UNSIGNED,
    UNIQUE KEY(project_id, employee_id),
    FOREIGN KEY (project_id) REFERENCES project(project_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);
-- Insert data to project_employees
insert into project_employees ( project_id, employee_id) 
	values 	(1, 2), 
			(2, 3), 
            (1, 5), 
            (3, 8),
            (4, 9),
            (1, 7),
            (2, 7);
            
