
INSERT INTO tblRoles 
(role)
VALUES
("AREA MANAGER"),
("CAD"),
("CASHIER"),
("COLLECTOR"),
("IT PERSONNEL"),
("SYSTEM ADMIN");


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


