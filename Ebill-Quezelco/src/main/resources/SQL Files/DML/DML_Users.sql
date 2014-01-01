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


INSERT INTO tblUserRoles
(user,role)
VALUES
(1, 1),
(2, 1),
(3, 2);

INSERT INTO tblRoles 
(role)
VALUES
("ROLE_ADMIN"),
("ROLE_COLLECTOR");

COMMIT;