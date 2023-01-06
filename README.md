# Project Title

## **Dart Express Logistics**

## Description

Team 2 has developed a web application for the given use case, this web application is used to track the delivery shipment using gps. 
The delivery truck has onboard temperature sensor through which the temperature of the organic goods can be monitored by the admin, The admin can use the alert button to send a mail and sms to inform the truck driver in case of emergencies. This web application also has supplier login along with admin and driver. the supplier can log in and check the order and truck details associated with them.

##Issue tracker: https://docs.google.com/spreadsheets/d/1E8jfJa2kr-hC41tBFTPXFApowukTxkaK8iwN2IspkA0/edit#gid=1596376564

##Tomcat server link:  http://192.168.141.63:8080/DELogistics/mainHomePage   (pages aren't redirecting properly when navigated through root folder, please use IP link while we work on a fix)

##IP link:  http://192.168.141.63:6969/mainHomePage

##Jenkins CI fully functioning (buildsa automatically after each push)

##Credentials of sample users:

*Admin: admin@gmail.com  admin
*Supplier: samplesupplier@gmail.com   Qwerty12#
*Driver: testDriver@gmail.com   Sample@2022

## Getting Started

* Register a supplier and driver before trying to log in for the first time
* Admin must approve supplier details and driver details from admin's page for the login credentials to work


### Dependencies

* Windows 7 and above
* JDK 1.8 and above
* H2-database
* Maven
* Tomcat
* Spring boot


### Installing

* Download the entire project and import it as an existing maven project in spring boot 
* Please enter the outlook account login credentials in app.config file before deploying the project

### Executing program

* Run directly on spring boot/cmd(spring-boot:run) or run the java jar/war file using cmd(java -jar <file name>)
```
Connect throught port:6969 (http://localhost:6969/)
```

## Help

**Sending SMS is not functional as of now due to licensing issues.**
**Since GPS reading data was not provided, we have worked with random locations for the truck's data**
```
More ways to reach us is provided in the contact us page within the web app: http://localhost:6969/contactUs
```

## Authors

Contributors:

* Harshith V
* Dheeraj B N
* Anuj S M
* Santhosh K A
* Shruthi C L
* Moyukh Saha

More info available within the web app here:
http://localhost:6969/aboutUs


## Version History

* 0.1
    * Initial Release.
* 0.2
    * Junit test cases and documentation.
* 0.3
    * UI changes to reduce number of clicks(single login page for all roles), Mailing functionality added.
* 0.4
    * Database redesigned in 3nf form along with several other improvements.


## License

This project is not licensed and is free to use. 


## Acknowledgments


* We'd like to thank Mr.Purushottam Kamat, Mr.Lokesh Nagaraja for providing us with this opportunity.
* We'd also like to thank Mr.Kalvir Singh, Mr.Sunil P for their valuable feedback and suggestions on how to improve and guiding us.
* We'd also like to thank our colleagues for their inputs and help with our project.
