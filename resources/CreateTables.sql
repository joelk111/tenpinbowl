CREATE TABLE Players (
PlayerID INT NOT NULL,
FirstName VARCHAR(50) NOT NULL,
LastName VARCHAR(50) NOT NULL,
TeamID INT NOT NULL,
NumGoals INT NOT NULL,
PRIMARY KEY (PlayerID)
);

CREATE TABLE Teams (
TeamID INT NOT NULL,
TeamName VARCHAR(50) NOT NULL,
PRIMARY KEY (TeamID)
);