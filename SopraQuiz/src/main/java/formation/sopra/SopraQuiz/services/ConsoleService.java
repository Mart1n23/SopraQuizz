package formation.sopra.SopraQuiz.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Initialisation réussie !");
		
	}

}
