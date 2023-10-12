package org.scouthub.uservalidator.infraestructure.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserListener {
  //  @Autowired UserServiceImpl userService;
  //
  //  @Autowired VerifyUser verifyUser;
  //
  //  @StreamListener()
  //  @SendTo(BinderProcessor.USER_VALIDATED)
  //  public KStream<UserValidatedKey, UserValidatedValue> users(
  //      @Input(BinderProcessor.USER) KStream<UserKey, UserValue> users) {
  //    log.debug("User received by kafka topic");
  //    return users.flatMap(
  //        (userKey, userValue) -> {
  //          log.debug("UserKey {}, UserValue {}", userKey, userValue);
  //          List<KeyValue<UserValidatedKey, UserValidatedValue>> result = new LinkedList<>();
  //          if ((userValue == null)) {
  //            log.debug("User is a tombstone");
  //            DeleteUser.delete(userKey.getId(), userService);
  //            result.add(KeyValue.pair(new UserValidatedKey(userKey.getId()), null));
  //          } else {
  //            log.debug("User is not a tombstone");
  //
  //            User user =
  //                new User(
  //                    userValue.getId(),
  //                    userValue.getName(),
  //                    userValue.getAge(),
  //                    userValue.getBranch());
  //
  //            // Verify age and branch
  //            if (!verifyUser.isValidUser(user)) {
  //              DeleteUser.delete(userKey.getId(), userService);
  //              result.add(KeyValue.pair(new UserValidatedKey(userKey.getId()), null));
  //              return result;
  //            }
  //
  //            CreateUser.create(user, userService);
  //
  //            UserValidatedValue userValidatedValue =
  //                new UserValidatedValue(
  //                    userValue.getId(),
  //                    userValue.getName(),
  //                    userValue.getAge(),
  //                    userValue.getBranch());
  //
  //            result.add(KeyValue.pair(new UserValidatedKey(userKey.getId()),
  // userValidatedValue));
  //          }
  //          return result;
  //        });
  //  }
}
