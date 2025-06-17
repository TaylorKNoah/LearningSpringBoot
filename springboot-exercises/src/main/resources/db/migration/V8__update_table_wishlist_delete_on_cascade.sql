ALTER TABLE `store`.`wishlist`
DROP FOREIGN KEY `FK_wishlist_product`,
DROP FOREIGN KEY `FK_wishlist_user`;
ALTER TABLE `store`.`wishlist`
ADD CONSTRAINT `FK_wishlist_product`
  FOREIGN KEY (`product_id`)
  REFERENCES `store`.`products` (`id`)
  ON DELETE CASCADE,
ADD CONSTRAINT `FK_wishlist_user`
  FOREIGN KEY (`user_id`)
  REFERENCES `store`.`users` (`id`)
  ON DELETE CASCADE;
