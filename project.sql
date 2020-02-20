create database galam;
use galam;

Create table galamseydata(
	observatoryName varchar(35),
	colour varchar(10),
    colour_value tinyint,
    year_observed year,
    latitude double,
    longitude double,
    primary key(latitude,longitude),
    foreign key(observatoryName) references observatorydata(observatoryName)
	);
create table observatorydata(
	observatoryName varchar(35),
    countryName varchar(20),
    primary key(observatoryName,countryName),
    galamseyStartYear mediumint,
    areaCovered mediumint
	);
    
    select * from galamseydata;
    select * from observatorydata; 