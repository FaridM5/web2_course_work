<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

# CRUD - JPA App <img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/8d5187dc-1957-4bec-9ea1-5072ff2ec159" width="45">

<i class="fa fa-bookmark" style="font-size:13px"></i> This repository contains programs written in:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) 

**Video Link: <a href="https://youtu.be/omkHQogKun4" target="_blank">YouTube</a>**
<h3><i class="fa fa-bookmark" style="font-size:13px"></i> References:</h3>
<li>Your GitHub Repository</li>
<li>Lecure Slides</li>
<li>Spring Courses</li>

<h4><i class="fa fa-bookmark" style="font-size:13px"></i> What applications required from the system:</h3>
<ul>
<li>Latest version Java (21)</i></li>
</ul>

<h4><i class="fa fa-bookmark" style="font-size:13px"></i> You don't need to:</h4>
<ul>
<li>Download Gradle<br></li>
<li>Download an IDEA</li>
<li>Download ay package/JAR file or any other things to insert into IDEA</li>

<li>Go through several steps to run the app</li>
<li>Insert any database credentials to run the app <i>(because of in memory database usage)</i></li>

</ul>

<i style=font-size:13px;>Everything <u>(dependencies and other configurations)</u> will be handled automatically by:</i>

![Static Badge](https://img.shields.io/badge/build-Java-orange?style=flat&logo=Gradle&label=gradle)

<h3><i class="fa fa-bookmark" style="font-size:13px"></i> Get Familiar with the app:</h3>

**Neme:** <img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/68f40749-7326-4cf6-ab32-35e2a60e8000" width=50px;> <i>Adazon Store</i>

<i class="fa fa-book" style="font-size:13px"></i>
**About:**
- **Description:** The application demonstrates a WebStore. There we can create products and users, assign one to other using the relation among them, filter, sort, and paginate records accordingly. To run the app, this command is enough(default port, 8080 is not changed):
```bash
  .\gradlew bootRun
```

<br>

<i class="fa fa-book" style="font-size:13px"></i>
**General look for <i>"/"</i> mapping:**
- <img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/3ac71c55-e37d-4aac-a835-a73afe778f3b">

<i class="fa fa-book" style="font-size:13px"></i>
**Database Connection**:
- I am using H2 in memory database for the connection. Because of this, the data that is saved through the application will not persist after the termination of the app. I am having these configuration settings for the database <i>creation</i> and <i>connection</i>:
```bash
  spring.h2.console.enabled=true
  spring.h2.console.path=/h2
  spring.datasource.url=jdbc:h2:mem:inmemdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  spring.jpa.hibernate.ddl-auto=none
  spring.sql.init.mode=always
  spring.jpa.defer-datasource-initialization=true
```
- As you can see from there, `spring.jpa.hibernate.dll-auto` is set to `none` which defines if Hibernate will handle database creation or not. It is usually kept as none to avoid data loss or integrity.
- `spring.sql.init.mode` is set to `always` which shows whether we will initialize the records. By saying <i>always</i> we every time pass execute `schema.sql` and `data.sql` files. 
- `spring.jpa.defer-datasource-initialization` is set to true to avoid any confusion while building the program. It arranges the order of the exection among files. For example, schema file will be executed before the data file to avoid error (<i>records should be added somewhere that exists</i>).


<i class="fa fa-book" style="font-size:13px"></i>
**Entities**:
- Product
- User

<br>

<i class="fa fa-book" style="font-size:13px"></i>
**Product entity**:
- id
- name
- price
- description
<br>
These are the properties that the entity have. Schema for that is similar to:

```bash
CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description TEXT
);
```
- Product table records (initial `data.sql`) are seen like this:
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/1be506ed-3ad0-48e8-aff4-4a55fa9f41f7">

<br>
<i class="fa fa-book" style="font-size:13px"></i>
**User entity**:
- id
- username
- name
- surname
- email
- phone
- dateOfBirth
<br>
These are the properties that the entity have. Schema for that is similar to:

```bash
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),
    date_of_birth DATE
);
```
- Product table records (initial `data.sql`) are seen like this:
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/3c816ce8-51c2-4750-b927-e9d1edb475f3">

<br>
<i class="fa fa-book" style="font-size:13px"></i>

**Adding Product**: 
- We can add a product to our application navigating to the button `Add Product`. Which actually sends the request inside `ProductController` to map `/product/add`. 
- Add Product interface:
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/63912c27-7963-4752-b89d-5ae586a18f3f">
- As it is seen there we have `name`, `price` and `description` propertiesthat we can store. <i>Image is not required</i>
<br>

<br>
<i class="fa fa-book" style="font-size:13px"></i>

**Adding User**: 
- We can add a user to our application navigating to the button `Add User`. Which actually sends the request inside `UserController` to map `/user/add`. 
- Add Product interface:
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/7954db26-7d95-4e41-9d6b-a20e5e1ed2fe">
- As it is seen there we have several properties that we can store there. When clicked to submit, parameters are sent to `/user/save` which UserRepository handles it

<br>
<i class="fa fa-book" style="font-size:13px"></i>

**Listing/Deleting User**: 
- We can list the users through `USERS` navigation where we are sending mapping to `user/list`. Then By pressing red icon, we can delete the record from the table. 
- Users interface:
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/85ef120e-fce8-499e-8a20-31e2a03ab682">


<br>
<i class="fa fa-book" style="font-size:13px"></i>

**Updating User**: 
- We can  update the user record by clicking the edit button near to the User Record.
- Update User interface:
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/ce22408b-246f-4e0f-8ec1-5dbec780ec4d">
- We are provided with the predefined values not to miss any data about the record. When changed something, request sent to `.save()` method inside the JPA repo that updates the record <i>if the record has already been created</i>. Normally it is used for saving record.

<br>

**Sorting/Pagination**: 
- As it is seen, we have sorted the records on descending order by Username so, `A` letter is at the end, 6th page. We can see it using pagination.
- Sorting/Pagination
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/84278c0d-a55c-4894-8830-60e8f2cbf96a">


<br>
<i class="fa fa-book" style="font-size:13px"></i>

**Purchases (BIDIRECTIONAL)**: 
- That page is actually where we use Query (both native and non native queries) to benefit from the `ManytoMany` relationship among the Product and User. In that scenario we see that one product is assigned to many Users. In reverse, One User may assign himself multiple products!

**Note**: to assign the product to user(purchasing), we add the user id to the specific product card footer. In the home page, we have several predefined products which have their input fields on their footer. When you type a user id to there, the program joins the id of that product to the specified user id. So, we are displaying it on the `purchases` view with the help of non native query that interacts with the entities rather than database. (We also have a NATIVE query. Refer to the video and UserRepository)
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/9fd9af0d-a4bd-4ffe-8c4c-dc0026eea6b1">


<br>
<i class="fa fa-book" style="font-size:13px"></i>

**Filter**: 
- As seen from the scenario below, the filter page retrieves the records that match the filter <i>Name=Aylin and Surname=Safarova</i>. As we have two different records with the same name and surname, the app returned these two. User can add as many filter as he wants so the query will be created based on the user input. We rely on findByCriteria method in UserService. That benefits the functionality extended from `JpaSpecificationExecutor`.
<img src="https://github.com/SITE-ADA/as1-spring-boot-jpa-app-FaridM5/assets/67589966/52cffad7-189c-4b73-ba74-8892b15e57d8">
