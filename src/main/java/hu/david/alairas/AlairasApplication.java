package hu.david.alairas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlairasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlairasApplication.class, args);
	}

}




/* db info


Host
ec2-46-137-120-243.eu-west-1.compute.amazonaws.com
Database
d2vus8chuulrbn
User
wjhshpewgcgbdg
Port
5432
Password
5a44df86cc0d449ccdcdda6b994ef50433a4a945eacd4cacda02ef5d9693d6c2
URI
postgres://wjhshpewgcgbdg:5a44df86cc0d449ccdcdda6b994ef50433a4a945eacd4cacda02ef5d9693d6c2@ec2-46-137-120-243.eu-west-1.compute.amazonaws.com:5432/d2vus8chuulrbn
Heroku CLI
heroku pg:psql postgresql-shaped-77444 --app alairas


 */
