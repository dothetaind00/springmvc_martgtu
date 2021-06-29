use springmvc_martgtu;

insert into role(code,name) values('ADMIN','Quản trị');
insert into role(code,name) values('USER','Người dùng');

insert into user(username,password,firstname,lastname,sex,address,email,numberphone,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Đỗ','Admin',1,'Nam Định','dothetai8@gmail.com','0369732412',1);
insert into user(username,password,firstname,lastname,sex,address,email,numberphone,status)
values('dothetai8','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Đỗ Thế','Tài',1,'Nam Định','dothetaind00@gmail.com','0907483025',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);

insert into category(name,code)
values
	('Thịt - Hải sản - Trứng','category1'),
    ('Rau - Củ - Trái cây','category2'),
    ('Dầu ăn - Gia vị - Đồ khô','category3'),
    ('Thực phẩm đồng lạnh','category4'),
    ('Sữa - Sản phẩm từ sữa','category5'),
    ('Đồ uống - Giải khát','category6');

insert into sale(salepercent)
values
	(0),
    (25),
    (40),
    (50),
    (60),
    (75);
    
insert into product(name,price,quantity,status,category_id,sale_id)
values
	('Bề bề thịt hấp Natur Fish 300g',129000,100,true,1,1),
    ('Thịt ba chỉ bò cắt lát NewZeland KiaOra 475g',153000,100,true,1,1),
    ('Hàu sữa Nhật Minh túi 280g',55000,100,true,1,1),
    ('Hàu sữa Thái Bình Dương Hasubi 300g',61000,100,true,1,1),
    ('Ba chỉ bò Mỹ cắt lát Vimex 500g',125000,100,true,1,1),
    
    ('Cherry đỏ Mỹ',199000,100,true,2,1),
    ('Măng trúc quân tử Kim Bôi 300g',41000,100,true,2,1),
    ('Mộc nấm hương Thu Hằng gói 250g',54000,100,true,2,1),
    ('Giá đỗ L1 VinEco 300g',8000,100,true,2,1),
    ('Rau muống L1 VinEco 500g',15000,100,true,2,1),
    
    ('Mì bò hầm Ottogi Lốc 8 gói x 120g',70000,100,true,3,1),
    ('Gạo Thái Hồng số 1 Phú Hải túi 5kg',130000,100,true,3,1),
    ('Dầu đậu nành Tường An chai 2L',80000,100,true,3,1),
    ('Nước mắm Chinsu cá cơm biển đông chai 500ml',76000,100,true,3,1),
    ('Nước mắm Cana Chai Pet 500ml',41000,100,true,3,1),

	('Tôm nõn size 31/40 miền Hạ Long',127000,100,true,4,1),
    ('Đầu râu mực biển Hạ Long',106000,100,true,4,1),
	('Gà ta xông khói CP 400g',105000,100,true,4,1),
    ('Salami khô tiêu đỏ Ông Già Ika 200g',77000,100,true,4,1),
    ('Xúc xích Đức Bucher CP gói 450g',72000,100,true,4,1),
    
    ('Sữa Hạnh nhân nguyên chất Nature 1L',60000,100,true,5,1),
    ('Sữa Yến mạch nguyên chất Nature 1L',60000,100,true,5,1),
    ('Sữa tươi tiệt trùng ít béo 1L',32000,100,true,5,1),
    ('Sữa tiệt trùng Avonmore ít béo 1L',40000,100,true,5,1),
    ('Sữa đặc Mr Pack Vpmilk 1kg',33000,100,true,5,1),
    
    ('Cà phê tan Gold Original Vinacafe 800g',78000,100,true,6,1),
    ('Nước ép Vinmart Good dưa bở 500ml',18000,100,true,6,1),
    ('Nước trái cây cao cấp Fruit Kiwi Táo - Hộp 1L',50000,100,true,6,1),
    ('Nước trái cây cao cấp Fruit Love Lựu Táo - Hộp 1L',50000,100,true,6,1),
    ('Cà phê truyền thống Highlands Coffee gói 200g',48000,100,true,6,1);

insert into detailproduct(description, image, product_id)
values
	('Bề bề thịt hấp Natur Fish được chế biến sẵn bằng cách hấp chín, tách luôn vỏ cứng, chỉ để lại phần thịt thơm ngon, giúp dễ chế biến mà vẫn giữ nguyên được hương vị. Bề bề được lấy từ nguồn hải sản sạch, tươi ngon. Mọi khâu từ tuyển chọn nguyên liệu tới đóng bao bì đều diễn ra khép kín dưới sự giám sát và kiểm tra nghiêm ngặt, giúp người tiêu dùng hoàn toàn có thể yên tâm khi lựa chọn.','1-bebe.jpg',1),
    ('Thịt Ba chỉ bò cắt lát New Zealand KiaOra (475g) được chế biến và sản xuất bởi thương hiệu KiaOra - là một thương hiệu thuộc công ty Cổ phần Sản phẩm New Zealand. Với các cổ đông của công ty đa phần là các doanh nhân có nhiều kinh nghiệm trong các lĩnh vực sản xuất, phân phối và bán buôn, bán lẻ các loại thực phẩm được nhập khẩu từ New Zealand. Với định hướng chỉ bán các sản phẩm “Made in New Zealand” – công ty hy vọng sẽ tạo được niềm tin nơi khách hàng trong một thị trường còn thiếu minh bạch về nguồn gốc và chất lượng sản phẩm ở Việt Nam.','2-thibachi.jpg',2),
    ('Hàu sữa có tính mát, lại dễ chế biến, đa dạng về món ăn và chứa nhiều dinh dưỡng. Trong hàu sữa có chứa protein, carbohydrates và nguồn vitamin dồi dào như: A, B1, B2, B3, C, D tăng khả năng chống viêm của cơ thể, giúp chống lại mệt mỏi, và tăng cường quá trình trao đổi chất). Lượng cholesterol trong Hàu rất thấp, thích hợp cho những người đang ăn kiêng. Thịt hàu đầy, căng tròn, béo mập, chứa lượng lớn sữa bên trong nên rất béo, ngọt, đậm đà hương muối từ biển.','3-hau-sua-nhat.jpg',3),
    ('Hàu sữa Thái Bình Dương Hasubi gói 300g được chế biến và sản xuất bởi thương hiệu BIM Group – là một tập đoàn kinh tế đa ngành lớn nhất tại Việt Nam. BIM Group được đánh giá là nhà nuôi trồng, sản xuất và xuất khẩu thủy sản hàng đầu tại Việt Nam, với tổng sản lượng tối đa có thể đạt hơn 10.000 tấn/năm, đồng thời sở hữu cánh đồng muối rộng nhất Đông Nam Á tại Quán Thẻ, tỉnh Ninh Thuận, với diện tích hơn 2.500ha và công suất tối đa trên 500,000 tấn muối thô/năm. Song hành với chặng đường phát triển chung của ngành nông nghiệp thực phẩm tại Việt Nam, BIM sẽ tiếp tục đẩy mạnh đầu tư gia tăng quy mô sản xuất, đưa ra thị trường những sản phẩm chất lượng cao và an toàn.','4-hau-sua_thaibinhduong.jpg',4),
    ('Thịt Ba chỉ bò Mỹ cắt lát Vimex là sản phẩm của doanh nghiệp Vimexfood. Mặc dù mới chỉ thành lập năm 2015 nhưng Vimex đã để lại được ấn tượng với đông đảo người tiêu dùng là một đơn vị chuyên cung cấp đa dạng, nhập khẩu trực tiếp từ các thương hiệu hàng đầu trên thế giới, nguồn gốc rõ ràng bảo đảm vệ sinh an toàn thực phẩm với giá cả cạnh tranh, chính sách bán hàng tốt nhất, bảo đảm tối đa lợi ích cho khách hàng. Trong các hoạt động thương mại, VimexFood đặt tôn chỉ "Mang đến những sản phẩm thực phẩm ngon nhất, an toàn nhất tới tay người tiêu dùng" lên hàng đầu','5-ba-chi-bo.jpg',5),
    ('Cherry đỏ Mỹ là sản phẩm tươi ngon, được nhập khẩu trực tiếp từ Mỹ về Việt Nam. Từ quá trình thu hái, đóng gói, bảo quản đều được thực hiện cẩn thận, theo quy trình khép kín, áp dụng các công nghệ hiện đại, nhằm giữ cho trái Cherry được tươi ngon nhất, không bị trầy xước, rụng cuống hay dập nát.','6-cherry-m.jpg',6),
    ('Măng trúc quân tử Kim Bôi 300g được chọn lọc từ măng nứa tự nhiên. Trong măng chứa khá nhiều magiê và rất giàu chất xơ, cùng với hàm lượng chất béo, chất đường rất thấp, măng là loại thực phẩm có tác dụng thúc đẩy nhu động ruột, trợ giúp tiêu hóa, phòng chống có hiệu quả tình trạng béo phì, xơ vữa động mạch, cao huyết áp.','7-mangchuc.jpg',7),
    ('Hạn sử dụng thực tế quý khách vui lòng xem trên bao bì. Hình sản phẩm chỉ mang tính chất minh họa, hình bao bì của sản phẩm tùy thời điểm sẽ khác so với thực tế.','8-moc-nam.jpg',8),
    ('Giá đỗ L1 VinEco 300g có chứa các chất dinh dưỡng, nhiều vitamin C và E, lượng calo thấp, là loại thực phẩm tốt cho sức khỏe. Giá đỗ giàu vitamin đặc biệt là vitamin C, khoáng chất, amino axit, protein và chất có nguồn gốc thực vật (phytochemicals) là các chất bổ dưỡng cho cơ thể.','9-gia-do.jpg',9),
    ('VinEco Rau muống L1 (450g-500g) là một trong những loại thực phẩm quen thuộc hàng ngày, có giá rất rẻ, dễ ăn và hầu như ai cũng biết đến. Loại rau này chứa nhiều kali, canxi, đồng, và các khoáng chất khác như sắt, magie, phospho, natri. Ngoài ra các loại Vitamin như C, E, K, B1, niacin, B5, B6, folate và biotin.','10-rau-muong.jpg',10),
    ('Là một trong những món ăn đậm vị, đạt tiêu chuẩn cao cấp Mì bò hầm Ottogi Lốc 8 gói x 120g sẵn sàng thay thế những bữa ăn nhanh của người dùng khi không có thời gian nấu nướng hay cũng có thể là một món ăn hấp dẫn cho ai muốn thay đổi khẩu vị.','11-mi-bo-ham.jpg',11),
    ('Gạo Thái hồng số 1 Phú Hải​ túi 5kg có hạt nhỏ dài, màu trắng trong. Gạo khi chín có vị đậm, dẻo mềm và hương thơm lôi cuốn. Sản phẩm giúp những bữa cơm gia đình thêm ngon miệng, đầm ấm. Gạo Thái hồng số 1 Phú Hải​ được sàng lọc kỹ trước khi đóng túi dày dặn, kín hơi, đảm bảo không để côn trùng và các tác động ngoại cảnh khác làm ảnh hưởng đến chất lượng của gạo. Sản phẩm không lẫn tạp chất, giúp bạn thưởng thức trọn vẹn vị ngon trong từng bữa ăn.','12-gao-hongthai.jpg',12),
    ('Dầu đậu nành Tường An có thành phần nguyên liệu được lựa chọn kỹ lưỡng, đảm bảo vệ sinh an toàn thực phẩm. Dầu đậu nành cung cấp nhiều dưỡng chất như Omega 3, 6, 9 và Vitamin E tự nhiên, không có Cholesterol, bảo đảm sản phẩm tốt cho sức khỏe tim mạch. Thành phần 100% dầu nành nguyên chất có hàm lượng dinh dưỡng cao sẽ giúp bạn dễ dàng chế biến những món ăn bảo vệ sức khỏe cho gia đình bạn.','13-dau-dau-nanh.jpg',13),
    ('Nước mắm Chinsu cá cơm biển đông chai 500ml là gia vị ngon khó cưỡng được rất nhiều bà nội trợ tin dùng để nêm nếm cho những món ăn của mình. Sản phẩm được sản xuất với công nghệ hoàn toàn mới đặc biệt đươc lựa chọn nguồn nguyên liệu tươi ngon đảm bảo cùng với quy trình khép kín, từ khâu chọn nguyên liệu đến khâu đóng chai, đảm bảo chất lượng cho người sử dụng. Nước mắm với độ đạm đạt tiêu chuẩn mang lại vị đậm đà, ngọt bùi của cá và dậy mùi đặc trưng tạo cảm giác mới lạ kích thích vị giác.','14-mam-chinsu.jpg',14),
    ('Nước mắm Cana 25°N Chai Pet 500ml với 2 thành phần nguyên liệu chính: cá cơm và muối biển tinh khiết Cà Ná (là loại muối tốt nhất Đông Nam Á, độ tinh khiết lớn hơn 95%). Từ những nguyên liệu quý giá này và công thức ủ chượp hàng trăm năm CANA cho ra nước mắm màu nâu cánh gián, sóng sánh đậm đà hương vị, thơm nồng đúng chuẩn vị nước mắm truyền thống. Sản phẩm được phân tích kiểm nghiệm nghiêm ngặt trước khi đóng gói thành phẩm cung cấp cho người sử dụng.','15-mam-cana.jpg',15),
    ('Tôm nõn Miền Hạ Long là thực phẩm giàu dinh dưỡng được nhiều người nội trợ tin dùng cho bữa ăn của cả gia đình. Tôm nõn sẽ giúp làm đa dạng thực đơn ăn uống cũng như cung cấp nhiều chất dinh dưỡng hơn cho cơ thể. Trong đó đặc biệt phải kể đến hàm lượng protein cao giúp tăng cường sức đề kháng; chất sắt dồi dào cho cơ thể khỏe mạnh, tránh tình trạng thiếu sắt trong máu và vitamin B2 tốt cho mắt, cải thiện thể trạng mệt mỏi hiệu quả.','16-tom-non.jpg',16),
    ('Đầu râu mực Miền Hạ Long là thực phẩm được chọn lựa từ những con mực tươi ngon, tự nhiên, cho ra những sản phẩm chất lượng cao. Sản phẩm có chứa nhiều chất dinh dưỡng có lợi cho sức khỏe. Theo các chuyên gia, mực là nguồn phong phú protein, axit béo omega 3, đồng, kẽm, vitamin B và i-ốt. Chất đồng chứa trong mực được chứng minh có tác dụng tốt cho sự hấp thu dinh dưỡng của cơ thể, lưu trữ và chuyển hóa sắt, hình thành hồng huyết cầu. ','17-dau-rau-muc.jpg',17),
    (' Hạn sử dụng thực tế quý khách vui lòng xem trên bao bì. Hình sản phẩm chỉ mang tính chất minh họa, hình bao bì của sản phẩm tùy thời điểm sẽ khác so với thực tế.','18-ga-ta-xong-khoi.jpg',18),
    ('Sản phẩm Salami khô tiêu đỏ Ông Già Ika được chế biến sẵn và đóng gói tiện dụng, các bà nội trợ chỉ cần bỏ sản phẩm ra khỏi bao bì là ngay lập tức đã có món ăn thơm ngon và bổ dưỡng cho gia đình. Ngoài ra, đây cũng là lựa chọn thích hợp cho những buổi du lịch, dã ngoại ngắn ngày.','19-salami-kho-iteu.jpg',19),
    ('Xúc xích Đức Bucher là thành quả từ quá trình đúc kết kinh nghiệm và sự chuyên nghiệp trong việc chọn lựa nguyên liệu thịt. Các loại thịt, gia vị và nguyên liệu phải được lấy từ những nguồn đáng tin cậy. Ngoài ra, để cho ra đời được cây xúc xích thơm ngon đòi hỏi người sản xuất phải luôn đặt tâm huyết vào từng công đoạn chế biến, mang đến hương vị thơm ngon tuyệt hảo và chất lượng cho sản phẩm. Xúc xích Đức Bucher còn có rất nhiều loại khác nhau để người tiêu dùng tùy thích lựa chọn và cảm nhận được hương vị thật sự của mỗi loại xúc xích.','20-xuc-xich-duc.jpg',20),
    ('Hạn sử dụng thực tế quý khách vui lòng xem trên bao bì. Hình sản phẩm chỉ mang tính chất minh họa, hình bao bì của sản phẩm tùy thời điểm sẽ khác so với thực tế.','21-sua-hanh-nhan.jpg',21),
    ('Hạn sử dụng thực tế quý khách vui lòng xem trên bao bì. Hình sản phẩm chỉ mang tính chất minh họa, hình bao bì của sản phẩm tùy thời điểm sẽ khác so với thực tế.','22-sua-yen-mach.jpg',22),
    ('Sữa tươi tiệt trùng ít béo Australia Own 1L được làm từ sữa bò tươi tách béo nguyên chất 100% với hàm lượng béo được giảm tối đa. Sản phẩm mang lại nguồn dinh dưỡng dồi dào cho cơ thể đặc biệt là dành cho những người béo phì, người đang ăn kiêng.','23-sua-tiet-trung.jpg',23),
    ('Hạn sử dụng thực tế quý khách vui lòng xem trên bao bì. Hình sản phẩm chỉ mang tính chất minh họa, hình bao bì của sản phẩm tùy thời điểm sẽ khác so với thực tế.','24-sua-avronmore.jpg',24),
    ('Creamer đặc có đường VPMilk Ông Park  có hàm lượng dinh dưỡng: bổ sung nhiều vitamin (A, B1, B6, C, D3, E) rất tốt cho cơ thểHướng dẫn sử dụng: vị ngon sánh mịn, thơm ngon vị kem sữa phù hợp để pha cà phê sữa, dùng với bánh mì, làm sữa chua, làm bánh flan, làm sinh tố...','25-sua-dac.jpg',25),
    ('Cà phê tan Gold Original Vinacafe 800g được chắt lọc từ những hạt cà phê ngon tươi nhất cùng dây chuyền sản xuất hiện đại và công nghệ sản xuất đặc biệt tạo ra sản phẩm Vinacafé mang đến cho người thưởng thức trải nghiệm cà phê độc đáo, khó cưỡng lại.','26-vina-coffee.jpg',26),
    ('Hạn sử dụng thực tế quý khách vui lòng xem trên bao bì. Hình sản phẩm chỉ mang tính chất minh họa, hình bao bì của sản phẩm tùy thời điểm sẽ khác so với thực tế.','27-dua-bo.jpg',27),
    ('Nước trái cây cao cấp Vinamilk Fruit Love với dưỡng chất tinh túy từ thiên nhiên và giữ trọn vị ngọt tự nhiên giàu dưỡng chất, cho cơ thể khỏe mạnh và tràn đầy sức sống. 1 lít nước trái cây cao cấp Vinamilk Fruit Love được ép từ khoảng 2kg trái cây tươi ngon tự nhiên không biến đổi gen. Có vị ngọt tự nhiên từ nước ép trái cây, hoàn toàn không bổ sung đường. Sản phẩm không sử dụng chất bảo quản.','28-nuoc-kiwi.jpg',28),
    ('Nước trái cây cao cấp Vinamilk Fruit Love với dưỡng chất tinh túy từ thiên nhiên và giữ trọn vị ngọt tự nhiên giàu dưỡng chất, cho cơ thể khỏe mạnh và tràn đầy sức sống.','29-nuoc-kiwi-luu.jpg',29),
    ('Cà phê rang xay Truyền Thống Highlands Coffee gói 200g là sản phẩm được sản xuất theo công nghệ tiên tiến trên dây chuyền hiện đại. Với phần nguyên liệu được tạo nên sản phẩm dược chọn lọc kĩ càng từ những vườn cà phê chất lượng nhất Việt Nam.','30-caphe-truyenthong.jpg',30);

SELECT * FROM product WHERE name LIKE binary '%Ba%' COLLATE latin1_general_cs;


