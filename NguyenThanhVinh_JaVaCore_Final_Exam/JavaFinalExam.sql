DROP SCHEMA IF EXISTS java_exam;
CREATE SCHEMA IF NOT EXISTS java_exam;

USE java_exam;

DROP TABLE IF EXISTS candidate;
CREATE TABLE candidate(
	candidate_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `role` ENUM ('Experience', 'Fresher')
);
-- Insert data to candidate
insert into candidate (candidate_id, first_name, last_name, email, `password`, `role`, phone) 
	values 	(1, 'Alistair', 'Leefe', 		'aleefe0@vti.com.vn', 		'5d09qpyJOjEu', 'Experience', 	'219 521 9255'), 
			(2, 'Dominica', 'Hargreave', 	'dhargreave1@vti.com.vn', 	'iJDgmYXq1L', 	'Fresher', 		'641 921 2832'), 
			(3, 'Rik', 'Atheis', 			'ratheis2@vti.com.vn', 		'J3cqw8ZGi', 	'Fresher', 		'225 374 3527'), 
			(4, 'Claudina', 'Megany', 		'cmegany3@vti.com.vn', 		'Ptqm5wPmB', 	'Experience', 	'369 825 9410'), 
			(5, 'Washington', 'Loyndon', 	'wloyndon4@vti.com.vn', 	'igokIu', 		'Fresher', 		'354 684 6745'), 
			(6, 'Giraud', 'Leaton', 		'gleaton5@vti.com.vn', 		'Q8kfBm', 		'Experience', 	'276 130 0772'), 
			(7, 'Bibi', 'Andrivel', 		'bandrivel6@vti.com.vn', 	'qwkTOMNRlg3', 	'Fresher', 		'354 684 4945'), 
			(8, 'Bartram', 'Dovermann', 	'bdovermann7@vti.com.vn', 	'Q3f8TtyX', 	'Fresher', 		'132 329 7697'), 
			(9, 'Ethelbert', 'Gilliat', 	'egilliat8@vti.com.vn', 	'VpwZpLcqKg', 	'Fresher', 		'535 894 6431'), 
			(10, 'Adrien', 'Tootal', 		'atootal9@vti.com.vn', 		'DDldk8jM', 	'Experience', 	'993 154 8651');


DROP TABLE IF EXISTS experience;
CREATE TABLE experience(
    experience_email VARCHAR(50) UNIQUE NOT NULL,
    exp_in_year TINYINT,
    pro_skill VARCHAR(50),
    FOREIGN KEY (experience_email) REFERENCES candidate(email)
    ON DELETE CASCADE 
    ON UPDATE CASCADE
);
-- Insert data to experience
insert into experience ( experience_email, exp_in_year, pro_skill) 
	values 	('aleefe0@vti.com.vn', 4, 'Java'), 
			('cmegany3@vti.com.vn', 2, 'PHP'), 
            ('gleaton5@vti.com.vn', 2, 'MySQL'), 
            ('atootal9@vti.com.vn', 2, 'C++');


DROP TABLE IF EXISTS fresher;
CREATE TABLE fresher(
    fresher_email VARCHAR(50) UNIQUE NOT NULL,
    graduation_rank ENUM ('Excellence', 'Good', 'Fair', 'Poor'),
    FOREIGN KEY (fresher_email) REFERENCES candidate(email)
    ON DELETE CASCADE 
    ON UPDATE CASCADE
);
-- Insert data to fresher
insert into fresher ( fresher_email, graduation_rank) 
	values 	('dhargreave1@vti.com.vn', 'Excellence'), 
			('ratheis2@vti.com.vn', 'Poor'), 
            ('wloyndon4@vti.com.vn', 'Excellence'), 
            ('bandrivel6@vti.com.vn', 'Excellence'), 
            ('bdovermann7@vti.com.vn', 'Good'), 
            ('egilliat8@vti.com.vn', 'Fair');