package com.clean.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataProviderConfig {



    @Bean
    public MemberDataProvider memberDataProvider(MemberRepository memberRepository){
        return new MemberDataProvider(memberRepository);
    }

}