package com.clean.example.configuration;
import com.clean.example.usecase.GetMemberDetails;
import com.clean.example.usecase.MainUseCase;
import com.clean.example.dataproviders.MemberDataProvider;
import com.clean.example.dataproviders.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = "com.clean.example.dataproviders")
public class Config {

    @Bean
    public MainUseCase mainUseCase(GetMemberDetails getMemberDetails){
        return new MainUseCase(getMemberDetails);
    }

    @Bean
    public MemberDataProvider memberDataProvider(MemberRepository memberRepository){
        return new MemberDataProvider(memberRepository);
    }

}
