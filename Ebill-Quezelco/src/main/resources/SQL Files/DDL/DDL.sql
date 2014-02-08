drop database ebillQuezelco;
create database ebillQuezelco;

DROP TABLE tblUserAccount;
CREATE TABLE tblUserAccount (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  firstName varchar(70) NOT NULL,
  middleName varchar(70),
  lastName varchar(70) NOT NULL,
  username varchar(20) NOT NULL,
  password varchar(200) NOT NULL,
  dateCreated date NOT NULL,
  enabled BIT DEFAULT 1 NOT NULL,
  role_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UNI_USERACCOUNT (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE tblRoles;
CREATE TABLE tblRoles (
  id int(10) NOT NULL AUTO_INCREMENT,
  role varchar(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UNI_ROLES (role)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE tblAnnouncement;
CREATE TABLE tblAnnouncement (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  text varchar(2000) NOT NULL,
  startDate Date NOT NULL,
  endDate Date NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE tblDesignation;
CREATE TABLE tblDesignation (
  id int(10) NOT NULL AUTO_INCREMENT,
  designation varchar(40) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UNI_ROLES (designation)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE tblUserDesignation;
CREATE TABLE tblUserDesignation (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user bigint(20) NOT NULL,
  designation bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE tblBillConfiguration;
CREATE TABLE tblBillConfiguration (
  configName char(12) NOT NULL,
  description varchar(200) NOT NULL,
  PRIMARY KEY (configName)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE tblBillConfigurationValue;
CREATE TABLE tblBillConfigurationValue (
  configName char(12) NOT NULL,
  sequence bigint NOT NULL,
  configOptionName char(6) NOT NULL,
  description varchar(200),
  configValue varchar(20),
  PRIMARY KEY (configName, sequence, configOptionName)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE tblBill;
CREATE TABLE tblBill (
billId char(12) NOT NULL,
accountNumber char(12) NOT NULL,
oebrNumber char(6) NOT NULL,
monthBilled int NOT NULL,
startDate date NOT NULL,
endDate date NOT NULL,
currentReading decimal NOT NULL,
previousReading decimal NOT NULL,
billStatus varchar(20) NOT NULL,
billPrintDate date NOT NULL,
latePaymentChargeSw boolean NOT NULL,
latePaymentChargeDate date,
currentBillAmount decimal,
PRIMARY KEY (billId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE tblAdjustment;
CREATE TABLE tblAdjustment (
adjustmentId char(12) NOT NULL,
billId char(12) NOT NULL,
accountNumber char(12) NOT NULL,
adjustmentType char(6) NOT NULL,
adjustmentStatus char(6) NOT NULL,
adjustmentDate date NOT NULL,
adjustmentAmount decimal NOT NULL,
comments varchar(200),
PRIMARY KEY (adjustmentId)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;