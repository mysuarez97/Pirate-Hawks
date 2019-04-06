# Pirate-Hawks
# Group Members: Sam, Myrlene, Chris and Agnes

Notes:

All files should be initially encoded as UTF-8. This isn't the default for some IDEs, so you should change that in the preferences. Line endings of text files are Windows format (CR-LF). That should be the default in any Windows IDE.

We will use Maven Project Template.

We will use Canvas email to communicate.

Package and class names must be agreed upon.

Everyone must create their own branch from the master branch.  The head of each member's branch will be merged into the master branch for grading.  The project's final version should receive a Git tag.

Use createSQLTable.java to create a new database.  It will have one erroneous entry that lets it compile without having null fields.  You're going to want to delete that after files are added.

Access everything through userInterface.java.  A window will open that lets you open the maintence JFrame to add files.  The remove button and search button need some work.  

Search will implement the functions from the userInterface on Agnes Database branch.

The SearchEngine class has methods that are used by the userInterface to avoid code bloat.  

Below are the fields for the database.

                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " FILE_NAME           STRING    NOT NULL, " + 
                        " FILE_PATH           STRING    NOT NULL, " + 
                        " DATE_MODIFIED       STRING    NOT NULL, " + 
                        " STATUS              STRING    NOT NULL)"; 
