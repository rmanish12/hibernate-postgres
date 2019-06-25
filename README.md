## Hibernate
It is a java framework that simplifies the development of Java application to interact with the database.
It is an open-source, ligh-weight, ORM tool.
It implements the specifications of JPA for data persistence.

ORM tool is a tool that maps object to data stored in database.

### Advantages of Hibernate
1. Open source and light-weight
2. Fast performance (using of cache)
3. Database Independent Query (HQL)
4. Automatic table creation

## Elements of Hibernate Architecture
1. SessionFactory
	It is a factory of session and client of of ConnectionProvider.
	It holds second-level cache (optional)
	```org.hibernate.SessionFactory``` interface provides factory method to get object of Session.
	
2. Session
	It provides an interface between the application and data stored in database.
	It is short-lived and wraps JDBC connection.
	It is factory of `Transaction`, `Query` and `Criteria`.
	It holds first-level cache of data (mandatory)
	```org.hibernate.Session``` provides method to insert, update and delete the object.
	
3. Transaction
	It specifies the atomic unit of work.
	It is optional.
	```org.hibernate.Transaction``` interface provides methods for Transation management.
	
4. ConnectionProvider
	It is a factory of JDBC connection.
	It abstract the application from DriverManager or DataSource.
	It is optional.
	
5. TransactionFactory
	It is factory of Transaction.
	It is optional.			