CREATE TABLE TextProperty (
  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
  Value      varchar(255), 
  PropertyID integer(10) NOT NULL, 
  FOREIGN KEY(PropertyID) REFERENCES Property(ID));
CREATE TABLE DateProperty (
  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
  Value      date, 
  PropertyID integer(10) NOT NULL, 
  FOREIGN KEY(PropertyID) REFERENCES Property(ID));
CREATE TABLE FloatProperty (
  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
  Value      numeric(19, 0), 
  PropertyID integer(10) NOT NULL, 
  FOREIGN KEY(PropertyID) REFERENCES Property(ID));
CREATE TABLE IntProperty (
  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
  Value      integer(20), 
  PropertyID integer(10) NOT NULL, 
  FOREIGN KEY(PropertyID) REFERENCES Property(ID));
CREATE TABLE BooleanProperty (
  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
  Value      numeric(19, 0), 
  PropertyID integer(10) NOT NULL, 
  FOREIGN KEY(PropertyID) REFERENCES Property(ID));
CREATE TABLE "Tag" (
  ID    integer(10) NOT NULL, 
  Label varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (ID));
CREATE TABLE Source (
  ID   integer(10) NOT NULL, 
  Name varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (ID));
CREATE TABLE Property (
  ID              integer(10) NOT NULL, 
  Pagination      varchar(255), 
  PropertyLabelID integer(10) NOT NULL, 
  PRIMARY KEY (ID), 
  FOREIGN KEY(PropertyLabelID) REFERENCES PropertyLabel(ID));
CREATE TABLE Person (
  ID integer(10) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE PropertyLabel (
  ID    integer(10) NOT NULL, 
  Label varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (ID));
CREATE TABLE Person_Property (
  PersonID   integer(10) NOT NULL, 
  PropertyID integer(10) NOT NULL, 
  PRIMARY KEY (PersonID, 
  PropertyID), 
  FOREIGN KEY(PersonID) REFERENCES Person(ID), 
  FOREIGN KEY(PropertyID) REFERENCES Property(ID));
CREATE TABLE Property_Source (
  PropertyID integer(10) NOT NULL, 
  SourceID   integer(10) NOT NULL, 
  PRIMARY KEY (PropertyID, 
  SourceID), 
  FOREIGN KEY(PropertyID) REFERENCES Property(ID), 
  FOREIGN KEY(SourceID) REFERENCES Source(ID));
CREATE TABLE Property_Tag (
  PropertyID integer(10) NOT NULL, 
  TagID      integer(10) NOT NULL, 
  PRIMARY KEY (PropertyID, 
  TagID), 
  FOREIGN KEY(PropertyID) REFERENCES Property(ID), 
  FOREIGN KEY(TagID) REFERENCES "Tag"(ID));
CREATE TABLE PropertyLabel_Source (
  PropertyLabelID integer(10) NOT NULL, 
  SourceID        integer(10) NOT NULL, 
  PRIMARY KEY (PropertyLabelID, 
  SourceID), 
  FOREIGN KEY(PropertyLabelID) REFERENCES PropertyLabel(ID), 
  FOREIGN KEY(SourceID) REFERENCES Source(ID));
CREATE UNIQUE INDEX Tag_ID 
  ON "Tag" (ID);
CREATE UNIQUE INDEX Source_ID 
  ON Source (ID);
CREATE UNIQUE INDEX Property_ID 
  ON Property (ID);
CREATE UNIQUE INDEX Person_ID 
  ON Person (ID);
CREATE UNIQUE INDEX PropertyLabel_ID 
  ON PropertyLabel (ID);
