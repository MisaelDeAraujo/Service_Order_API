ALTER TABLE order_tb
ADD CONSTRAINT order_tb_person_tb_person_id
FOREIGN KEY (person_id)
REFERENCES person_tb(id)