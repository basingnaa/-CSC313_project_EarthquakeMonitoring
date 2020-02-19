create database galam;
use galam;

Create table galamseydata(
	colour varchar(10),
    year_observed year,
    latitude double,
    longitude double,
    primary key(latitude,longitude)
	);
create table observatorydata(
	observatoryName varchar(35),
    countryName varchar(20),
    primary key(observatoryName,countryName),
    galamseyStartYear mediumint,
    areaCovered mediumint
	);