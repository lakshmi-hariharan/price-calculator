create table product
(
   itemID integer not null,
   itemName varchar(255) not null,
   itemCost integer not null,
   primary key(itemID)
);

create table exRate 
(
   currencyAlpha varchar(255) not null,
   currencyValue float not null
)

