        CREATE TABLE patient
            (
            id INT PRIMARY KEY NOT NULL,
            family VARCHAR(50),
            given varchar(50),
            date_of_birth timestamp,
            gender varchar (10),
            address varchar (100),
            phone_number varchar (20)
            );

        create SEQUENCE seq_ids increment by 1;
