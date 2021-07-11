DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    employee_name VARCHAR(100) NOT NULL,
    employee_position VARCHAR(100) NOT NULL,
);

INSERT INTO employees (employee_name, employee_position) VALUES
    ('Alex', 'TRAINEE'),
    ('Nicole', 'TRAINEE'),
    ('Daniel', 'JUNIOR'),
    ('Alexander', 'MID'),
    ('Becky', 'MID'),
    ('Diana', 'SENIOR'),
    ('Jack', 'SENIOR'),
    ('John', 'PROJECT_MANAGER'),
    ('Andy', 'CEO');