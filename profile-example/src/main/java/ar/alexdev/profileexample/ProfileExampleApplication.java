package ar.alexdev.profileexample;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProfileExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileExampleApplication.class, args);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<Message> getMessage() {
		return ResponseEntity.ok(Message.newInstance(UUID.randomUUID(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", LocalDate.now()));
	}

}
