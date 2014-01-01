drop database ebillQuezelco;
create database ebillQuezelco;

DROP TABLE tblUserAccount;
CREATE TABLE tblUserAccount (
  id int(12) NOT NULL AUTO_INCREMENT,
  firstName varchar(100) NOT NULL,
  middleName varchar(100),
  lastName varchar(100) NOT NULL,
  username varchar(100) NOT NULL,
  password varchar(40) NOT NULL,
  dateCreated date NOT NULL,
  enabled BIT NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  UNIQUE KEY UNI_USERACCOUNT (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE tblRoles;
CREATE TABLE tblRoles (
  id int(12) NOT NULL AUTO_INCREMENT,
  role varchar(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UNI_ROLES (role)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE tblUserRoles;
CREATE TABLE tblUserRoles (
  id int(12) NOT NULL AUTO_INCREMENT,
  user int(12) NOT NULL,
  role int(12) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;