# CustomCard

ĐỀ KIỂM TRA - MÔN: KIẾN TRÚC & THIẾT KẾ PHẦN MỀM NÂNG CAO
Thời gian làm bài: 120 phút
Hình thức: Tự luận trên máy (Ứng dụng Desktop)

Chủ đề: THIẾT KẾ VÀ ĐẶT HÀNG MỘT BỘ BÀI CUSTOM 🃏
Mô tả:

Anh/Chị hãy xây dựng một ứng dụng desktop cho phép người dùng tự tay thiết kế một bộ bài (Deck) theo chủ đề, sau đó tiến hành đặt hàng. Ứng dụng sẽ bao gồm hai màn hình chính: Màn hình thiết kế và Màn hình thanh toán.

Luồng hoạt động chính:

Màn hình 1 (Thiết kế):

Người dùng thiết kế một lá bài cơ bản (chọn nhân vật, khung viền).

Người dùng có thể thêm các "hiệu ứng đặc biệt" vào lá bài.

Người dùng có thể thay đổi "theme" (màu sắc) của giao diện thiết kế.

Sau khi hoàn tất, người dùng nhấn "Đặt hàng" để chuyển sang màn hình thanh toán.

Màn hình 2 (Thanh toán):

Hiển thị thông tin chi tiết của bộ bài đã thiết kế.

Cho phép người dùng chọn phương thức thanh toán.

Nút "Xác nhận" sẽ lưu đơn hàng vào cơ sở dữ liệu.

Yêu cầu bắt buộc về Mẫu Thiết Kế:
1) Mẫu Singleton (Nhóm Khởi tạo)

Chức năng: Quản lý kết nối CSDL.

Yêu cầu: Toàn bộ ứng dụng phải sử dụng một và chỉ một đối tượng kết nối JDBC duy nhất để lưu đơn hàng.

2) Mẫu Builder (Nhóm Khởi tạo)

Chức năng: Xây dựng đối tượng Card cơ bản (chưa có hiệu ứng).

Yêu cầu: Cung cấp các lựa chọn (nhân vật, khung viền). Mẫu Builder phải được dùng để tạo ra một đối tượng Card nền hoàn chỉnh từ các lựa chọn này.

3) Mẫu Decorator (Nhóm Cấu trúc)

Chức năng: Thêm các "hiệu ứng đặc biệt" vào lá bài.

Yêu cầu: Mỗi hiệu ứng (ví dụ: Hiệu ứng Lấp lánh, Hiệu ứng Lửa) phải là một lớp Decorator "bọc" bên ngoài đối tượng Card, có nhiệm vụ cập nhật mô tả và cộng thêm điểm sức mạnh cho lá bài.

4) Mẫu Abstract Factory (Nhóm Cấu trúc) - Số 1

Chức năng: Thay đổi giao diện (theme).

Yêu cầu: Cung cấp các "bộ giao diện" (ví dụ: Theme Ánh Sáng, Theme Bóng Tối). Mẫu Abstract Factory phải được dùng để tạo ra các bộ màu sắc khác nhau cho cửa sổ ứng dụng.

5) Mẫu Abstract Factory (Nhóm Cấu trúc) - Số 2

Chức năng: Tạo ra các bộ nhân vật theo chủ đề.

Yêu cầu: Cung cấp các "nhà máy" riêng biệt (ví dụ: FantasyCharacterFactory, SciFiCharacterFactory), trong đó mỗi nhà máy chịu trách nhiệm tạo ra một bộ các nhân vật (Hiệp sĩ, Pháp sư hoặc Phi hành gia, Robot) thuộc chủ đề đó.

6) Mẫu Flyweight (Nhóm Cấu trúc)

Chức năng: Quản lý thông tin về các khung viền (card borders).

Yêu cầu: Thông tin về mỗi loại khung viền (tên, độ hiếm) là bất biến. Mẫu Flyweight phải được dùng để quản lý một "bể" chứa các đối tượng khung viền, đảm bảo thông tin cho mỗi loại chỉ được tải vào bộ nhớ một lần.

7) Mẫu Template Method (Nhóm Hành vi)

Chức năng: Định nghĩa quy trình lưu đơn hàng vào CSDL.

Yêu cầu: Tạo một lớp cơ sở định nghĩa thuật toán lưu đơn hàng với các bước cố định: kết nối CSDL, chuẩn bị dữ liệu, thực thi lệnh lưu, và đóng kết nối. Các lớp con có thể tùy chỉnh lại bước chuẩn bị dữ liệu cho các loại đơn hàng khác nhau (nếu có).

😎 Mẫu Strategy (Nhóm Hành vi)

Chức năng: Xử lý thanh toán.

Yêu cầu: Cung cấp các chiến lược thanh toán khác nhau (ví dụ: Thanh toán bằng thẻ tín dụng, Thanh toán bằng ví điện tử). Mẫu Strategy phải được dùng để cho phép người dùng chọn và thực thi một phương thức thanh toán cụ thể.
