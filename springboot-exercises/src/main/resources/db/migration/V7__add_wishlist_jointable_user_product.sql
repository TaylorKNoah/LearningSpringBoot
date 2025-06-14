CREATE TABLE `store`.`wishlist` (
  `user_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  INDEX `Primary_Key` (`user_id` ASC, `product_id` ASC) INVISIBLE,
  INDEX `FK_wishlist_product_idx` (`product_id` ASC) INVISIBLE,
  UNIQUE INDEX `Unique_Constraint` (`user_id` ASC, `product_id` ASC) VISIBLE,
  CONSTRAINT `FK_wishlist_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `store`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_wishlist_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `store`.`products` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION);
