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
latePaymentChargeDate date,
currentBillAmount decimal,
jobId char(12),
PRIMARY KEY (billId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
commit;

DROP TABLE tblAdjustment;
CREATE TABLE tblAdjustment (
adjustmentId char(12) NOT NULL,
billId char(12) NOT NULL,
accountNumber char(12) NOT NULL,
adjustmentType char(6) NOT NULL,
adjustmentStatus boolean NOT NULL,
adjustmentDate date NOT NULL,
adjustmentAmount decimal NOT NULL,
comments varchar(200),
PRIMARY KEY (adjustmentId)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
commit;

DROP TABLE tblJob;
CREATE TABLE tblJob (
jobId bigint(20) AUTO_INCREMENT NOT NULL,
jobType varchar(20) NOT NULL,
executedDate TIMESTAMP DEFAULT current_timestamp NOT NULL,
jobStatus varchar(20) NOT NULL,
startRunDateTime datetime NOT NULL,
endRunDateTime datetime,
PRIMARY KEY (jobId)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
commit;

DROP TABLE tblFinancialTransaction;
CREATE TABLE tblFinancialTransaction (
ftId char(12) NOT NULL,
accountNumber varchar(20) NOT NULL,
ftType varchar(20) NOT NULL,
billId char(12) NOT NULL,
payId char(12) NOT NULL,
dateCreated timestamp default current_timestamp NOT NULL,
accountDate date,
PRIMARY KEY (ftId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
commit;

DROP TABLE tblPayment;
CREATE TABLE tblPayment (
paymentId char(12) NOT NULL,
accountNumber char(12) NOT NULL,
paymentDate timestamp default current_timestamp NOT NULL,
paymentType varchar(20) NOT NULL,
amount decimal NOT NULL,
PRIMARY KEY (paymentId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
commit;


COMMIT;