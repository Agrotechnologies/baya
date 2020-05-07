package com.cb.baya.user;//package com.cbsolutions.smartfarmer.user;
//
//import com.cbsolutions.smartfarmer.common.ApiResponse;
//import com.cbsolutions.smartfarmer.common.CrudApi;
//import com.cbsolutions.smartfarmer.common.PaginationResult;
//import com.cbsolutions.smartfarmer.config.TypeMapper;
//import com.cbsolutions.smartfarmer.exception.BusinessException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//@RestController
//@RequestMapping("/user")
//@RequiredArgsConstructor
//public class UserApi implements CrudApi<UserDTO> {
//
//    private final UserService userService;
//    private final TypeMapper mapper;
//
//    @Override
//    public ApiResponse<UserDTO> create(UserDTO userDTO) {
//        log.info("Create User :{}", userDTO);
//        final User user = userService.saveUser(mapper.map(userDTO));
//        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(user));
//    }
//
//    @Override
//    public ApiResponse<UserDTO> update(UserDTO userDTO) {
//        log.info("Create User :{}", userDTO);
//        final User user = userService.saveUser(mapper.map(userDTO));
//        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(user));
//    }
//
//    @Override
//    public ApiResponse<UserDTO> delete(UserDTO userDTO) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse<PaginationResult<UserDTO>> findAll(String search, Integer page, Integer size, String sortBy) {
//        List<UserDTO> userDTOS = userService.findAll(page, size, sortBy)
//                .stream()
//                .map(mapper::map)
//                .collect(Collectors.toList());
//        PaginationResult<UserDTO> pagedUser = PaginationResult.pagination(userDTOS, userService.total(), page, size);
//        return new ApiResponse<>(HttpStatus.OK.value(), pagedUser);
//    }
//
//    @Override
//    public ApiResponse<UserDTO> find(Long id) {
//        final User user = userService.findById(id).orElseThrow(() -> new BusinessException("User with id : " + id + "  not found"));
//        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(user));
//    }
//
//}
