package S15_19.backend.service;

import S15_19.backend.model.UserEntity;
import S15_19.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    /* Este metodo permite que spring en segundo plano busque si el usuario existe en la base de datos
     * Su función principal es cargar los detalles de un usuario a partir de su nombre de usuario, para ser utilizado en el proceso de autenticación. */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario "+username+" no existe"));

        //Creacion de roles
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        //Añadimos roles a la lista authorityList
        authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(userEntity.getRole().name())));

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isAccountNonLocked(),
                authorityList);
    }
}

