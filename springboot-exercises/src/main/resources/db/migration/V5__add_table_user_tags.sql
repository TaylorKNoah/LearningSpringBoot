CREATE TABLE `store`.`tag` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `store`.`user_tags` (
  `user_id` BIGINT NOT NULL,
  `tag_id` BIGINT NOT NULL,
  INDEX `fk_usertag_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_usertag_tag_idx` (`tag_id` ASC) VISIBLE,
  UNIQUE INDEX `uk_user_tag` (`user_id` ASC, `tag_id` ASC) VISIBLE,
  CONSTRAINT `fk_usertag_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `store`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usertag_tag`
    FOREIGN KEY (`tag_id`)
    REFERENCES `store`.`tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);