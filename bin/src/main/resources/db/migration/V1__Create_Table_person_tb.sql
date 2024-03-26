create table if not exists person_tb(
    id SERIAL PRIMARY KEY,
    complete_name VARCHAR(50) NOT NULL UNIQUE,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    cpnj VARCHAR(14) NOT NULL UNIQUE,
    cellphone VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    person_created_date TIMESTAMP
)