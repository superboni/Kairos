INSERT INTO `tblUserAccount`
(`firstName`,
`middleName`,
`lastName`,
`username`,
`password`,
`dateCreated`)
VALUES
("Jenmart", "Pelaez", "Bonifacio", "superboni", "test", SYSDATE()),
("Mary Mae", "Francisco", "Villanueva", "maepoinkz", "test", SYSDATE()),
("John Benedic", "The Dic", "Enriquez", "johnben", "test", SYSDATE());


INSERT INTO tblUserRoles (user, role)
select ua.id user, r.id role from tblUserAccount ua, tblRoles r;

INSERT INTO tblRoles 
(role)
VALUES
("ROLE_ADMIN"),
("ROLE_COLLECTOR");

COMMIT;