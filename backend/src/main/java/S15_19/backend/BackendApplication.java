package S15_19.backend;

import S15_19.backend.model.Role;
import S15_19.backend.model.UserEntity;
import S15_19.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(UserRepository userRepository){
//		return args -> {
//
//			//CREATE USERS
//			UserEntity userElian = UserEntity.builder()
//					.username("elian")
//					.firstName("elian")
//					.lastName("bargaz")
//					.country("argentina")
//					.password("$2a$10$Rn5dqssiYpaiRiKA30Hi..3ZU38waxJ.JAcoPwV06nSk06S6Vk6ly")
//					.role(Role.valueOf("ADMIN"))
//					.build();
//			UserEntity userValen = UserEntity.builder()
//					.username("elian2")
//					.firstName("elian2")
//					.lastName("bargaz2")
//					.country("argentina2")
//					.password("$2a$10$Rn5dqssiYpaiRiKA30Hi..3ZU38waxJ.JAcoPwV06nSk06S6Vk6ly")
//					.role(Role.valueOf("USER"))
//					.build();
//
//			userRepository.saveAll(List.of(userElian, userValen));
//		};
//	}

}
