INSERT INTO tblUserAccount
(firstName,
middleName,
lastName,
username,
password,
dateCreated,
role_id)
VALUES
("Jenmart", "Pelaez", "Bonifacio", "superboni", "test", SYSDATE(), 1),
("Mary Mae", "Francisco", "Villanueva", "maepoinkz", "test", SYSDATE(), 1),
("John Benedic", "The Dic", "Enriquez", "johnben", "test", SYSDATE(), 1);

INSERT INTO tblUserDesignation
(user, designation)
VALUES
(1, 2),
(1, 7),
(1, 4),
(2, 1),
(2, 3),
(3, 5),
(3, 6);

INSERT INTO tblUserRoles
(user, role)
VALUES
(1, 1),
(2, 7),
(3, 6);


INSERT INTO tblRoles 
(role)
VALUES
("ADMIN"),
("AREA MANAGER"),
("CAD"),
("CASHIER"),
("COLLECTOR"),
("CONSUMER"),
("IT PERSONNEL");


INSERT INTO tblDesignation 
(designation)
VALUES
("Burdeos"),
("Lucena"),
("Catanauan"),
("Polillo"),
("Lucban"),
("Mauban"),
("Tiaong");

INSERT INTO tblAnnouncement
(text, startDate, endDate)
values
("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh 
euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad 
minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut 
aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit 
in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla 
facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent
 luptatum zzril delenit augue duis dolore te feugait nulla facilisi.", SYSDATE(), DATE_ADD(SYSDATE(), INTERVAL 5 DAY));


COMMIT;


