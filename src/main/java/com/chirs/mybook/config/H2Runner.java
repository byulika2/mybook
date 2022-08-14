package com.chirs.mybook.config;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class H2Runner implements ApplicationRunner {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public void run(ApplicationArguments args) {
    List<String> sqlList = List.of(
        "insert into member (name) values  ('허선행');",
        "insert into product (name, month_price, year_price) values  ('basic', 9500, 108000);",
        "insert into payment_card (member_id, card_name, card_no, bank_name, billing_key) values (1, '올인원', '1234-****-****-6789', '국민', '123456');"
    );

    for (String sql : sqlList) {
      jdbcTemplate.execute(sql);
      log.info("sql execute for jdbcTemplate : {}", sql);
    }

  }
}
