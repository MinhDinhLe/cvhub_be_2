INSERT INTO chatbot_rule (pattern, response, category, priority) VALUES

-- Câu hỏi về tìm việc
('(tìm|xem) (việc|công việc) (như thế nào|làm sao|thế nào)', 
'Để tìm việc phù hợp:\n1. Vào mục "Tìm việc"\n2. Sử dụng bộ lọc ngành nghề, địa điểm\n3. Xem chi tiết và ứng tuyển', 
'job', 1),

-- Câu hỏi về ứng tuyển
('(cách|làm sao) (để)? ứng tuyển', 
'Quy trình ứng tuyển:\n1. Đăng nhập\n2. Vào chi tiết công việc\n3. Nhấn "Ứng tuyển"\n4. Điền thông tin\n5. Đợi phản hồi từ nhà tuyển dụng', 
'application', 1),

-- Câu hỏi về phỏng vấn
('(phỏng vấn|interview) (như thế nào|thế nào|ra sao)', 
'Khi được mời phỏng vấn:\n1. Kiểm tra email và thông báo\n2. Xác nhận lịch phỏng vấn\n3. Chuẩn bị hồ sơ\n4. Tham gia đúng giờ', 
'interview', 2),

-- Câu hỏi về đăng tin tuyển dụng
('(cách|làm sao) (để)? đăng (tin|bài) tuyển dụng', 
'Để đăng tin tuyển dụng:\n1. Đăng nhập tài khoản nhà tuyển dụng\n2. Vào mục "Đăng tin"\n3. Điền thông tin chi tiết\n4. Chọn gói đăng tin\n5. Thanh toán và đăng tin', 
'employer', 2),

-- Câu hỏi về thanh toán
('(thanh toán|payment|nạp tiền) (như thế nào|thế nào|làm sao)', 
'Chúng tôi hỗ trợ các hình thức thanh toán:\n1. Chuyển khoản ngân hàng\n2. Ví điện tử\n3. Thẻ tín dụng/ghi nợ', 
'payment', 3),

-- Từ chối câu hỏi không liên quan
('(thời tiết|chứng khoán|bóng đá|phim ảnh)', 
'Xin lỗi, tôi chỉ có thể tư vấn về các vấn đề liên quan đến tuyển dụng và tìm việc.', 
'other', 10),

-- Câu chào và giới thiệu
('(xin chào|hello|hi|hey|chào)', 
'Xin chào! Tôi là trợ lý ảo của WorkFinder. Tôi có thể giúp bạn:\n1. Tìm việc làm\n2. Hướng dẫn ứng tuyển\n3. Tư vấn phỏng vấn\n4. Hỗ trợ đăng tin tuyển dụng', 
'greeting', 1),

-- Hỏi về tài khoản
('(tạo|đăng ký|register) (tài khoản|account)',
'Để đăng ký tài khoản:\n1. Chọn loại tài khoản (Ứng viên/Nhà tuyển dụng)\n2. Điền thông tin cá nhân\n3. Xác thực email\n4. Hoàn tất hồ sơ',
'account', 1),

-- Hỏi về CV
('(tạo|làm|viết) (cv|resume|hồ sơ)',
'Để tạo CV ấn tượng:\n1. Vào mục "Tạo CV"\n2. Chọn mẫu CV phù hợp\n3. Điền thông tin chi tiết\n4. Tải về hoặc lưu trực tuyến',
'cv', 2),

-- Hỏi về công ty
('(tìm|xem) thông tin (công ty|doanh nghiệp)',
'Để tìm hiểu về công ty:\n1. Vào mục "Công ty"\n2. Tìm kiếm theo tên\n3. Xem đánh giá và review\n4. Theo dõi công ty yêu thích',
'company', 2),

-- Hỏi về lương
('(mức lương|salary|thu nhập) (thế nào|như thế nào|bao nhiêu)',
'Mức lương phụ thuộc vào:\n1. Vị trí công việc\n2. Kinh nghiệm\n3. Kỹ năng\n4. Công ty\nBạn có thể xem thông tin lương trong mô tả công việc',
'salary', 2),

-- Hỏi về kinh nghiệm
('(yêu cầu|cần) (kinh nghiệm|experience)',
'Yêu cầu kinh nghiệm thường gồm:\n1. Số năm kinh nghiệm\n2. Kỹ năng chuyên môn\n3. Chứng chỉ liên quan\n4. Thành tích nổi bật',
'experience', 3),

-- Hỏi về địa điểm
('(tìm việc|công việc) (ở|tại) (đâu|khu vực nào)',
'Bạn có thể tìm việc theo:\n1. Tỉnh/Thành phố\n2. Quận/Huyện\n3. Khu công nghiệp\n4. Làm việc từ xa',
'location', 3),

-- Hỏi về thời gian
('(thời gian|giờ) làm việc',
'Thông tin giờ làm việc:\n1. Full-time: 8h/ngày\n2. Part-time: 4-6h/ngày\n3. Remote: Linh hoạt\n4. Ca/Kíp: Theo lịch công ty',
'worktime', 3),

-- Hỏi về quyền lợi
('(quyền lợi|chế độ|benefit)',
'Quyền lợi thường có:\n1. BHXH, BHYT\n2. Thưởng các dịp lễ\n3. Đào tạo phát triển\n4. Nghỉ phép theo luật\n5. Các phúc lợi khác',
'benefit', 3),

-- Hỏi về đánh giá
('(đánh giá|review) (công ty|doanh nghiệp)',
'Bạn có thể xem đánh giá công ty:\n1. Review từ nhân viên\n2. Điểm đánh giá\n3. Ưu/nhược điểm\n4. Văn hóa công ty',
'review', 4),

-- Việc làm ở Hồ Chí Minh
('(việc làm|tìm việc).*(hồ chí minh|sài gòn|hcm|tphcm)', 
'Các việc làm tại TP.HCM:\n
1. Xem ngay việc làm mới nhất: <a href="/jobs?location=hcm">https://workfinder.vn/jobs?location=hcm</a>\n
2. Khu vực phổ biến:\n
   - Quận 1: <a href="/jobs?district=quan-1">Việc làm Quận 1</a>\n
   - Quận 7: <a href="/jobs?district=quan-7">Việc làm Quận 7</a>\n
   - Thủ Đức: <a href="/jobs?district=thu-duc">Việc làm Thủ Đức</a>\n
3. Ngành nghề hot:\n
   - IT: <a href="/jobs?category=it&location=hcm">IT/Phần mềm</a>\n
   - Kinh doanh: <a href="/jobs?category=sales&location=hcm">Sales/Marketing</a>\n
4. Mức lương phổ biến: 8-25 triệu/tháng\n
5. Các khu công nghiệp:\n
   - KCN Tân Bình\n
   - KCN Tân Thuận\n
   - KCN Sài Gòn Hi-Tech',
'location_hcm', 1),

-- Việc làm theo quận/khu vực HCM
('(việc làm|tìm việc).*(quận|district) (\d+|thủ đức|bình thạnh|tân bình|phú nhuận)', 
'Thông tin việc làm khu vực {district}:\n
1. Xem việc làm mới nhất: <a href="/jobs?district={district_slug}">Link việc làm {district}</a>\n
2. Các công ty tuyển dụng nhiều:\n
   - Công ty A: <a href="/company/a">Chi tiết</a>\n
   - Công ty B: <a href="/company/b">Chi tiết</a>\n
3. Ngành nghề phổ biến:\n
   - Văn phòng\n
   - Kinh doanh\n
   - Dịch vụ\n
4. Phương tiện di chuyển: Bus số X, Y, Metro (nếu có)',
'location_district', 2),

-- Việc làm theo ngành ở HCM
('(việc làm|tìm việc).*(it|công nghệ|phần mềm|lập trình).*(hồ chí minh|sài gòn|hcm)',
'Việc làm IT/Công nghệ tại TP.HCM:\n
1. Xem việc làm IT mới nhất: <a href="/jobs?category=it&location=hcm">Link việc làm IT</a>\n
2. Top công ty công nghệ:\n
   - FPT Software: <a href="/company/fpt">Chi tiết</a>\n
   - VNG: <a href="/company/vng">Chi tiết</a>\n
3. Kỹ năng được yêu cầu:\n
   - Java, Python, JavaScript\n
   - DevOps, Cloud\n
   - Agile/Scrum\n
4. Mức lương: 15-50 triệu/tháng\n
5. Địa điểm làm việc:\n
   - Quận 1\n
   - Thủ Đức (Khu CNC)\n
   - Quận 7 (Phú Mỹ Hưng)',
'job_category_location', 1),

-- Việc làm remote/WFH ở HCM
('(remote|work from home|wfh|làm việc từ xa).*(hồ chí minh|sài gòn|hcm)',
'Việc làm Remote/WFH tại TP.HCM:\n
1. Xem việc làm Remote: <a href="/jobs?type=remote&location=hcm">Link việc làm Remote</a>\n
2. Ngành phù hợp:\n
   - IT/Phần mềm\n
   - Digital Marketing\n
   - Thiết kế đồ họa\n
   - Content/Copywriting\n
3. Yêu cầu:\n
   - Laptop/PC cá nhân\n
   - Internet ổn định\n
   - Kỹ năng làm việc độc lập\n
4. Tips làm việc remote:\n
   - Sắp xếp không gian làm việc\n
   - Quản lý thời gian hiệu quả\n
   - Giao tiếp online thường xuyên',
'remote_work', 2); 