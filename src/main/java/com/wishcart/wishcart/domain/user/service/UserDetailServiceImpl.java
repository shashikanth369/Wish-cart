package com.wishcart.wishcart.domain.user.service;

import com.wishcart.wishcart.domain.user.persistence.UserEntity;
import com.wishcart.wishcart.domain.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl //implements UserDetailsService
        {
    /*@Autowired
    private UserRepository userRepository;
*/

  /*  @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("User not found with userName:"+username);
        }
    }*/
}
