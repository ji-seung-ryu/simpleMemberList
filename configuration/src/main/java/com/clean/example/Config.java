package com.clean.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
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
