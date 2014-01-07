INSERT INTO tblUserRoles (user, role)
select ua.id user, r.id role from tblUserAccount ua, tblRoles r;

INSERT INTO tblRoles 
(role)
VALUES
("ROLE_ADMIN"),
("ROLE_COLLECTOR");

COMMIT;