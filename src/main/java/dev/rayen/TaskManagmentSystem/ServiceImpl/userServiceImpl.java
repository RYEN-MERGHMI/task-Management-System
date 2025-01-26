/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:23.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.ServiceImpl;

import dev.rayen.TaskManagmentSystem.dto.userDTO;
import dev.rayen.TaskManagmentSystem.entity.user;
import dev.rayen.TaskManagmentSystem.exception.CustomException;
import dev.rayen.TaskManagmentSystem.exception.ErrorCode;
import dev.rayen.TaskManagmentSystem.mapper.UserMapper;
import dev.rayen.TaskManagmentSystem.repository.UserRepository;
import dev.rayen.TaskManagmentSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public user registerUser(userDTO userDTO) {
        if (userRepository.findByEmail(userDTO.email()).isPresent()){
            throw  new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }
        user user = UserMapper.toEntity(userDTO);
        return userRepository.save(user);
    }

    @Override
    public user loginUser(String usernames, String password) {
        user user = userRepository
                .findByUsername(usernames)
                .orElseThrow(()->new CustomException(ErrorCode.USER_NOT_FOUND));

        if(!user.getPassword().equals(password)){
            throw new CustomException(ErrorCode.INVALID_CREDENTIALS);
        }
        return user;
    }

    @Override
    public user getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
