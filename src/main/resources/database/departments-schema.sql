DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
    department_name VARCHAR(100) NOT NULL,
    department_director VARCHAR(100) NOT NULL,
);

INSERT INTO departments (department_name, department_director) VALUES
    ('HR', 'Jake'),
    ('CMBU', 'Jason'),
    ('CPBU', 'Jane');