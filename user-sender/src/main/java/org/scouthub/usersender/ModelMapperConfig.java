package org.scouthub.usersender;

import org.modelmapper.ModelMapper;
import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.infraestructure.kafka.mapper.UserKafkaMapper;
import org.scouthub.usersender.infrastructure.kafka.avro.UserValue;
import org.springframework.context.annotation.Bean;

public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public UserKafkaMapper userKafkaMapper() {
//        return new UserKafkaMapper() {
//            @Override
//            public UserValue userToUserValue(User user) {
//                return null;
//            }
//        };
//    }
}
