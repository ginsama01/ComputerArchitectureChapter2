# Update nhỏ 22h 24/10/2020
* Fix bug chạy lỗi khi phần fraction = 00000...0000 trong bd dấu phẩy động độ cxac đơn và kép

# Update 17h 24/10/2020
* Số thực dấu phẩy tĩnh không dấu nay tính chính xác đến 16 chữ số thập phân
* Chuẩn bit dấu, bù 1, bù 2 nay có thể biểu diễn trong ô nhớ 32 bit, 64 bit (Bug: bị tràn số trong một số trường hợp nhưng đề kiểm tra có lẽ cũng ko có đến 32 bit, 64 bit nên mình ko fix nữa :(
* Dấu phẩy tính có dấu nay có thể viết dưới dạng 0010 1010 0010 0110 hoặc 0010101000100100 hoặc 00101010.00100110

# Update 10h15 24/10/2020
* Fix lỗi cộng trừ số thực dấu phẩy động kết quả sai
* Fix lỗi ko viết được số âm khi điền biểu thức trong exp

## Đôi lời của tác giả
* Code được viết ra để phục vụ việc ôn tập + thi KTMT chương 2
* Source code sử dụng jdk 1.8, viết bằng IntelliJ IDEA
* Vì là code của cá nhân mình nên nhiều chỗ mình code hơi ngu, mong các pro nếu có đọc thông cảm
* Cũng vì là code của cá nhân nên có thể ko chính xác tuyệt đối, mình không khuyến khích sử dụng hoàn toàn trong lúc thi, nên tính tay và kiểm tra lại = app
, hoặc sử dụng hoàn toàn app nếu tin tưởng :), ***nhưng nếu có vấn đề gì ảnh hưởng đến điểm số của bạn, mình xin phép không chịu trách nhiệm***
* Trong quá trình test app, nếu các bạn phát hiện sai xót, please report it to me *https://www.facebook.com/daylawebgithe/*
* Thoải mái share và tìm lỗi cho mình, fix hộ luôn cũng được :)

## Về cách sử dụng
1. Để chuyển đổi cơ số, điền số vào đúng vị trí mà nó nên ở rồi ấn Enter, kết quả chuyển đổi sẽ xuất hiện
2. Để tính toán với số thức dấu phẩy động, điển 2 toán tử A và B rồi ấn vào Button chỉ phép toán tương ứng
hoặc gõ cả phép toán vào ô Exp
## Một số lưu ý:
* Chuẩn bit = chuẩn bit dấu
* Không có chức năng đổi từ hệ 8, 16 sang hệ khác
* Choice Box đằng sau các số là số thể hiện ô nhớ bao nhiêu bit
* Phẩy tĩnh 0 dấu = số thực dấu phẩy tính không dấu
* BD ô nhớ có dấu = số thực dấu phẩy tĩnh có dấu, 2 ô đằng sau thể hiện số bit phần nguyên và số bit phần thực
* Có thể chuyển từ số thực dấu phẩy tĩnh có dấu bằng cách viết số dạng xxxx.xxxx
* Khi đổi từ dấu phẩy động, cần viết dưới dạng 1.xxxx x 2^(xx)

## Good Luck
