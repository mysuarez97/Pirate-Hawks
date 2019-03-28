# Pirate-Hawks
# Group Members: Sam, Myrlene, Agnes, Christopher
Notes:

All files should be initially encoded as UTF-8. This isn't the default for some IDEs, so you should change that in the preferences. Line endings of text files are Windows format (CR-LF). That should be the default in any Windows IDE.

We will use Maven Project Template.

We will use Canvas email to communicate.

Package and class names must be agreed upon.

Everyone must create their own branch from the master branch. The head of each member's branch will be merged into the master branch for grading. The project's final version should receive a Git tag '“SearchEngine Project - Data”.
We will be using SQLiteManager. Download sqlite-jdbc 3.15.1.jar (to enable a java application to interact with a database) and rs2xml (a jar library that can be used to make the result set of a query useful as input for the table model)
Database Name: FilenameDB.sqlite
Create Table [SearchEngine](RecordNum integer NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,PathName text,DateAdded date,Status text)
