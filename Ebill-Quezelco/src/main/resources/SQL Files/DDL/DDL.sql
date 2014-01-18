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
  id bigint(20) NOT NULL AUTO_INCREMENT,
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
  id bigint(20) NOT NULL AUTO_INCREMENT,
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

COMMIT;