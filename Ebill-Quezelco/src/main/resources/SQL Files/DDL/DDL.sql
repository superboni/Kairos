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
  dateCreated timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
  enabled BIT DEFAULT 1 NOT NULL,
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

DROP TABLE tblUserRoles;
CREATE TABLE tblUserRoles (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user int(12) NOT NULL,
  role int(12) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;