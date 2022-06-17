USE task;
DELIMITER $$
CREATE TRIGGER persons_create
AFTER INSERT
ON owner FOR EACH ROW
BEGIN
    insert into owner_audit_log(owner_id, column_name, new_value, done_by) values(NEW.owner_id,'FirstName',NEW.owner_first_name,NEW.created_by);
	insert into owner_audit_log(owner_id, column_name, new_value, done_by) values(NEW.owner_id,'LastName',NEW.owner_last_name,NEW.created_by);
	insert into owner_audit_log(owner_id, column_name, new_value, done_by) values(NEW.owner_id,'Age',NEW.owner_img,NEW.created_by);
	
END$$
DELIMITER ;