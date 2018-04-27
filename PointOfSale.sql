CREATE TABLE Users ( Username varchar (15) not null, Password varchar (10) not null, Role varchar (8) not null,
 Nama_user varchar (20) not null, primary key (Username));
CREATE TABLE Category ( ID int (5) not null, Nama varchar (15) not null, primary key (ID));
CREATE TABLE Item ( Kode int (5) not null, Nama varchar (15) not null, 
Category_ID int (5) not null, Harga int (7) not null, primary key (Kode), 
foreign key (Category_ID) references Category(ID));
CREATE TABLE Report ( ID int (5) not null, Username varchar (20) not null, Jumlah_item int (5) not null,
Metode_pembayaran varchar (8) not null, Total_pembayaran int (7) not null, primary key (ID));

INSERT INTO Category VALUES ('1','Makanan Instan');
INSERT INTO Category VALUES ('2','Makanan Ringan');
INSERT INTO Category VALUES ('3','Makanan Anak');
INSERT INTO Category VALUES ('4','Makanan Kaleng');
INSERT INTO Category VALUES ('5','Minuman');
INSERT INTO Category VALUES ('6','Susu');
INSERT INTO Category VALUES ('7','Peralatan Mandi');

INSERT INTO Item VALUES ('10046','Indomie','1','2500');
INSERT INTO Item VALUES ('20046','Pop mie','1','4500');
INSERT INTO Item VALUES ('10045','Aqua','5','3500');
INSERT INTO Item VALUES ('20045','Frestea','5','4000');
INSERT INTO Item VALUES ('10246','Lays','2','9500');
INSERT INTO Item VALUES ('20246','Doritos','2','8800');
INSERT INTO Item VALUES ('10346','Cerelac sereal','3','9300');
INSERT INTO Item VALUES ('20346','Sun marie','3','9000');
INSERT INTO Item VALUES ('10446','Pronas kornet','4','26500');
INSERT INTO Item VALUES ('20446','Vinisi tuna','4','10500');
INSERT INTO Item VALUES ('10245','Ultra milk','6','5000');
INSERT INTO Item VALUES ('20245','Bear brand','6','8300');
INSERT INTO Item VALUES ('10044','Biore body foam','7','9400');
INSERT INTO Item VALUES ('20044','Zinc shampoo','7','18600');


Select * from category;
Select * from Item;