# ca.clinitouch.rest
## Java rest for Clinical
This is a Java Clinical RESTful Service.
For any questions please contact us.
## Prerequisites:
- Tomcat 8
- Eclipse
- Define in the Server config in Eclipse a jndi resource for the database connection:
```
<Resource
    name="jdbc/clinicaldb"
    auth="Container"
    type="javax.sql.DataSource"
    maxActive="100"
    maxIdle="30"
    maxWait="10000"
    driverClassName="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/clinicaldb"
    username="root"
    password="your-password-here"
    />
```
