
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


INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('BILL_STAT', '1', 'ACTIVE', 'Active', '10');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('BILL_STAT', '2', 'FORDIS', 'For Disconnection', '20');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('BILL_STAT', '3', 'DISC', 'Disconnected', '30');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('BILL_STAT', '4', 'RECON', 'Reconnected', '40');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('WHEEL_RATE', '1', 'GSC', 'Generated System Charge', '4.2363');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('WHEEL_RATE', '2', 'BHC', 'Benefits to Host Communication', '0.0245');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('ADJ_TYPE', '1', 'LPC', 'Late Payment Charge', 'LPC');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('ADJ_TYPE', '2', 'DISCFEE', 'Disconnection Fee', 'DISCFEE');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('ADJ_TYPE', '3', 'RECFEE', 'Reconnection Fee', 'RECFEE');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('ADJ_TYPE', '4', 'DISC', 'Discount', 'DISC');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('ADJ_STAT', '1', 'ACT', 'Active', 'ACT');
INSERT INTO tblbillconfigurationvalue (configName, sequence, configOptionName, description, configValue) VALUES ('ADJ_STAT', '2', 'INACT', 'Inactive', 'INACT');


INSERT INTO tblbillconfiguration (configName, description) VALUES ('BILL_STAT', 'Bill Status');
INSERT INTO tblbillconfiguration (configName, description) VALUES ('WHEEL_RATE', 'Wheel Rate');
INSERT INTO tblbillconfiguration (configName, description) VALUES ('ADJ_TYPE', 'Adjustment Type');
INSERT INTO tblbillconfiguration (configName, description) VALUES ('ADJ_STAT', 'Adjustment Status');

COMMIT;


