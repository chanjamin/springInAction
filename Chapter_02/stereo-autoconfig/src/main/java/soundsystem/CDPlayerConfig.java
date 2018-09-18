package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"soundsystem"})

public class CDPlayerConfig {


    @Bean
    public MediaPlayer cdplayer(CompactDisc disc){
       return new CDPlayer(disc);
    }

    @Bean
    public CompactDisc SgtPeppers(){
        return new SgtPeppers();
    }

}
