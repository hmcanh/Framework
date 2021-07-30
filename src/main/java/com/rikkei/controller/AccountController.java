package com.rikkei.controller;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rikkei.dto.AccontDto;
import com.rikkei.entity.Account;
import com.rikkei.form.AccountFormForCreating;
import com.rikkei.form.AccountFormForUpdating;
import com.rikkei.service.IAccountService;
//•	@RestController: Giúp chúng ta khai báo ra 1 class để triển khai RestAPI
@RestController
//@RequestMapping là annotation khai báo ở cấp độ class và method, dùng để đăng ký và ánh xạ các request tới một method của controller.
//dựa vào các thuộc tính như URL, HTTP method, request parameters, headers và media types
//Tạo ra các restapi có endpoint bắt đầu bằng "/api/v1/accounts"
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
	//Tiêm 
@Autowired
private IAccountService accountService;
//@GetMapping sẽ tạo cho chúng ta 1 API có method GET và thường dùng cho việc truy vấn dữ liệu, lấy thông tin
@GetMapping()
//ResponseEntity đại diện cho toàn bộ phản hồi HTTP: mã trạng thái, tiêu đề và nội dung
//Lấy ra toàn bộ acccount
public ResponseEntity<?> getAllAccount() {
List<Account> entities = accountService.getAllAccount();
List<AccontDto> dtos = new ArrayList<>();
// convert entities --> dtos
for (Account account : entities) {
AccontDto dto = new AccontDto(account.getId(), account.getEmail(), 
account.getUsername(),
account.getFullname(), account.getDepartment().getName(),
account.getPosition().getName().toString(), 
account.getCreateDate());
dtos.add(dto);
}
//HttpStatus.OK trả về status code 200
return new ResponseEntity<>(dtos, HttpStatus.OK);
}
@GetMapping(value = "/{id}")
//Lấy account theo id
public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
Account account = accountService.getAccountById(id);
AccontDto dto = new AccontDto(account.getId(), account.getEmail(), 
account.getUsername(), account.getFullname(),
account.getDepartment().getName(), 
account.getPosition().getName().toString(), account.getCreateDate());
return new ResponseEntity<AccontDto>(dto, HttpStatus.OK);
}
//•	@PostMapping sẽ tạo cho chúng ta 1 API với method là POST, thường dùng để cho việc tạo, thêm mới dữ liệu
//	Thường kết hợp với @PostMapping sẽ là @RequestBody dùng để nhận data của body request mà phía client gửi lên.
//@RequestBody được sử dụng để lấy các giá trị mà người dùng gửi lên server mà các giá trị đó được chứa trong phần thân (body) của request
@PostMapping()
// Tạo mới 1 department, có trả về trạng tháo status code 201 Created
public ResponseEntity<?> createDepartment(@RequestBody AccountFormForCreating form) {
accountService.createAccount(form);
return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
}
//@PutMapping sẽ tạo cho chúng ta 1 API với method là Put, thường dùng để cập nhật dữ liệu
//@PathVariable được sử dụng để xử lý những URI động, có một hoặc nhiều parameter trên URI.
@PutMapping(value = "/{id}")
//Cập nhật Department có trả về trạng thái 200 ok
public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
@RequestBody AccountFormForUpdating form) {
accountService.updateAccount(id, form);
return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
}
//@DeleteMapping sẽ tạo cho chúng ta 1 API với method là delete, thường dùng để xóa dữ liệu
@DeleteMapping(value = "/{id}")
//Xóa  account , trả về trạng thái 200 ok
public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
accountService.deleteAccount(id);
return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
}
}
