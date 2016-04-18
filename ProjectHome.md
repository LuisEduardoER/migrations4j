The goal of this project is to create a standalone, command line based application that mirrors as close as possible the power of ActiveRecord Migrations. Commands should allow for creation of universal XML based migration files that mirror the syntax of current ActiveRecord Migrations files. With these xml files, the program will be able to create SQL, Mapping files, and/or Model classes.

Design will be modular such that additional database support and persistence framework support can be easily added in a plug-in like manor. Initial database/persistence framework support will be PostgreSQL/Hibernate3 with the plan to add support for mySQL, SQL Server and Torque in the near future.